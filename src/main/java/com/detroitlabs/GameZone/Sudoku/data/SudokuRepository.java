package com.detroitlabs.GameZone.Sudoku.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class SudokuRepository {
    int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int number : row) {
                System.out.print(number);
            }
            System.out.println(" ");
        }
    }
}

