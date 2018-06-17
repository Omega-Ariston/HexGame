package comp1110.ass2;

public class Pieces {

    Piece[] pieces;

    public Pieces(String s){
        int length = s.length();
        pieces = new Piece[length/3];
        for (int i = 0; i < length; i+=3) {
            pieces[i] = new Piece(Integer.parseInt(s.substring(i, i+3)));
        }
    }

    public boolean contains(int val){
        for (Piece piece: pieces
             ) {
            if(piece.getVal() == val)
                return true;
        }
        return false;
    }
}
