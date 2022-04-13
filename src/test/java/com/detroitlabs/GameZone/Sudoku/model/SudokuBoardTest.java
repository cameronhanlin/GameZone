package com.detroitlabs.GameZone.Sudoku.model;

import com.detroitlabs.GameZone.Sudoku.service.SudokuService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {
    private static SudokuBoard sudokuBoard;

    @BeforeAll
    public static void setup() {
        sudokuBoard = new SudokuBoard();
        sudokuBoard.generateNewBoard();
    }

    @Test
    void Return_Board_From_API() {
        sudokuBoard.printBoard();
        System.out.println("-----");
        sudokuBoard.printSolvedBoard();
        assertNotNull(sudokuBoard.getBoard());
    }


    @Test
    void Return_True_Given_Number_In_Row() {
        assertTrue(sudokuBoard.isNumberInRow(1, 0));
    }

    @Test
    void Return_False_Given_Number_Not_In_Row() {
        assertFalse(sudokuBoard.isNumberInRow(10, 0));
    }

    @Test
    void Return_True_Given_Number_In_Col() {
        assertTrue(sudokuBoard.isNumberInCol(1, 0));
    }

    @Test
    void Return_False_Given_Number_Not_In_Col() {
        assertFalse(sudokuBoard.isNumberInCol(10, 0));
    }

    @Test
    void Return_True_Given_Number_In_Subgrid() {
        assertTrue(sudokuBoard.isNumberInSubgrid(1, 1, 1));
    }

    @Test
    void Return_False_Given_Number_Not_In_Subgrid() {
        assertFalse(sudokuBoard.isNumberInSubgrid(0, 0, 10));
    }

    @Test
    void Return_Solved_Board_Given_Valid_Board() {
        sudokuBoard.solveBoard();
    }

    @Test
    void Return_True_Given_Solved_Board() {
       //TODO
    }

    @Test
    void Return_False_Given_Unsolved_Board() {
        SudokuBoard unsolvedBoard = new SudokuBoard();
        unsolvedBoard.generateNewBoard();

        assertFalse(unsolvedBoard.isBoardSolved());
    }

}