package com.detroitlabs.GameZone.Sudoku.model;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuTile {

    private int actualNumber; //user input
    private int expectedNumber; // correct number
    private boolean fixedNumber;
    private boolean notZero;
    private boolean userFilled;
    private int id;
    private ArrayList<Integer> pencilMarks = new ArrayList<>();

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
        pencilMarks.clear();
        userFilled = false;

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

    public ArrayList<Integer> getPencilMarks() {
        return pencilMarks;
    }

    public void setPencilMarks(ArrayList<Integer> pencilMarks) {
        this.pencilMarks = pencilMarks;
    }

    public boolean isUserFilled() {
        return userFilled;
    }

    public void setUserFilled(boolean userFilled) {
        this.userFilled = userFilled;
    }

    public void addPencilMark(int number){
        if(!pencilMarks.contains(number)){
            pencilMarks.add(number);
            Collections.sort(pencilMarks);
        }
    }

    public void clearPencilMark(){
        pencilMarks.clear();
    }
}
