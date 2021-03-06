package com.detroitlabs.GameZone.Sudoku.SudokuController;

import com.detroitlabs.GameZone.Sudoku.model.SudokuBoard;
import com.detroitlabs.GameZone.Sudoku.model.SudokuTile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SudokuController {

    @Autowired
    SudokuBoard sudokuBoard;
    boolean usingPen = true;

    //int actualNumber; from the user
    //int expectedNumber; correct number
    //boolean fixedNumber; fixed number

    //Controller for Sudoku Game??

    //the homepage
    @RequestMapping("/")
    public String displaySudokuHome(ModelMap modelMap){
        modelMap = cycleModelMaps(modelMap);
        return "sudoku";
    }

    @RequestMapping("/startNewGame")
    public String startNewGame(ModelMap modelMap){
        //sudokuBoard.testBoard(); this is useless now
        sudokuBoard.generateNewBoard();//this is better
        System.out.println("New Game made");
        modelMap = cycleModelMaps(modelMap);
        return "sudoku";
    }

    @RequestMapping("/switchTool")
    public String switchWritingTool(ModelMap modelMap){
        usingPen = !usingPen;
        System.out.println("Tool switched");
        modelMap = cycleModelMaps(modelMap);

        return "sudoku";
    }

    @RequestMapping("/UserMove/{tileID}")
    public String makePlayerMove(@PathVariable String tileID, @RequestParam String makeMark, ModelMap modelMap){
        System.out.println("tile number "+tileID);
        System.out.println("Mark it a "+ makeMark);

        if(makeMark.matches("[0-9]") && makeMark.length()==1){
            sudokuBoard.updateCell(Integer.valueOf(tileID), Integer.valueOf(makeMark));
        }

        modelMap = cycleModelMaps(modelMap);

        //check makeMark check that its actually a number
        //if its a good number set the tile and number to change it?
        //make it pretty
        return "sudoku";
    }

    @RequestMapping("/PencilMark/{tileID}")
    public String addPencilMark(@PathVariable String tileID, @RequestParam String makeMark, ModelMap modelMap){
        if(makeMark.matches("[0-9]") && makeMark.length()==1){
            sudokuBoard.addPencilCell(Integer.valueOf(tileID), Integer.valueOf(makeMark));

        }
        modelMap = cycleModelMaps(modelMap);
        return "sudoku";
    }

    @RequestMapping("/SolvePuzzle")
    public String makePuzzleSolved(ModelMap modelMap){
        sudokuBoard.makeBoardSolved();
        modelMap = cycleModelMaps(modelMap);
        return "sudoku";
    }

    //all modelMaps are built in this method.
    public ModelMap cycleModelMaps(ModelMap modelMap){
        modelMap.put("theBoard", convertToNineThreeByThree(sudokuBoard.getBoard()));
        modelMap.put("writingTool", usingPen);
        modelMap.put("winCondition", sudokuBoard.isBoardSolved());


        return modelMap;
    }

    public ArrayList<ArrayList<SudokuTile>> convertToNineThreeByThree(ArrayList<ArrayList<SudokuTile>> theBoard){
        ArrayList<ArrayList<SudokuTile>> tempBoard = new ArrayList<>();

        if (sudokuBoard.getBoard().size()<8){
            sudokuBoard.generateNewBoard();
            theBoard = sudokuBoard.getBoard();
        }


        for(int g=0;g<9;g=g+3) {
            for (int h = 0; h < 9; h = h + 3) {
                ArrayList<SudokuTile> tempBox = new ArrayList<>();
                for (int i = g; i < (g+3); i++) {
                    for (int j = h; j < (h + 3); j++) {
                        tempBox.add(theBoard.get(i).get(j));
                    }
                }
                tempBoard.add(tempBox);
            }
        }
        return tempBoard;
    }



}
