package com.detroitlabs.GameZone.Sudoku.model;

import com.detroitlabs.GameZone.Sudoku.service.SudokuService;

import java.util.ArrayList;

public class SudokuBoard {
    ArrayList<ArrayList<SudokuTile>> board = new ArrayList<>();

    public ArrayList<ArrayList<SudokuTile>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<SudokuTile>> board) {
        this.board = board;
    }

    public void generateNewBoard() {
        int[][] rawBoard = SudokuService.getRawBoard().getBoard();

        for (int[] row : rawBoard) {
            ArrayList<SudokuTile> currentRow = new ArrayList<>();
            for (int number : row) {
                currentRow.add(new SudokuTile(number));
            }
            board.add(currentRow);
        }
    }

    public void printBoard() {
        for (ArrayList<SudokuTile> row : board) {
            for (SudokuTile title : row) {
                System.out.print(title.getActualNumber());
            }
            System.out.println(" ");
        }
    }


}
