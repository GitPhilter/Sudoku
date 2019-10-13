package completion;

import game.Cell;

import java.util.ArrayList;

public class CellTupleSort {


    public void sortCellTuples(ArrayList<CellTuple> cellTuples){
            if(cellTuples.size() == 0 || cellTuples.size() == 1){
                //return cellTuples;
            } else {
                CellTuple tempTuple = new CellTuple();
                for (int i = 0; i < cellTuples.size(); i++) {
                    for (int k = i + 1; k < cellTuples.size(); k++) {
                        if(cellTuples.get(i).getPossibleIntegers().size() > cellTuples.get(k).getPossibleIntegers().size()) {
                            tempTuple = new CellTuple(cellTuples.get(i));
                            cellTuples.set(i, cellTuples.get(k));
                            cellTuples.set(k, tempTuple);
                        }
                    }
                }
            }

    }

}
