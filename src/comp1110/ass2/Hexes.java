package comp1110.ass2;

import java.util.Arrays;
import java.util.List;

public class Hexes {

    private static Hex[] hexes = new Hex[217];

    static {
        for (int i = 0; i < 217; i++) {
            hexes[i] = new Hex(i);
        }
    }

    public static Hex getHexByNum(int num){
        return hexes[num];
    }

    public static void setObstacles(Nooks nooks, Crannies crannies, boolean truth){
        for (Nook nook : nooks.getNooks().values()
             ) {
            setObstaclesByNook(nook, truth);
        }
        for (Integer cranny : crannies.getCrannies()
             ) {
            setObstaclesByCranny(cranny, truth);
        }
    }

    private static void setObstaclesByNook(Nook nook, boolean truth){
        int mid = nook.getOrientation() - 'A';
        int right = (mid+1)%6;
        int left = mid==0?5:mid-1;
        Hex hex = nook.getHex();
        boolean[] obstacles = hex.getObstacles();
        obstacles[mid] = truth;
        obstacles[left] = truth;
        obstacles[right] = truth;
        //set neighbors' obstacle
        Hexes.getHexByNum(hex.getNeighbors()[mid]).getObstacles()[(mid+3)%6] = truth;
        Hexes.getHexByNum(hex.getNeighbors()[left]).getObstacles()[(left+3)%6] = truth;
        Hexes.getHexByNum(hex.getNeighbors()[right]).getObstacles()[(right+3)%6] = truth;
    }

    private static void setObstaclesByCranny(Integer cranny, boolean truth){
        Hex hex1 = hexes[cranny];
        Hex hex2 = hexes[cranny==216?169:cranny+1];
        int direction = (hex1.getEdge()+2)%6;
        int oppositeDirection = (direction+3)%6;
        hex1.getObstacles()[direction] = truth;
        hex2.getObstacles()[oppositeDirection] = truth;
    }

    public static void main(String[] args) {
        Nooks nooks = new Nooks("093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D");
        Crannies crannies = new Crannies("171178187194205216");
        setObstacles(nooks, crannies, true);
    }

}
