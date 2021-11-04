package com.ticTacToe.service;

import com.ticTacToe.model.Game;
import com.ticTacToe.model.Player;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class PlayerService {
    private final Scanner scan = new Scanner(System.in);

    public void pickOpponent(Game game) {
        System.out.println("Choose an opponent 1 - Player, 2 - Computer");
        int input = scan.nextInt();
        while (input != 1 && input != 2) {
            System.out.println("Incorrect input, repeat");
            input = scan.nextInt();
        }
        game.setPvp(input == 1);
    }

    public void pickName(List<Player> players, boolean isPvp) {
        System.out.println("First player enter a name");
        players.get(0).setName(scan.next());

        if (isPvp) {
            System.out.println("Second player enter a name");
            players.get(1).setName(scan.next());
        } else {
            players.get(1).setName("Computer");
        }
    }

    public void pickSymbol(List<Player> players, boolean isPvp) {
        int random = isPvp ? new Random().nextInt(2) : 0;
        Player firstPlayer = players.get(0);
        Player secondPlayer = players.get(0);

        System.out.printf("Player %s select symbol X or O \n",
                random == 0 ? firstPlayer.getName() : secondPlayer.getName());

        String input = scan.next().toUpperCase(Locale.ROOT);

        while (!input.equals("O") & !input.equals("X")) {
            System.out.println("Incorrect input, repeat");
            input = scan.next().toUpperCase(Locale.ROOT);
        }

        if (random == 0) {
            firstPlayer.setSymbol(input);
            secondPlayer.setSymbol(input.equals("X") ? "O" : "X");
        } else {
            firstPlayer.setSymbol(input);
            secondPlayer.setSymbol(input.equals("X") ? "O" : "X");
        }

        System.out.println(firstPlayer.getName() + " = " + firstPlayer.getSymbol() + "\n" +
                secondPlayer.getName() + " = " + secondPlayer.getSymbol());
    }

    public void movePlayer(Game game, int numberPlayer) {
        String gameBoard = game.getGameBoard();
        Player player = game.getPlayers().get(numberPlayer);
        System.out.println(gameBoard);

        System.out.printf("Player %s your turn: ", player.getName());
        Integer input = scan.nextInt();

        while (!game.getAccessMove().contains(input)) {
            System.out.println("Incorrect input, repeat");
            input = scan.nextInt();
        }

        game.setGameBoard(gameBoard.replace(String.valueOf(input), player.getSymbol()));
        player.getMove().add(input);
        game.getAccessMove().remove(input);
    }

    public void moveComputer(Game game) {
        Player computer = game.getPlayers().get(1);
        int random = new Random().nextInt(game.getAccessMove().size());
        Integer moveComputer = game.getAccessMove().get(random);

        game.setGameBoard(game.getGameBoard().replace(String.valueOf(moveComputer),
                computer.getSymbol()));

        computer.getMove().add(moveComputer);
        game.getAccessMove().remove(moveComputer);
    }
}
