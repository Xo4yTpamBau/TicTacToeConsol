package com.ticTacToe;

import com.ticTacToe.service.GameService;

public class TicTacToe {
    public static void main(String[] args) {
        new GameService().startGame();
    }
}