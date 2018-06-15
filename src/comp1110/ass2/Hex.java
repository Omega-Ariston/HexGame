package comp1110.ass2;

public class Hex {
    int val;
    int[] neighbors;
    int layer;
    int edge;
    int relativePosition;


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

    static int getEdgeByNum(int num){
        int layer = getLayerByNum(num);
        int edge = layer==0?0:(num - HexGame.SMALLEST[layer])/(layer);
        return edge;
    }

    static int getLayerByNum(int num){
        if(num==0)
            return 0;
        int i=1;
        while(i++ < HexGame.BIGGEST.length){
            if(num <= HexGame.BIGGEST[i])
                break;
        }
        return i;
    }
}
