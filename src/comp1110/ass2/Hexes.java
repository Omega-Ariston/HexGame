package comp1110.ass2;

import java.util.Arrays;

public class Hexes {

    private static Hex[] hexes = new Hex[217];

    public static Hex getHexByNum(int num){
        if(hexes[num]==null){
            hexes[num] = new Hex(num);
        }
        return hexes[num];
    }

}
