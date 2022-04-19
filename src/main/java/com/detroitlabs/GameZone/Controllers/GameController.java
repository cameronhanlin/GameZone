package com.detroitlabs.GameZone.Controllers;

import com.detroitlabs.GameZone.Data.UserRepository;
import com.detroitlabs.GameZone.Model.User;
import com.detroitlabs.GameZone.Sudoku.SudokuController.SudokuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GameController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SudokuController sudokuController;


    @GetMapping("/login")
    public String getLoginPage() {

        return "login";
    }

    @PostMapping("/register")
    public String handleRegistration(@RequestParam Map<String, String> userInput) {
        User user = new User(userInput.get("name"), userInput.get("email"), userInput.get("name"), userInput.get("password"));
        userRepository.getUsers().add(user);

        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam Map<String, String> userInput, ModelMap modelMap) {
        String email = userInput.get("email");
        String password = userInput.get("password");

        for (User user : userRepository.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return sudokuController.displaySudokuHome(modelMap);
            }
        }
        modelMap.put("email_validation", "false");
        return "login";
    }

}
