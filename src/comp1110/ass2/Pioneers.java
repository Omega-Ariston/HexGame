package comp1110.ass2;

public class Pioneers {

    private static Pioneer[][] pioneers = new Pioneer[6][9];

    static{
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                pioneers[i][j] = new Pioneer(i, j);
            }
        }
    }

    public static Pioneer getPioneerByOrientationAndLayer(int orientation, int layer){
        if(orientation > 5 || orientation < 0 || layer > 8 || layer < 0)
            return null;
        return pioneers[orientation][layer];
    }
}
