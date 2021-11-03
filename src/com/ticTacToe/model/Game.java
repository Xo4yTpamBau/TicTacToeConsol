package com.ticTacToe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private String gameBoard = "" +
            "1|2|3\n" +
            "-+-+-\n" +
            "4|5|6\n" +
            "-+-+-\n" +
            "7|8|9";

    private int[] score = {0, 0};

    private List<Player> players = List.of(new Player(), new Player());

    private List<Integer> accessMove = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

    private boolean pvp;

    public Game() {
    }

    public Game(int[] score,
                String nameFirstPlayer,
                String nameSecondPlayer,
                boolean isPvp) {
        this.score = score;
        players.get(0).setName(nameFirstPlayer);
        players.get(1).setName(nameSecondPlayer);
        this.pvp = isPvp;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Integer> getAccessMove() {
        return accessMove;
    }

    public void setAccessMove(List<Integer> accessMove) {
        this.accessMove = accessMove;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public boolean isPvp() {
        return pvp;
    }

    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }

    public String getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int[] getScore() {
        return score;
    }
}
