package completion;

import game.Board;
import game.Cell;

import java.util.ArrayList;
import java.util.Collections;

public class CellTuple {
    private int CellID;
    ArrayList<Integer> possibleIntegers;

    public CellTuple(Board board, int cellID){
        CellID = cellID;
        possibleIntegers = IntegerHelper.getPossibleIntegers(board, CellID);
        Collections.shuffle(possibleIntegers);
    }

    public CellTuple(CellTuple cellTuple){
        this.CellID = cellTuple.getCellID();
        possibleIntegers = new ArrayList<Integer>();
        for(int i = 0; i < cellTuple.getPossibleIntegers().size(); i++){
            possibleIntegers.add(new Integer(cellTuple.getPossibleIntegers().get(i)));
        }
    }

    public CellTuple(){
    }

    public void printCellTuple(){
        System.out.println("#############################################");
        //System.out.println("Cell-Tuple for Cell no. " + CellID + ":");
        System.out.print("Cell no. " + CellID + " has " + possibleIntegers.size() + " possible Integers: ");
        if (possibleIntegers.size() > 0) {
            for (int i = 0; i < possibleIntegers.size(); i++) {
                if(i < possibleIntegers.size() - 1) {
                    System.out.print(possibleIntegers.get(i) + ", ");
                } else{
                    System.out.println(possibleIntegers.get(i) + ".");
                }
            }
        }

        System.out.println();
    }

    public int getCellID(){
    return CellID;
    }

    public ArrayList<Integer> getPossibleIntegers(){
        return possibleIntegers;
    }

}
