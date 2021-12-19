package board;

public class ChessCoordinate {

    private final int FILES = 8;
    private final int RANKS = 8;

    private final static String FILE_CHARS = "abcdefgh";
    private final String chessCoordinate;

    public ChessCoordinate(int file, int rank) {
        char fileChar = FILE_CHARS.charAt(file-1);
        this.chessCoordinate = "" + fileChar + rank;
    }

    public String getChessCoordinate() {
        return this.chessCoordinate;
    }




}
