package pieces;

import board.Location;

public abstract class Piece {
    private Location location;
    private Color color;

    // at creation the piece will be allocated to their start position
    public Piece(Location startLocation, Color color) {
        this.location = startLocation;
        this.color = color;
    }


}
