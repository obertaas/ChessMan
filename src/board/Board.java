package board;

import pieces.*;

import java.util.ArrayList;

public class Board {

    public final String FILE_CHARS = "abcdefgh";
    public final int FILES = 8;
    public final int RANKS = 8;
    public final int SIZE = 8;

    private ArrayList<Square> squares;

    public Board() {
        this.squares = new ArrayList<>();
        createBoardSquares();
        putPiecesOnBoard();
    }

    private void createBoardSquares() {
        for (int file=1; file <= FILES; file++) {
            for (int rank=1; rank <= RANKS; rank++) {
                Square square = new Square(file, rank);
                this.squares.add(square);
            }
        }
    }

    /**
     * Whites
     * - Pawns: a2-h2
     * - Rooks: a1, h1
     * - Knights: b1, g1
     * - Bishops: c1, f1
     * - Queen: d1
     * - King: e1
     *
     * Blacks
     * - Pawns: a7-h7
     * - Rooks: a8, h8
     * - Knights: b8, g8
     * - Bishops: c8, f8
     * - Queen: d8
     * - King: e8
     *
     */
    private void putPiecesOnBoard() {
        Color white = Color.WHITE;
        Color black = Color.BLACK;

        this.squares.get(squareIndexFromChessCoordinate("a2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("b2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("c2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("d2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("e2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("f2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("g2")).setPiece(new Pawn(white));
        this.squares.get(squareIndexFromChessCoordinate("h2")).setPiece(new Pawn(white));

        this.squares.get(squareIndexFromChessCoordinate("a1")).setPiece(new Rook(white));
        this.squares.get(squareIndexFromChessCoordinate("h1")).setPiece(new Rook(white));
        this.squares.get(squareIndexFromChessCoordinate("b1")).setPiece(new Knight(white));
        this.squares.get(squareIndexFromChessCoordinate("g1")).setPiece(new Knight(white));
        this.squares.get(squareIndexFromChessCoordinate("c1")).setPiece(new Bishop(white));
        this.squares.get(squareIndexFromChessCoordinate("f1")).setPiece(new Bishop(white));
        this.squares.get(squareIndexFromChessCoordinate("d1")).setPiece(new Queen(white));
        this.squares.get(squareIndexFromChessCoordinate("e1")).setPiece(new King(white));

        this.squares.get(squareIndexFromChessCoordinate("a7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("b7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("c7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("d7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("e7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("f7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("g7")).setPiece(new Pawn(black));
        this.squares.get(squareIndexFromChessCoordinate("h7")).setPiece(new Pawn(black));

        this.squares.get(squareIndexFromChessCoordinate("a8")).setPiece(new Rook(black));
        this.squares.get(squareIndexFromChessCoordinate("h8")).setPiece(new Rook(black));
        this.squares.get(squareIndexFromChessCoordinate("b8")).setPiece(new Knight(black));
        this.squares.get(squareIndexFromChessCoordinate("g8")).setPiece(new Knight(black));
        this.squares.get(squareIndexFromChessCoordinate("c8")).setPiece(new Bishop(black));
        this.squares.get(squareIndexFromChessCoordinate("f8")).setPiece(new Bishop(black));
        this.squares.get(squareIndexFromChessCoordinate("d8")).setPiece(new Queen(black));
        this.squares.get(squareIndexFromChessCoordinate("e8")).setPiece(new King(black));


    }

    public int squareIndexFromChessCoordinate(String chessCoordinate) {
        char file = chessCoordinate.charAt(0);
        char rank = chessCoordinate.charAt(1);
        int fileIndex = FILE_CHARS.indexOf(file) + 1;
        int rankIndex = Character.getNumericValue(rank);
        int squareIndex = ((rankIndex-1) * FILES) + fileIndex;
        return squareIndex;
    }

    private void makeSet(Color color) {

    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }
}
