import completion.RandomFiller;
import game.Board;

import java.util.Random;

public class TestRun {
    String fickdich;
    RandomFiller randomFiller;

    public TestRun(String fick){
        fickdich = fick;
    }

    public void fuck(){
        //Testsudoku:
        //Zum "Löschen" von Zellen einfach eine Null einfügen
        int[] sudokuArray =
            {
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0
            };
        System.out.println("Sudoku.");
        Board board = new Board();
        for(int i = 0; i < 81; i++){
            board.setCellValue(i, sudokuArray[i]);
        }
        randomFiller = new RandomFiller();
        randomFiller.fillBoard(board);
    }

    /*
    Testsudoku:
    534 678 912
    672 195 348
    198 342 567

    859 761 423
    426 853 791
    713 924 856

    961 537 284
    287 419 635
    345 286 179

    sehr schwer:
                0,0,0,0,2,0,0,7,0,
                0,0,0,0,3,4,0,0,0,
                3,5,8,0,0,0,0,0,0,
                5,0,4,8,0,0,0,0,0,
                0,0,0,1,0,0,0,8,9,
                0,0,2,0,0,0,0,0,6,
                2,4,0,0,0,0,7,0,0,
                0,9,0,0,0,5,2,0,0,
                0,0,0,0,6,7,1,0,0

     */

}
