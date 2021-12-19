package main;

import board.ChessCoordinate;

import java.util.ArrayList;

import static pieces.PieceType.QUEEN;
import static pieces.PieceType.ROOK;

public class TesterClass {



    private void loop() {
        for (int f=1; f <= 8; f++) {
            for (int r=1; r <= 8; r++) {
                ChessCoordinate cc = new ChessCoordinate(f, r);
                System.out.println(cc.getChessCoordinate());

            }
        }
    }

    private static void characterTest() {
        String s = "abcdefgh";
        int i = s.indexOf("a") + 1;

        char file = "a1".charAt(0);
        char rank = "a1".charAt(1);

        System.out.println(i);
        System.out.println(Character.getNumericValue(rank));
        System.out.println(file +"" + rank);
    }

    private static void mathTest() {
        int one = 1000;
        one += (100 + 10); //1110
        System.out.println(one);
        one = 1000;
        one += (100 - 10); //1090
        System.out.println(one);
        one = 1000;
        one -= (100 + 10); //890
        System.out.println(one);
        one = 1000;
        one -= (100 - 10); //910
        System.out.println(one);

    }

    public enum PType {
        ROOKY, QUEENY;
    }

    private static void objectTest() {



        ArrayList<PType> pieces = new ArrayList<>();
        PType rook = PType.ROOKY;
        pieces.add(rook);
        pieces.add(null);
        System.out.println(pieces.contains(PType.QUEENY));
        System.out.println(pieces.contains(PType.ROOKY));
        System.out.println(pieces.get(1));

    }





    public static void main(String[] args) {
        objectTest();


    }
}
