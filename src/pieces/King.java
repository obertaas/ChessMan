package pieces;

import board.Board;
import board.Square;

import java.util.ArrayList;

public class King extends Piece {

    protected final PieceType pieceType = PieceType.KING;
    private boolean castlingDone = false;
    private boolean beenMoved = false;
    private boolean inCheck = false;


    public King(Color color) {
        super(color);
    }

    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    public boolean hasBeenMoved() {
        return this.beenMoved;
    }

    public void setBeenMoved(boolean beenMoved) {
        this.beenMoved = beenMoved;
    }

    public boolean isInCheck() {
        return this.inCheck;
    }

    public void setInCheck(boolean inCheck) {
        this.inCheck = inCheck;
    }

    @Override
    public ArrayList<Square> legalMoves(Board board, Square fromSquare) {
        return null;
    }

    @Override
    boolean canMove(Board board, Square fromSquare, Square toSquare) {
        if (fromSquare.getPiece().color == toSquare.getPiece().color) {
            return false;
        }
        int fileDiff = Math.abs(toSquare.getFile() - fromSquare.getFile());
        int rankDiff = Math.abs(toSquare.getRank() - fromSquare.getRank());
        if (fileDiff <= 1 && rankDiff <= 1 && (fileDiff + rankDiff) != 0) {
            return !squareIsAttacked(board, toSquare);
        }
        return false;
    }


    private boolean squareIsAttacked(Board board, Square square) {
        return (kingAttack(board, square))
                || knightAttack(board, square)
                || orthogonalAttack(board, square)
                || diagonalAttack(board, square)
                || pawnAttack(board, square);
    }

    private boolean kingAttack(Board board, Square square) {
        PieceType attackingPiece = PieceType.KING;
        int[] fileDiffs = {1, 1, 0,-1,-1,-1, 0, 1};
        int[] rankDiffs = {0, 1, 1, 1, 0,-1,-1,-1};

        return (vicinitySearch(board, square, attackingPiece, fileDiffs, rankDiffs));
    }

    private boolean knightAttack(Board board, Square square) {
        PieceType attackingPiece = PieceType.KNIGHT;
        int[] fileDiffs = {2, 1,-1,-2,-2,-1, 1, 2};
        int[] rankDiffs = {1, 2, 2, 1,-1,-2,-2,-1};

        return (vicinitySearch(board, square, attackingPiece, fileDiffs, rankDiffs));
    }

    private boolean vicinitySearch(Board board, Square square, PieceType attackingPiece, int[] fileDiffs, int[] rankDiffs) {
        int file = square.getFile();
        int rank = square.getRank();
        int surroundingAttackers = fileDiffs.length;
        int squareIndex = square.getSquareIndex();

        for (int i = 0; i < surroundingAttackers; i++) {
            int attackerFile = file + fileDiffs[i];
            int attackerRank = rank + rankDiffs[i];

            if (1 <= attackerFile && attackerFile <= board.FILES && 1 <= attackerRank && attackerRank <= board.RANKS) {
                int newSquareIndex = squareIndex + (board.FILES * rankDiffs[i]) + fileDiffs[i];
                Piece piece = board.getSquares().get(newSquareIndex).getPiece();
                if ((piece.color != this.color && piece.pieceType == attackingPiece)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean orthogonalAttack(Board board, Square square) {
        ArrayList<PieceType> attackingPieces = new ArrayList<>();
        attackingPieces.add(PieceType.QUEEN);
        attackingPieces.add(PieceType.ROOK);
        int file = square.getFile();
        int rank = square.getRank();
        int squareIndex = square.getSquareIndex();

        // Searching upwards along a file
        int distanceUp = board.RANKS - rank;
        int shiftUp = board.FILES;
        if (searchForAttacker(board, squareIndex, distanceUp, shiftUp, attackingPieces))
            return true;

        // Searching downwards along a file
        int distanceDown = rank - 1;
        int shiftDown = -board.FILES;
        if (searchForAttacker(board, squareIndex, distanceDown, shiftDown, attackingPieces))
            return true;

        // Searching leftwards along a rank
        int distanceLeft = file - 1;
        int shiftLeft = -1;
        if (searchForAttacker(board, squareIndex, distanceLeft, shiftLeft, attackingPieces))
            return true;

        // Searching rightwards along a rank
        int distanceRight = board.FILES - file;
        int shiftRight = 1;
        if (searchForAttacker(board, squareIndex, distanceRight, shiftRight, attackingPieces))
            return true;

        return false;
    }

    private boolean searchForAttacker(Board board, int squareIndex, int distanceToEdge, int squareShift, ArrayList<PieceType> attackingPieces) {

        for (int i = 0; i < distanceToEdge; i++) {
            int newSquareIndex = squareIndex + squareShift;
            squareIndex = newSquareIndex;

            if (board.getSquares().get(newSquareIndex).isEmpty()) { continue; }
            Piece piece = board.getSquares().get(newSquareIndex).getPiece();
            if (piece.color == this.color) { break; }
            if (!attackingPieces.contains(piece.pieceType)) { break; }
            return true;
        }
        return false;
    }


    private boolean diagonalAttack(Board board, Square square) {
        ArrayList<PieceType> attackingPieces = new ArrayList<>();
        attackingPieces.add(PieceType.QUEEN);
        attackingPieces.add(PieceType.BISHOP);
        int file = square.getFile();
        int rank = square.getRank();
        int squareIndex = square.getSquareIndex();

        // Searching upwards to the right
        int distanceUpRight = Math.min(board.FILES - file, board.RANKS - rank);
        int shiftUpRight = (board.FILES + 1);
        if (searchForAttacker(board, squareIndex, distanceUpRight, shiftUpRight, attackingPieces))
            return true;

        // Searching upwards to the left
        int distanceUpLeft = Math.min(file - 1, board.RANKS - rank);
        int shiftUpLeft = (board.FILES - 1);
        if (searchForAttacker(board, squareIndex, distanceUpLeft, shiftUpLeft, attackingPieces))
            return true;

        // Searching downwards to the left
        int distanceDownLeft = Math.min(file - 1, rank - 1);
        int shiftDownLeft = (-board.FILES - 1);
        if (searchForAttacker(board, squareIndex, distanceDownLeft, shiftDownLeft, attackingPieces))
            return true;

        // Searching downwards to the right
        int distanceDownRight = Math.min(board.FILES - file, rank - 1);
        int shiftDownRight = (-board.FILES + 1);
        if (searchForAttacker(board, squareIndex, distanceDownRight, shiftDownRight, attackingPieces))
            return true;

        return false;
    }

    private boolean pawnAttack(Board board, Square square) {
        int rank = square.getRank();
        int squareIndex = square.getSquareIndex();
        if (7 <= rank) {
            return false;
        }
        Piece pieceLeft = board.getSquares().get(squareIndex + board.FILES - 1).getPiece();
        Piece pieceRight = board.getSquares().get(squareIndex + board.FILES + 1).getPiece();
        if ((pieceLeft.color != this.color && pieceLeft.pieceType == PieceType.PAWN) || (pieceRight.color != this.color && pieceRight.pieceType == PieceType.PAWN)) {
            return true;
        }
        return false;
    }
}
