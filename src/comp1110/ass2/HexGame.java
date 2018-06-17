package comp1110.ass2;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by steveb on 30/07/2015.
 */
public class HexGame {

    /**
     * Construct HexGame from a string describing game state.
     * @param game The initial state of the game, described as a string according to the assignment specification.
     */
    public HexGame(String game) {
        /* FIXME */
    }

    /**
     * Construct HexGame with a random game state that complies with the assignment specification.
     */
    public HexGame() {
        /* FIXME */
    }

    /**
     * Determine whether a set of crannies are legal according to the assignment specification.
     * @param crannies A string describing the crannies, encoded according to the assignment specification.
     * @return True if the crannies are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateCrannies(String crannies) {
        /* FIXME */
        int length = crannies.length();
        if(length!=18) //NUM_OF_EDGE * 3
            return false;
        boolean[] occupied = new boolean[6]; //NUM_OF_EDGE
        int smallest = Data.SMALLEST[8]; //the outermost layer
        int numInEdge = Data.NUM_IN_LAYER[8]/6; //the outermost layer
        for (int i = 0; i < length; i+=3) {
            int cranny = Integer.parseInt(crannies.substring(i, i+3));
            int edge = (cranny - smallest)/numInEdge;
            if(edge < 0 || edge > 5 || occupied[edge])
                return false;
            occupied[edge] = true;
        }
        return true;
    }

    /**
     * Determine whether a set of nooks are legal according to the assignment specification.
     * @param s A string describing the nooks, encoded according to the assignment specification.
     * @return True if the nooks are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateNooks(String s) {
        /* FIXME */
        int length = s.length();
        if(length!=18*4)
            return false;
        List<Nook>[] nooks = new LinkedList[6]; //NUM_OF_EDGE
        Nooks nooksCollection = new Nooks();
        for (int i = 0; i < length; i+=4) {
            String nookStr= s.substring(i, i+4);
            if(!Nook.isNookWellFormed(nookStr))
                return false;
            int val = Integer.parseInt(nookStr.substring(0,3));
            Nook nook = nooksCollection.setNookByValAndOrientation(val, nookStr.charAt(3));

            int area = nook.getArea();
            if(area==-1)
                return false;
            if(nooks[area]==null)
                nooks[area] = new LinkedList<>();
            List<Nook> nooksInArea = nooks[area];
            if(nooksInArea.size()>=3)
                return false;
            if(nook.neighborOf(nooksInArea))
                return false;
            nooksInArea.add(nook);
        }
        return true;
    }

    /**
     * Determine whether a game state is legal according to the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @return True if the game state is correctly encoded and represents a legal game state, according to the assignment specification.
     */
    public static boolean legitimateGame(String game) {
        /* FIXME */
        int length = game.length();
        int minLength = 6*3 + 18*4;
        if(length < minLength + 3 || length > minLength + 12)
            return false;
        String crannies = game.substring(0, 18);
        String nooks = game.substring(18, 90);
        String pieces = game.substring(90, length);
        return legitimateCrannies(crannies) && legitimateNooks(nooks) && legitimatePieces(pieces, nooks);
    }

    public static boolean legitimatePieces(String pieces, String nooks){
        int length = pieces.length();
        if (!Data.isNumeric(pieces) || length%3!=0)
            return false;
        Set s = new HashSet();
        for (int i = 0; i < length; i+=3) {
            String piece = pieces.substring(i, i+3);
            if(!nooks.contains(piece) || s.contains(piece))
                return false;
            s.add(piece);
        }
        return true;
    }

    /**
     * Determine whether a given step is legal according to a given game state and the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param from The point from which the step starts
     * @param to The point to which step goes
     * @return True if the move is legal according to the assignment specification.
     */
    public static boolean legitimateStep(String game, int from, int to) {
        /* FIXME */
        String sc = game.substring(0, 18);
        String sn = game.substring(18, 90);
        String sp = game.substring(90);
        Pieces pieces = new Pieces(sp);
        if(!pieces.contains(from))
            return false;
        Crannies crannies = new Crannies(sc);
        Nooks nooks = new Nooks(sn);
        Hexes.setObstacles(nooks, crannies, true);
        for (int i: Hexes.getHexByNum(from).getAvailableSteps()
             ) {
            if(i==to)
                return true;
        }
        return false;
    }

    /**
     * Return a minimal path from start to goal.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param start The point from which the path must start
     * @param goal The point at which the path must end
     * @return An array of integers reflecting a minimal path from start to goal, each integer reflecting a node on the board, starting with the start, and ending with the goal.
     */
    public static int[] minimalPath(String game, int start, int goal) {
        /* FIXME */
        return null;
    }

    /**
     * Output the state of the game as a string, encoded according to the assignment specification
     * @return A string that reflects the game state, encoded according to the assignment specification.
     */
    public String toString() {
        /* FIXME */
        return null;
    }

}
