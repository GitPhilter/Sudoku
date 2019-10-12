package rules;

import game.*;

public abstract class Rules {

    public static boolean isWinningBoard(Board board){
        if(isFullBoard(board) && isValidBoard(board)){
            return true;
        }
        return false;
    }

    public static boolean isValidBoard(Board board){
        if(!areValidColumns(board)){
            return false;
        }
        if(!areValidLines(board)){
            return false;
        }
        if(!areValidFields(board)){
            return false;
        }
        return true;
    }

    public static boolean areValidColumns(Board board){
        int[] array = {0,0,0,0,0,0,0,0,0};
        for(int c = 0; c < 9; c++){
            for(int a = 0; a < 9; a++){
                array[a] = board.cells.get(c + a * 9).value;
            }
            if(!isValidArray(array)){
                System.out.println("Column no. " + c + " is not valid!");
                return false;
            }
        }
        return true;
    }

    public static boolean areValidLines(Board board){
        int[] array = {0,0,0,0,0,0,0,0,0};
        for(int l = 0; l < 9; l++){
            for(int a = 0; a < 9; a++){
                array[a] = board.cells.get(l * 9 + a).value;
            }
            if(!isValidArray(array)){
                System.out.println("Line no. " + l + " is not valid!");
                return false;
            }
        }
        return true;
    }

    public static boolean areValidFields(Board board){
        int[] array = {0,0,0,0,0,0,0,0,0};
        int startingIndex = 0;
        for(int field = 0; field < 9; field++){
            switch (field){
                case 0:
                    startingIndex = 0;
                    break;
                case 1:
                    startingIndex = 3;
                    break;
                case 2:
                    startingIndex = 6;
                    break;
                case 3:
                    startingIndex = 27;
                    break;
                case 4:
                    startingIndex = 30;
                    break;
                case 5:
                    startingIndex = 33;
                    break;
                case 6:
                    startingIndex = 54;
                    break;
                case 7:
                    startingIndex = 57;
                    break;
                case 8:
                    startingIndex = 60;
                    break;
                default:
                    break;
            }
            array[0] = board.cells.get(startingIndex).value;
            array[1] = board.cells.get(startingIndex + 1).value;
            array[2] = board.cells.get(startingIndex + 2).value;
            array[3] = board.cells.get(startingIndex + 9).value;
            array[4] = board.cells.get(startingIndex + 10).value;
            array[5] = board.cells.get(startingIndex + 11).value;
            array[6] = board.cells.get(startingIndex + 18).value;
            array[7] = board.cells.get(startingIndex + 19).value;
            array[8] = board.cells.get(startingIndex + 20).value;
            if(!isValidArray(array)) {
                System.out.println("Field no. " + field + " is not valid!");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidArray(int[] array){
        for(int i = 0; i < 8; i++){
            for(int k = i + 1; k < 9; k++){
                if(array[i] != 0 && array[i] == array[k]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isFullBoard(Board board){
        for(int c = 0; c < 81; c++){
            if (board.cells.get(c).value == 0){
                return false;
            }
        }
        return true;
    }

}
