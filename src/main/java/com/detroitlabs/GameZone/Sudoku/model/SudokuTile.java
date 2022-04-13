package com.detroitlabs.GameZone.Sudoku.model;

import java.util.Random;

public class SudokuTile {


    //All of our Game tiles


    int actualNumber;
    boolean fixedNumber;
    Random rand = new Random();
    int id;

    public SudokuTile(int givenNum, int id) {
        int x = rand.nextInt(2);
        if( x==0 ){
            actualNumber = 0;
            fixedNumber = false;
        } else {
            this.actualNumber = givenNum;
            fixedNumber = true;
        }
        this.id = id;

    }

    public int getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(int actualNumber) {
        this.actualNumber = actualNumber;
    }

    public boolean isFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(boolean fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
