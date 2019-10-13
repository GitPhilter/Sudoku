package completion;

import game.Board;

import java.util.ArrayList;
import java.util.Collections;

public abstract class IntegerHelper {

    public static ArrayList<Integer> getPossibleIntegers(Board board, int id){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int v = 1; v < 10; v++ ){
            result.add(new Integer(v));
        }
        int columnIndex = id % 9;
        int lineIndex = 0;
        if(id < 9){
            lineIndex = 0;
        } else if (id < 18){
            lineIndex = 1;
        } else if (id < 27){
            lineIndex = 2;
        } else if (id < 36){
            lineIndex = 3;
        } else if (id < 45){
            lineIndex = 4;
        } else if (id < 54){
            lineIndex = 5;
        } else if (id < 63){
            lineIndex = 6;
        } else if (id < 72){
            lineIndex = 7;
        } else if (id < 81){
            lineIndex = 8;
        }
        int fieldIndex = 0;
        if(id == 3 || id == 4 || id == 5 || id == 12 || id == 13 || id == 14 || id == 21 || id == 22 || id == 23){
            fieldIndex = 1;
        } else if(id == 6 || id == 7 || id == 8 || id == 15 || id == 16 || id == 17 || id == 24 || id == 25 || id == 26){
            fieldIndex = 2;
        } else if(id == 27 || id == 28 || id == 29 || id == 36 || id == 37 || id == 38 || id == 45 || id == 46 || id == 47){
            fieldIndex = 3;
        } else if(id == 30 || id == 31 || id == 32 || id == 39 || id == 40 || id == 41 || id == 48 || id == 49 || id == 50){
            fieldIndex = 4;
        } else if(id == 33 || id == 34 || id == 35 || id == 42 || id == 43 || id == 44 || id == 51 || id == 52 || id == 53){
            fieldIndex = 5;
        } else if(id == 54 || id == 55 || id == 56 || id == 63 || id == 64 || id == 65 || id == 72 || id == 73 || id == 74){
            fieldIndex = 6;
        } else if(id == 57 || id == 58 || id == 59 || id == 66 || id == 67 || id == 68 || id == 75 || id == 76 || id == 77){
            fieldIndex = 7;
        } else if(id == 60 || id == 61 || id == 62 || id == 69 || id == 70 || id == 71 || id == 78 || id == 79 || id == 80){
            fieldIndex = 8;
        }
        // remove Integers that are in the corresponding line
        ArrayList<Integer> temp = board.getLine(lineIndex);
        for(int i = 0; i < temp.size(); i++){
            for(int r = 0; r < result.size(); r++){
                if(result.get(r).intValue() == temp.get(i).intValue()){
                    //System.out.println(temp.get(i).intValue() + " not allowed in line " + lineIndex);
                    result.remove(r);
                    r--;
                }
            }
        }

        // remove Integers that are in the corresponding column
        temp = board.getColumn(columnIndex);
        for(int i = 0; i < temp.size(); i++){
            for(int r = 0; r < result.size(); r++){
                if(result.get(r).intValue() == temp.get(i).intValue()){
                    //System.out.println(temp.get(i).intValue() + " not allowed in column " + columnIndex);
                    result.remove(r);
                    r--;
                }
            }
        }

        // remove Integers that are in the corresponding field
        temp = board.getField(fieldIndex);
        for(int i = 0; i < temp.size(); i++){
            for(int r = 0; r < result.size(); r++){
                if(result.get(r).intValue() == temp.get(i).intValue()){
                    //System.out.println(temp.get(i).intValue() + " not allowed in field " + fieldIndex);
                    result.remove(r);
                    r--;
                }
            }
        }
        return result;
    }




}
