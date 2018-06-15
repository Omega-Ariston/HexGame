package comp1110.ass2;

/**
 * Created by steveb on 30/07/2015.
 */
public class HexGame {
    static final int[] BIGGEST = new int[]{0, 6, 18, 36, 60, 90, 126, 168, 216};
    static final int[] SMALLEST = new int[]{0, 1, 7, 19, 37, 61, 91, 127, 169};
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
        if(length!=18)
            return false;
        boolean[] occupied = new boolean[6];
        for (int i = 0; i < length; i+=3) {
            int cranny = Integer.parseInt(crannies.substring(i, i+3));
            int edge = (cranny - 169)/8;
            if(edge < 0 || edge > 5 || occupied[edge])
                return false;
            occupied[edge] = true;
        }
        return true;
    }

    /**
     * Determine whether a set of nooks are legal according to the assignment specification.
     * @param nooks A string describing the nooks, encoded according to the assignment specification.
     * @return True if the nooks are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateNooks(String nooks) {
        /* FIXME */

        return true;
    }


    private static int[] getNeighborsByNum(int num){
        int[] output = new int[]{-1, -1, -1, -1, -1, -1};
        return output;
    }

    public static void main(String[] args) {
    }

    /**
     * Determine whether a game state is legal according to the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @return True if the game state is correctly encoded and represents a legal game state, according to the assignment specification.
     */
    public static boolean legitimateGame(String game) {
        /* FIXME */
        return false;
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
