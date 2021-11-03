package com.ticTacToe.service;

import com.ticTacToe.model.Game;

import java.util.*;

public class GameService {
    private final Scanner scan = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private Game game = new Game();

    public void startGame() {
        playerService.pickOpponent(game);
        playerService.pickName(game.getPlayers(), game.isPvp());
        do {
            playerService.pickSymbol(game.getPlayers(), game.isPvp());
            processGame();
            cleanGame();
        } while (repeatGame());
        System.out.println("Thanks for playing");
    }

    private void processGame() {
        System.out.println("Start");
        while (true) {

            playerService.movePlayer(game, 0);
            if (checkWin(game.getPlayers().get(0).getMove())) {
                System.out.println(game.getPlayers().get(0).getName() + " - won");
                game.getScore()[0]++;
                break;
            }

            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }

            if (game.isPvp()) {
                playerService.movePlayer(game, 1);
            } else {
                playerService.moveComputer(game);
            }

            if (checkWin(game.getPlayers().get(1).getMove())) {
                System.out.println(game.getPlayers().get(1).getName() + " - won");
                game.getScore()[1]++;
                break;
            }
        }
        System.out.println(Arrays.toString(game.getScore()));
    }

    private boolean checkWin(List<Integer> movesPlayer) {
        List<List<Integer>> winCombinations = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9),
                List.of(1, 4, 7),
                List.of(2, 5, 8),
                List.of(3, 6, 9),
                List.of(1, 5, 9),
                List.of(7, 5, 3));

        return winCombinations.stream()
                .anyMatch(movesPlayer::containsAll);
    }

    private boolean checkDraw() {
        return game.getAccessMove().size() == 0;
    }

    private void cleanGame() {
        game = new Game(
                game.getScore(),
                game.getPlayers().get(0).getName(),
                game.getPlayers().get(1).getName(),
                game.isPvp());
    }

    private boolean repeatGame() {
        System.out.println("Do you want to repeat the game? 1 -  Yes, 2 - No");
        int input = scan.nextInt();

        while (input != 1 && input != 2) {
            System.out.println("Incorrect input, repeat");
            input = scan.nextInt();
        }
        return input == 1;
    }
}