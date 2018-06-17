package comp1110.ass2;

import java.util.HashSet;
import java.util.Set;

public class Crannies {
    private Set<Integer> crannies;

    public Crannies(String s){
        int length = s.length();
        crannies = new HashSet<>(s.length()/3);
        for (int i = 0; i < length; i+=3) {
            crannies.add(Integer.parseInt(s.substring(i, i+3)));
        }
    }

    public Set<Integer> getCrannies() {
        return crannies;
    }
}
