package com.detroitlabs.GameZone.Sudoku.model;

public class SudokuTile {


    //All of our Game tiles


    int givenNum;

    public SudokuTile(int givenNum) {
        this.givenNum = givenNum;
    }

    public int getGivenNum() {
        return givenNum;
    }

    public void setGivenNum(int givenNum) {
        this.givenNum = givenNum;
    }
}
