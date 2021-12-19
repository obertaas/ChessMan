package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public class Queen extends Piece {

    private final PieceType pieceType = PieceType.QUEEN;

    public Queen(Color color) {
        super(color);
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
