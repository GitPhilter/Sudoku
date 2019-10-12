package completion;
import game.*;
import rules.*;

import java.util.ArrayList;

public abstract class RandomFiller {


    public static void fillBoard(Board board){
        board.printBoard();
        fillBoardRecursion(board, true);

    }

    public static void fillBoardRecursion(Board board, boolean s){
        boolean searching = s;
        board.printBoard();
        //int randomID = board.emptyCellIDs.get(randomIndex).intValue();
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
                System.out.println("cell no. " + possibleIntegers.get(randomIntegerIndex) + " has been chosen.");
                board.setCellValue(possibleIDs.get(randomIndex), possibleIntegers.get(randomIntegerIndex));
                possibleIntegers.remove(randomIntegerIndex);
                if(Rules.isWinningBoard(board)){
                    searching = false;
                } else {
                    fillBoardRecursion(board, true);
                }
            }
            possibleIDs.remove(randomIndex);
        }


    }

}
