package pieces;

import java.util.HashSet;

public class SetOfPieces {

    private final int PAWNS = 8;
    private final int KNIGHTS = 2;
    private final int BISHOPS = 2;
    private final int ROOKS = 2;
    private final int QUEENS = 1;
    private final int KINGS = 1;



    private HashSet<Piece> activePieces;
    private HashSet<Piece> capturedPieces;




    public SetOfPieces(Color color) {
        createSet(color);
    }

    private HashSet<Piece> createSet(Color color) {
        HashSet<Piece> activePieces = new HashSet<>();
        //HashSet<Piece> capturedPieces = new HashSet<>();

        //for (int i = 0; i < PAWNS; i++ )


        // 8 pawns, 2 knights, 2 bishops, 2 rooks, 1 queen, 1 king

        return activePieces;

    }


}
