import completion.RandomFiller;
import game.Board;
import rules.Rules;

public class Main {

    public static void main(String[] args){
        System.out.println("Sudoku.");
        Board board = new Board();
        board.printBoard();
        /*
        board.setCellValue(4, 5);
        board.setCellValue(14, 7);
        board.setCellValue(49, 9);
        board.setCellValue(41, 9);
        board.setCellValue(76, 9);
        */
        RandomFiller.fillBoard(board);
    }
}
