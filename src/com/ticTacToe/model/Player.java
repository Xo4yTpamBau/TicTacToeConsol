package com.ticTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private String symbol;
    private List<Integer> move = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<Integer> getMove() {
        return move;
    }

    public void setMove(List<Integer> move) {
        this.move = move;
    }



}
