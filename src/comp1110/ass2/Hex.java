package comp1110.ass2;

import java.util.Arrays;

public class Hex {
    int val;
    int[] neighbors;
    int layer;
    int edge;
    int index;

    public Hex(int num){
        this.val = num;
        this.layer = getLayerByNum(num);
        int[] ei = getEdgeAndIndexByNum(num);
        this.edge = ei[0];
        this.index = ei[1];
        this.neighbors = getNeighbors();
    }

    private int[] getEdgeAndIndexByNum(int num){
        int edge = layer==0?0: (num - HexGame.SMALLEST[layer])/(layer);
        int index = layer==0?0: (num - HexGame.SMALLEST[layer])%layer;
        return new int[]{edge, index};
    }

    private int getLayerByNum(int num){
        if(num==0)
            return 0;
        int i=0;
        while(i < HexGame.BIGGEST.length){
            if(num <= HexGame.BIGGEST[i])
                break;
            i++;
        }
        return i;
    }

    private int[] getNeighbors(){
        if(val == 0)
            return new int[]{1, 2, 3, 4, 5, 6};
        int[] output = new int[]{-1, -1, -1, -1, -1, -1};
        Pioneer pioneerOuter = null;
        Pioneer pioneerInner = Pioneers.getPioneerByOrientationAndLayer(edge, layer - 1);
        if(layer < 8){
            pioneerOuter = Pioneers.getPioneerByOrientationAndLayer(edge, layer + 1);
            output[edge] = pioneerOuter.val + index;
            output[(edge+1)%6] = output[edge] + 1;
        }
        output[(edge+2)%6] = getShiftedHexAtSameLayer(val, layer, 1);
        output[(edge+3)%6] = getShiftedHexAtSameLayer(pioneerInner.val, pioneerInner.layer, index);
        output[(edge+4)%6] = index==0? getShiftedHexAtSameLayer(val, layer, -1):
                getShiftedHexAtSameLayer(output[(edge+3)%6], layer-1, -1);
        output[(edge+5)%6] = layer==8||pioneerOuter==null? -1 :
                (index==0? getShiftedHexAtSameLayer(pioneerOuter.val, pioneerOuter.layer, -1) :
                        getShiftedHexAtSameLayer(val, layer, -1));
        return output;
    }

    private int getShiftedHexAtSameLayer(int num, int layer, int shift){
        int biggest = HexGame.BIGGEST[layer];
        int smallest = HexGame.SMALLEST[layer];
        int numInLayer = biggest-smallest+1;
        int index = num-smallest;
        int destination = index+shift;
        if(shift >= 0)
            return smallest + (destination)%(numInLayer);
        else
            return destination>=0? destination+smallest : biggest+1+destination;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "val=" + val +
                ", neighbors=" + Arrays.toString(neighbors) +
                ", layer=" + layer +
                ", edge=" + edge +
                ", index=" + index +
                '}';
    }
}
