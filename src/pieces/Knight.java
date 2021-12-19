package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public class Knight extends Piece {

    private final PieceType pieceType = PieceType.KNIGHT;

    public Knight(Color color) {
        super(color);
    }

    @Override
    public ArrayList<Square> legalMoves(Board board, Square fromLocation) {
        return null;
    }


    @Override
    boolean canMove(Board board, Square fromLocation, Square toLocation) {
        if (fromLocation.getPiece().color == toLocation.getPiece().color) {
            return false;
        }
        int fileDiff = Math.abs(toLocation.getFile() - fromLocation.getFile());
        int rankDiff = Math.abs(toLocation.getRank() - fromLocation.getRank());
        return fileDiff * rankDiff == 2;
    }
}
