package board;

import pieces.Piece;

public final class Square {

    private final int file; //12345678, representing abcdefgh
    private final int rank; //12345678
    private final int squareIndex;
    private final String chessCoordinate; //a1,a2, ..., h7, h8
    private Piece piece;

    public Square(int file, int rank) {
        this.file = file;
        this.rank = rank;
        this.squareIndex = squareIndex();
        this.chessCoordinate = chessCoordinate();
        this.piece = null;
    }

    private int squareIndex() {
        return this.file * this.rank;
    }

    private String chessCoordinate() {
        final String FILE_CHARS = "abcdefgh";
        char fileChar = FILE_CHARS.charAt(this.file-1);
        return "" + fileChar + this.rank;
    }

    public int getFile() {
        return this.file;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSquareIndex() {
        return this.squareIndex;
    }

    public String getChessCoordinate() {
        return this.chessCoordinate;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

}
