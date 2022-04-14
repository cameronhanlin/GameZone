package com.detroitlabs.GameZone.Sudoku.model;

public class SudokuTile {

    private int actualNumber; //user input
    private int expectedNumber; // correct number
    private boolean fixedNumber;
    private boolean notZero;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(boolean fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public SudokuTile(int id, int actualNumber, int expectedNumber, boolean fixedNumber) {
        this.actualNumber = actualNumber;
        this.expectedNumber = expectedNumber;
        this.fixedNumber = fixedNumber;
        this.id = id;
        this.notZero = false;


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

    public boolean isNotZero() {
        return notZero;
    }

    public void setNotZero(boolean notZero) {
        this.notZero = notZero;
    }
}
