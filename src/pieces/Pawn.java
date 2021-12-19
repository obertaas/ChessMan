package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public class Pawn extends Piece {

    protected final PieceType pieceType = PieceType.PAWN;

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public ArrayList<Square> legalMoves(Board board, Square fromLocation) {
        return null;
    }


    private ArrayList<Integer> potentialMoves(Board board, Square location) {
        ArrayList<Integer> potentialLocationIndices = new ArrayList<>();

        int file = location.getFile();
        int rank = location.getRank();

        if (1 <= file-1 && rank <= 7) {
            int potentialLocationIndex = location.getSquareIndex() + 7;
            potentialLocationIndices.add(potentialLocationIndex);
        }

        return null;

    }


    @Override
    boolean canMove(Board board, Square fromLocation, Square toLocation) {
        if (fromLocation.getPiece().color == toLocation.getPiece().color) {
            return false;
        }
        int fileDiff = Math.abs(toLocation.getFile() - fromLocation.getFile());
        int rankDiff = toLocation.getRank() - fromLocation.getRank();
        if (fileDiff == 1 && rankDiff == 1 && !toLocation.isEmpty() ) {
            return true;
        }
        if (fileDiff == 0 && toLocation.isEmpty()) {
            if (rankDiff == 1)
                return true;
            if (rankDiff == 2 && fromLocation.getRank() == 2) {
                return true;
            }
        }
        return false;

    }


}
