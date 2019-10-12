package game;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    public ArrayList<Cell> cells;
    //public ArrayList<Integer> emptyCellIDs;

    public Board(){
        cells = new ArrayList<Cell>();
        //emptyCellIDs = new ArrayList<Integer>();
        for(int c = 0; c < 81; c++){
            cells.add(new Cell(c));
            cells.get(c).setValue(0);
            //emptyCellIDs.add(new Integer(c));
        }
    }

    public void printBoard(){
        System.out.println("-------------------------------------");
        for (int line = 0; line < 9; line++){
            System.out.print("| ");
            for (int column = 0; column < 9; column++){
                 System.out.print(cells.get(line * 9 + column).value);
                 if(column == 2 || column == 5 || column == 8){
                     System.out.print(" | ");
                 } else {
                     System.out.print("   ");
                 }
            }
            System.out.println();
            if(line == 2 || line == 5){
                System.out.println("-------------------------------------");
            }
        }
        System.out.println("-------------------------------------");
        //System.out.println("The above board has " + emptyCellIDs.size() + " empty cells.");
    }

    public void setCellValue(int id, int v){
        cells.get(id).setValue(v);
        //removeFromEmptyCellIDs(id);
    }

    /*
    public void addToEmptyCellsIDs(int id){
        emptyCellIDs.add(new Integer(id));
    }

    public void removeFromEmptyCellIDs(int id){
        for(int i = 0; i < emptyCellIDs.size(); i++){
            if(emptyCellIDs.get(i).intValue() == id){
                emptyCellIDs.remove(i);
                i = emptyCellIDs.size();
            }
        }
    }
    */

    public ArrayList<Integer> getLine(int lineIndex){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int c = 0; c < 9; c++){
            result.add(new Integer(cells.get(lineIndex * 9 + c).value));
        }
        return result;
    }

    public ArrayList<Integer> getColumn(int columnIndex){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int l = 0; l < 9; l++){
            result.add(new Integer(cells.get(columnIndex + 9 * l).value));
        }
        return result;
    }

    public ArrayList<Integer> getField(int fieldIndex){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int startingIndex = 0;
        switch (fieldIndex){
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
        result.add(new Integer(cells.get(startingIndex).value));
        result.add(new Integer(cells.get(startingIndex + 1).value));
        result.add(new Integer(cells.get(startingIndex + 2).value));
        result.add(new Integer(cells.get(startingIndex + 9).value));
        result.add(new Integer(cells.get(startingIndex + 10).value));
        result.add(new Integer(cells.get(startingIndex + 11).value));
        result.add(new Integer(cells.get(startingIndex + 18).value));
        result.add(new Integer(cells.get(startingIndex + 19).value));
        result.add(new Integer(cells.get(startingIndex + 20).value));
        return result;
    }

    public ArrayList<Integer> getEmptyCellIDs(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int c = 0; c < cells.size(); c++){
            if(cells.get(c).value == 0){
                result.add(new Integer(c));
            }
        }
        return result;
    }

}
