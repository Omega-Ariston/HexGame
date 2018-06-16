package comp1110.ass2;

import java.util.HashMap;
import java.util.Map;

public class Nooks {
    static Map<Integer, Nook> nooks = new HashMap<>();

    public static Nook getNookByValAndOrientation(int val, char orientation){
        if(nooks.containsKey(val)) {
            Nook nook = nooks.get(val);
            nook.setOrientation(orientation);
            return nook;
        }
        Nook nook = new Nook(val, orientation);
        nooks.put(val, nook);
        return nook;
    }

}
