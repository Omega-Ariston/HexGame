package comp1110.ass2;

public class Pioneer {
    int val;
    int orientation;
    int layer;

    public Pioneer(int orientation, int layer){
        this.orientation = orientation;
        this.layer = layer;
        this.val = getNumByOrientationAndLayer(orientation, layer);
    }

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
}
