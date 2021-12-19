package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public abstract class Piece {
    //final Square startSquare;
    //protected Square square;
    protected PieceType pieceType;
    protected final Color color;

    // at creation the piece will be allocated to their start position
    public Piece(Color color) {
        //this.startSquare = startSquare;
        //this.Square = startSquare;
        this.color = color;
    }



    public abstract ArrayList<Square> legalMoves(Board board, Square fromSquare);


    abstract boolean canMove(Board board, Square fromSquare, Square toSquare);


    public Color getColor() {
        return this.color;
    }



}
