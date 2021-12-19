package main;

import GameStatus.GameStatus;
import board.Board;
import players.Player;

import java.util.ArrayList;

public class Game {

    Board board;
    ArrayList<Player> players;
    GameStatus gameStatus;
    Controller controller;

    public Game(Controller controller, ArrayList<Player> players) {
        this.controller = controller;
        this.players = players;
        this.board = new Board();
        this.gameStatus = GameStatus.PRESTART;

    }



}
