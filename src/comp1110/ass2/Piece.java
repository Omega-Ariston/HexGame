package comp1110.ass2;

import java.util.LinkedList;
import java.util.Stack;

public class Piece {
    private int val;
    private Stack<Integer> path;

    public Piece(int val){
        this.val = val;
        path = new Stack<>();
        path.push(val);
    }

    public int getVal() {
        return val;
    }

    public Stack<Integer> getPath() {
        return path;
    }
}
