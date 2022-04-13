package com.detroitlabs.GameZone.Sudoku.service;


import com.detroitlabs.GameZone.Sudoku.data.SudokuRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SudokuService {

    //https://sugoku.herokuapp.com/board?difficulty=easy

    public static SudokuRepository getRawBoard() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://sugoku.herokuapp.com/board?difficulty=easy", SudokuRepository.class);

    }


}
