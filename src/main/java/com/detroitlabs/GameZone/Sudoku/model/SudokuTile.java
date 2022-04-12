package com.detroitlabs.GameZone.Sudoku.model;

public class SudokuTile {


    //All of our Game tiles


    int actualNumber;

    public SudokuTile(int givenNum) {
        this.actualNumber = givenNum;
    }

    public int getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(int actualNumber) {
        this.actualNumber = actualNumber;
    }
}
