package comp1110.ass2;

public class Pioneer {
    int val;
    int orientation;
    int layer;

    public Pioneer(int orientation, int layer){
        this.orientation = orientation;
        this.layer = layer;
        this.val = Data.getNumByOrientationAndLayer(orientation, layer);
    }
}
