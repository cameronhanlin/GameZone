package com.detroitlabs.GameZone.Sudoku.service;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SudokuGenerator {


    //https://sugoku.herokuapp.com/board?difficulty=easy

    public SudokuRepository getPhrase() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://sugoku.herokuapp.com/board?difficulty=easy", SudokuRepository.class);
    }


}
