import completion.RandomFiller;
import game.Board;
import rules.Rules;

//GitHub Branch Test

public class Main {

    public static void main(String[] args){
        //Testsudoku:
        //Zum "Löschen" von Zellen einfach eine Null einfügen
        int[] sudokuArray =
        {
        5,3,4,6,7,8,0,1,2,
        6,0,2,1,9,5,3,4,0,
        1,9,8,3,0,2,5,6,7,
        8,5,9,7,6,1,4,2,3,
        4,0,6,8,0,3,7,9,1,
        7,0,0,9,2,4,8,5,6,
        9,6,1,5,0,7,2,8,4,
        2,0,7,0,1,9,6,3,5,
        3,4,5,2,8,6,1,7,9
        };




        System.out.println("Sudoku.");
        Board board = new Board();
        for(int i = 0; i < 81; i++){
            board.setCellValue(i, sudokuArray[i]);
        }

        board.printBoard();

        RandomFiller.fillBoard(board);
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
     */
}
