package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public class Rook extends Piece {

    private final PieceType pieceType = PieceType.ROOK;
    private boolean castlingDone = false;
    private boolean beenMoved = false;


    public Rook(Color color) {
        super(color);
    }

    public boolean hasBeenMoved() {
        return this.beenMoved;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    public void setBeenMoved(boolean beenMoved) {
        this.beenMoved = beenMoved;
    }

    @Override
    public ArrayList<Square> legalMoves(Board board, Square fromSquare) {
        return null;
    }

    @Override
    boolean canMove(Board board, Square fromSquare, Square toSquare) {
        return false;
    }


}
