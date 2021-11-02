package com.ticTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String gameBoard = "" +
            "1|2|3\n" +
            "-+-+-\n" +
            "4|5|6\n" +
            "-+-+-\n" +
            "7|8|9";

    private int[] score = {0, 0};

    private String nameFirstPlayer;
    private String nameSecondPlayer;

    private String symbolFirstPlayer;
    private String symbolSecondPlayer;

    private List<Integer> moveFirstPlayer = new ArrayList<>();
    private List<Integer> moveSecondPlayer = new ArrayList<>();
    private List<Integer> accessMove = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

    private boolean pvp;

    public Game() {
    }

    public Game(int[] score,
                String nameFirstPlayer,
                String nameSecondPlayer) {
        this.score = score;
        this.nameFirstPlayer = nameFirstPlayer;
        this.nameSecondPlayer = nameSecondPlayer;
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

    public String getNameFirstPlayer() {
        return nameFirstPlayer;
    }

    public void setNameFirstPlayer(String nameFirstPlayer) {
        this.nameFirstPlayer = nameFirstPlayer;
    }

    public String getNameSecondPlayer() {
        return nameSecondPlayer;
    }

    public void setNameSecondPlayer(String nameSecondPlayer) {
        this.nameSecondPlayer = nameSecondPlayer;
    }

    public String getSymbolFirstPlayer() {
        return symbolFirstPlayer;
    }

    public void setSymbolFirstPlayer(String symbolFirstPlayer) {
        this.symbolFirstPlayer = symbolFirstPlayer;
    }

    public String getSymbolSecondPlayer() {
        return symbolSecondPlayer;
    }

    public void setSymbolSecondPlayer(String symbolSecondPlayer) {
        this.symbolSecondPlayer = symbolSecondPlayer;
    }

    public List<Integer> getMoveFirstPlayer() {
        return moveFirstPlayer;
    }

    public void setMoveFirstPlayer(List<Integer> moveFirstPlayer) {
        this.moveFirstPlayer = moveFirstPlayer;
    }

    public List<Integer> getMoveSecondPlayer() {
        return moveSecondPlayer;
    }

    public void setMoveSecondPlayer(List<Integer> moveSecondPlayer) {
        this.moveSecondPlayer = moveSecondPlayer;
    }
}
