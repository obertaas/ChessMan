package pieces;

import board.Location;

public class Pawn extends Piece {

    Type type = Type.BISHOP;

    public Pawn(Location startLocation, Color color) {
        super(startLocation, color);
    }



}
