package completion;
import game.*;
import rules.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public  class RandomFiller {
    private boolean searching;
    private Board solution;
    CellTupleSort cellTupleSort;

    public RandomFiller(){
    cellTupleSort = new CellTupleSort();
    }

    public void fillBoard(Board board){
        System.out.println("Trying to solve the following Sudoku:");
        board.printBoard();
        if(Rules.isWinningBoard(board)){
            System.out.print("The given board is already completed! :D");
        } else {
            fillBoardRecursion(board, true, 0);
        }
        if(solution != null) {
            System.out.println("The random solution is:");
            solution.printBoard();
        } else {
            System.out.println("No Solution found! Me is-a sorry!");
        }
    }

    public void fillBoardRecursion(Board board, boolean s, int recursionDepth){
        searching = s;
        recursionDepth++;
        //System.out.println("RecursionDepth: " + recursionDepth);
        if(Rules.isWinningBoard(board)){
            searching = false;
            solution = board.getCopy();
        }
        //Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        //board.printBoard();
        ArrayList<Integer> possibleIDs = board.getEmptyCellIDs();
        ArrayList<CellTuple> cellTuples = new ArrayList<CellTuple>();
        for(int i = 0; i < possibleIDs.size(); i++){
            cellTuples.add(new CellTuple(board, possibleIDs.get(i)));
            //cellTuples.get(i).printCellTuple();
        }
        cellTupleSort.sortCellTuples(cellTuples);
        boolean solvable = true;
        while (searching && solvable){
            /*
            System.out.println("CellTuples sorted: ");
            for(int i = 0; i < cellTuples.size(); i++){
                cellTuples.get(i).printCellTuple();
            }
            */
            if(cellTuples.get(0).getPossibleIntegers().size() == 0){
                //System.out.println("This shit is not solvable!!11elf");
                solvable = false;
            } else{
                board.setCellValue(cellTuples.get(0).getCellID(), cellTuples.get(0).possibleIntegers.get(0));
                fillBoardRecursion(board, searching, recursionDepth);
                board.setCellValue(cellTuples.get(0).getCellID(), 0);
                cellTuples.get(0).possibleIntegers.remove(0);
            }
        }




    }

}
