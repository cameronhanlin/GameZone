package com.detroitlabs.GameZone.Sudoku.model;

import com.detroitlabs.GameZone.Sudoku.service.SudokuService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SudokuBoard {
    ArrayList<ArrayList<SudokuTile>> board = new ArrayList<>();

    public ArrayList<ArrayList<SudokuTile>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<SudokuTile>> board) {
        this.board = board;
    }

    public void generateNewBoard() {
        board.clear();

        int idCounter = 1;
        int[][] rawBoard = SudokuService.getRawBoard().getBoard();

        for (int[] row : rawBoard) {
            ArrayList<SudokuTile> currentRow = new ArrayList<>();
            for (int number : row) {
                if (number != 0) {
                    currentRow.add(new SudokuTile(idCounter, number, number, true));
                } else {
                    currentRow.add(new SudokuTile(idCounter, number, number, false));
                }
                idCounter++;
            }
            board.add(currentRow);
        }
        solveBoard();
    }

    public void printBoard() {
        for (ArrayList<SudokuTile> row : board) {
            for (SudokuTile tile : row) {
                System.out.print(tile.getActualNumber());
            }
            System.out.println(" ");
        }
    }

    public void printSolvedBoard() {
        for (ArrayList<SudokuTile> row : board) {
            for (SudokuTile tile : row) {
                System.out.print(tile.getExpectedNumber());
            }
            System.out.println(" ");
        }
    }



    public boolean isNumberInRow(int number, int row) {
        for (int col = 0; col < 9; col++) {
            if (board.get(row).get(col).getExpectedNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInCol(int number, int col) {
        for (int row = 0; row < 9; row++) {
            if (board.get(row).get(col).getExpectedNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInSubgrid(int row, int col, int number) {
        int row0 = row - row % 3;
        int col0 = col - col % 3;

        for (int i = row0; i < 3; i++) {
            for (int j = col0; j < 3; j++) {
                if (board.get(i).get(j).getExpectedNumber() == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateCell(int row, int col, int number) {
        board.get(row).get(row).setActualNumber(number);
    }

    public boolean validMove(int row, int col, int number) {
        return !isNumberInRow(number, row) && !isNumberInCol(number, col) && !isNumberInSubgrid(row, col, number);
    }


    /**
     * This method uses the backtracking algorithm to find a single solution to the current sudoku board
     * if board is solvable method returns true else false
     *
     * @return boolean
     */
    public boolean solveBoard() {
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.get(0).size(); col++) {
                if (board.get(row).get(col).getExpectedNumber() == 0) {
                    for (int potentialNumber = 1; potentialNumber <= 9; potentialNumber++) {
                        if (validMove(row, col, potentialNumber)) {
                            board.get(row).get(col).setExpectedNumber(potentialNumber);
                            if (solveBoard() == true) {
                                return true;
                            } else {
                                board.get(row).get(col).setExpectedNumber(0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardSolved() {
        for(ArrayList<SudokuTile> row : board) {
            for (SudokuTile tile : row) {
                if (tile.getActualNumber() != tile.getExpectedNumber()) {
                    return false;
                }
            }
        }
        return true;
    }


}
