package completion;
import game.*;
import rules.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class RandomFiller {
    private static boolean searching;
    private static Board solution;

    public static void fillBoard(Board board){
        board.printBoard();
        if(Rules.isWinningBoard(board)){
            System.out.print("The given board is already completed! :D");
        } else {
            fillBoardRecursion(board, true);
        }
        System.out.println("The solution is:");
        solution.printBoard();
    }

    public static void fillBoardRecursion(Board board, boolean s){
        //Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        searching = s;
        board.printBoard();
        ArrayList<Integer> possibleIDs = board.getEmptyCellIDs();
        while(possibleIDs.size() > 0 && searching){
            board.printBoard();
            System.out.println("there are " + possibleIDs.size() + " possible IDs.");
            int randomIndex = (int) (Math.random() * (possibleIDs.size() - 1));
            System.out.println("cell no. " + possibleIDs.get(randomIndex) + " has been chosen.");
            ArrayList<Integer> possibleIntegers = IntegerHelper.getPossibleIntegers(board, possibleIDs.get(randomIndex));
            while(possibleIntegers.size() > 0 && searching){
                System.out.println("There are " + possibleIntegers.size() + " possible Integers");
                int randomIntegerIndex = (int)(Math.random() * (possibleIntegers.size() - 1));
                System.out.println("Integer-value no. " + possibleIntegers.get(randomIntegerIndex) + " has been chosen.");
                board.setCellValue(possibleIDs.get(randomIndex), possibleIntegers.get(randomIntegerIndex));
                possibleIntegers.remove(randomIntegerIndex);
                if(Rules.isWinningBoard(board)){
                    searching = false;
                    solution = board.getCopy();
                } else {
                    fillBoardRecursion(board, true);
                    board.setCellValue(possibleIDs.get(randomIndex), 0);
                }
            }
            possibleIDs.remove(randomIndex);
        }


    }

}
