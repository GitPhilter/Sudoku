package game;

public class Cell {
    public int value;
    public int ID;

    public Cell(int id){
    ID = id;
    }

    public boolean setValue(int v){
    if(v < 0 || v > 9){
        System.out.println("Cell no. " + ID + " cannot be set to value " + v);
        return false;
    }
    value = v;
    return true;
    }

}
