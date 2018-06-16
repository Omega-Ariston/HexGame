package comp1110.ass2;

import java.util.List;
import java.util.regex.Pattern;

public class Nook {
    private char orientation;
    private Hex hex;
    private int area;

    public Nook(int val, char orientation){
        this.orientation = orientation;
        this.hex = Hexes.getHexByNum(val);
        this.area = getAreaByNum(val);
    }

    private int getAreaByNum(int num){
        for (int i = 0, length = Data.LEGAL_NOOK_PLACE.length; i < length; i++) {
            if(Data.LEGAL_NOOK_PLACE[i].contains(num))
                return i;
        }
        return -1;
    }

    public boolean neighborOf(Nook nook){
        return hex.neighborOf(nook.hex);
    }

    public boolean neighborOf(List<Nook> nooks){
        for (Nook nook: nooks
             ) {
            if(neighborOf(nook))
                return true;
        }
        return false;
    }

    public static boolean isNookWellFormed(String nook){
        String valStr = nook.substring(0,3);
        char orientation = nook.charAt(3);
        boolean isInt = Data.isNumeric(valStr);
        if(!isInt || orientation < 'A' || orientation > 'F')
            return false;
        int val = Integer.parseInt(valStr);
        if(val < 0 || val >216)
            return false;
        return true;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getArea() {
        return area;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public Hex getHex() {
        return hex;
    }
}
