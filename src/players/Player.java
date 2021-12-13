package players;

import pieces.Color;
import pieces.Piece;
import pieces.SetOfPieces;

import java.util.HashSet;

public class Player {

    private Color color;
    private SetOfPieces pieces;

    public Player(Color color) {
        this.color = color;
        this.pieces = new SetOfPieces(color);


    }

}
