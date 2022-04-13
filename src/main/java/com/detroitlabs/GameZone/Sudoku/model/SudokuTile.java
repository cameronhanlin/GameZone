package com.detroitlabs.GameZone.Sudoku.model;

public class SudokuTile {
    int actualNumber; //user input
    int expectedNumber; // correct number
    boolean fixedNumber;

    public boolean isFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(boolean fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public SudokuTile(int actualNumber, int expectedNumber, boolean fixedNumber) {
        this.actualNumber = actualNumber;
        this.expectedNumber = expectedNumber;
        this.fixedNumber = fixedNumber;

    }

    public int getExpectedNumber() {
        return expectedNumber;
    }

    public void setExpectedNumber(int expectedNumber) {
        this.expectedNumber = expectedNumber;
    }

    public int getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(int actualNumber) {
        this.actualNumber = actualNumber;
    }
}
