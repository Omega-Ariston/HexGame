package comp1110.ass2;

import java.util.Arrays;

public class Hex {
    private int val;
    private int[] neighbors;
    private int layer;
    private int edge;
    private int index;
    private boolean[] obstacles;
    private int[] availableSteps;

    public Hex(int num) {
        this.val = num;
        this.layer = getLayerByNum(num);
        int[] ei = getEdgeAndIndexByNum(num);
        this.edge = ei[0];
        this.index = ei[1];
        this.neighbors = findNeighbors();
        initialObstacles();
        availableSteps = new int[]{-2, -2, -2, -2, -2, -2}; //-2 stands for uninitialize, -1 stands for unreachable
    }

    private void initialObstacles(){
        obstacles = new boolean[6];
        if (layer == 8){
            obstacles[edge] = true;
            obstacles[(edge+1)%6] = true;
            if(val == Data.SMALLEST[8] + edge*8)
                obstacles[edge==0?5:edge-1] = true;
        }
    }

    private int[] getEdgeAndIndexByNum(int num) {
        int edge = layer == 0 ? 0 : (num - Data.SMALLEST[layer]) / (layer);
        int index = layer == 0 ? 0 : (num - Data.SMALLEST[layer]) % layer;
        return new int[]{edge, index};
    }

    private int getLayerByNum(int num) {
        if (num == 0)
            return 0;
        int i = 0;
        while (i < Data.BIGGEST.length) {
            if (num <= Data.BIGGEST[i])
                break;
            i++;
        }
        return i;
    }

    private int[] findNeighbors() {
        if (val == 0)
            return new int[]{1, 2, 3, 4, 5, 6};
        int[] output = new int[]{-1, -1, -1, -1, -1, -1};
        Pioneer pioneerOuter = null;
        Pioneer pioneerInner = Pioneers.getPioneerByOrientationAndLayer(edge, layer - 1);
        if (layer < 8) {
            pioneerOuter = Pioneers.getPioneerByOrientationAndLayer(edge, layer + 1);
            output[edge] = pioneerOuter.val + index;
            output[(edge + 1) % 6] = output[edge] + 1;
        }
        output[(edge + 2) % 6] = getShiftedHexAtSameLayer(val, layer, 1);
        output[(edge + 3) % 6] = getShiftedHexAtSameLayer(pioneerInner.val, pioneerInner.layer, index);
        output[(edge + 4) % 6] = index == 0 ? getShiftedHexAtSameLayer(val, layer, -1) :
                getShiftedHexAtSameLayer(output[(edge + 3) % 6], layer - 1, -1);
        output[(edge + 5) % 6] = layer == 8 || pioneerOuter == null ? -1 :
                (index == 0 ? getShiftedHexAtSameLayer(pioneerOuter.val, pioneerOuter.layer, -1) :
                        getShiftedHexAtSameLayer(val, layer, -1));
        return output;
    }

    private int getShiftedHexAtSameLayer(int num, int layer, int shift) {
        int biggest = Data.BIGGEST[layer];
        int smallest = Data.SMALLEST[layer];
        int numInLayer = biggest - smallest + 1;
        int index = num - smallest;
        int destination = index + shift;
        if (shift >= 0)
            return smallest + (destination) % (numInLayer);
        else
            return destination >= 0 ? destination + smallest : biggest + 1 + destination;
    }

    public boolean neighborOf(Hex hex){
        int[] neighbors = hex.getNeighbors();
        for (int i: neighbors
                ) {
            if(val == i)
                return true;
        }
        return false;
    }

    public int[] getAvailableSteps(){
        for (int i = 0; i < 6; i++) {
            if(availableSteps[i]==-2){
                Hex hex = this;
                while(!hex.getObstacles()[i])
                    hex = Hexes.getHexByNum(hex.getNeighbors()[i]);
                if(hex==this)
                    availableSteps[i] = -1;
                else
                    availableSteps[i] = hex.getVal();
            }
        }
        return availableSteps;
    }

    public int getVal() {
        return val;
    }

    public int getLayer() {
        return layer;
    }

    public int getEdge() {
        return edge;
    }

    public int getIndex() {
        return index;
    }

    public int[] getNeighbors() {
        return neighbors;
    }

    public boolean[] getObstacles(){ return obstacles;}

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
