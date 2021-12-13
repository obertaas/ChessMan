package main;

import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSSGenerator {

    static void createCSSFile(String pathName) {
        try {
            File file = new File(pathName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void writeToCSSFile(String pathName) {
        try {
            FileWriter fileWriter = new FileWriter(pathName);
            ArrayList<Pair<String,String>> squares = chessSquares();
            for (Pair<String,String> square : squares)
                writeTemplate(fileWriter, square);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeTemplate(FileWriter fileWriter, Pair<String,String> square) {
        try {
            fileWriter.write("\n");
            fileWriter.write("#" + square.getKey() + "{\n");
            fileWriter.write("\t-fx-background-color: " + square.getValue() + ";\n");
            fileWriter.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Pair<String, String>> chessSquares() {
        char[] files = "abcdefgh".toCharArray();
        char[] ranks = "12345678".toCharArray();
        ArrayList<Pair<String,String>> squares = new ArrayList<>();
        for (int f=0; f < files.length; f++) {
            for (int r=0; r < ranks.length; r++) {
                String square = files[f] + "" + ranks[r];
                squares.add(new Pair(square, ((f+r) % 2 == 0 ? "gray" : "beige")));
            }
        }
        System.out.println(squares);
        return squares;
    }

    static void createAndWriteCSSFile(String pathName) {
        createCSSFile(pathName);
        writeToCSSFile(pathName);
    }


    public static void main(String[] args) {
        createAndWriteCSSFile("src/css/chessPattern.css");
    }



}
