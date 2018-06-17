package comp1110.ass2;

import java.util.HashMap;
import java.util.Map;

public class Nooks {

    private Map<Integer, Nook> nooks;

    public Nook getNook(int val){
        return nooks.get(val);
    }

    public Nooks(){
        this.nooks = new HashMap<>(18*4);
    }

    public Nooks(String s){
        int length = s.length();
        this.nooks = new HashMap<>(length/4);
        for (int i = 0; i < length; i+=4) {
            String nookStr = s.substring(i, i + 4);
            int val = Integer.parseInt(nookStr.substring(0, 3));
            setNookByValAndOrientation(val, nookStr.charAt(3));
        }
    }

    public Nook setNookByValAndOrientation(int val, char orientation){
        if(nooks.containsKey(val)) {
            Nook nook = nooks.get(val);
            nook.setOrientation(orientation);
            return nook;
        }
        Nook nook = new Nook(val, orientation);
        nooks.put(val, nook);
        return nook;
    }

    public boolean contains(int num){
        return nooks.containsKey(num);
    }

    public Map<Integer, Nook> getNooks() {
        return nooks;
    }
}
