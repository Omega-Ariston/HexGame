package comp1110.ass2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Data {
    static final int NUM_OF_LAYER = 9;
    static final int NUM_OF_EDGE = 6;
    static final int[] BIGGEST = new int[NUM_OF_LAYER];
    static final int[] SMALLEST = new int[NUM_OF_LAYER];
    static final int[] NUM_IN_LAYER = new int[NUM_OF_LAYER];
    static final Set[] LEGAL_NOOK_PLACE = new Set[NUM_OF_EDGE];

    static{
        NUM_IN_LAYER[1] = NUM_OF_EDGE;
        for (int i = 1; i < NUM_OF_LAYER; i++) {
            NUM_IN_LAYER[i] = NUM_IN_LAYER[i-1] + 6;
            SMALLEST[i] = BIGGEST[i-1] + 1;
            BIGGEST[i] = NUM_IN_LAYER[i] + SMALLEST[i] - 1;
        }
        NUM_IN_LAYER[0] = 1;

        for (int i = 0; i < LEGAL_NOOK_PLACE.length; i++) {
            Set s = new HashSet();
            for (int j = 2; j <=6 ; j++) {
                int left = getNumByOrientationAndLayer(i, j);
                int right = getNumByOrientationAndLayer((i+1), j);
                for (int k = left+1; k <right ; k++) {
                    s.add(k);
                }
            }
            LEGAL_NOOK_PLACE[i] = s;
        }
    }

    //can be optimized by a single math equation.
    static int getNumByOrientationAndLayer(int orientation, int layer){
        if(layer==0)
            return 0;
        int i = 0;
        int num = 0;
        int diff = orientation + 6;
        while(++i <= layer){
            if(i == 1) {
                num += orientation + 1;
                continue;
            }
            if(i == 2) {
                num += diff;
                continue;
            }
            diff += 6;
            num += diff;
        }
        return num;
    }

    public static boolean isNumeric(String s){
        return Pattern.compile("\\d{" + s.length() + "}").matcher(s).find();
    }
}
