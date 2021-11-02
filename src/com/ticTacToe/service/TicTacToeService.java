package com.ticTacToe.service;

import com.ticTacToe.model.Game;
import java.util.*;

public class TicTacToeService {
    private final Scanner scan = new Scanner(System.in);
    private Game game = new Game();

    public void startGame() {
        pickOpponent();
        pickName();
        do {
            pickSymbol();
            processGame();
            cleanGame();
        } while (repeatGame());
        System.out.println("Спасибо за игру");
    }

    private void pickOpponent() {
        System.out.println("С кем бы вы хотели сыграть? 1 - игрок, 2 - компьютер");
        int input = scan.nextInt();
        while (input != 1 && input != 2) {
            System.out.println("Неккоректный ввод, повторите");
            input = scan.nextInt();
        }
        game.setPvp(input == 1);
    }

    private void pickName() {
        System.out.println("Игрок номер один введите ваше имя");
        game.setNameFirstPlayer(scan.next());

        if (game.isPvp()) {
            System.out.println("Игрок номер два введите ваше имя");
            game.setNameSecondPlayer(scan.next());
        } else {
            game.setNameSecondPlayer("Computer");
        }
    }

    private void pickSymbol() {
        int random = game.isPvp() ? new Random().nextInt(2) : 0;

        System.out.printf("Игрок %s выберите сторону за которую хотите играть Х или О \n",
                random == 0 ? game.getNameFirstPlayer() : game.getNameSecondPlayer());

        String input = scan.next().toUpperCase(Locale.ROOT);

        while (!input.equals("O") & !input.equals("X")) {
            System.out.println("Некоректно введены данные, повторите");
            input = scan.next().toUpperCase(Locale.ROOT);
        }

        if (random == 0) {
            game.setSymbolFirstPlayer(input);
            game.setSymbolSecondPlayer(input.equals("X") ? "O" : "X");
        } else {
            game.setSymbolSecondPlayer(input);
            game.setSymbolFirstPlayer(input.equals("X") ? "O" : "X");
        }

        System.out.println(game.getNameFirstPlayer() + " = " + game.getSymbolFirstPlayer() + "\n" +
                game.getNameSecondPlayer() + " = " + game.getSymbolSecondPlayer());
    }

    private void processGame() {
        System.out.println("Да начнётся же сражение");
        while (true) {

            movePlayer(game.getSymbolFirstPlayer(), game.getMoveFirstPlayer());
            if (checkWin(game.getMoveFirstPlayer())) {
                System.out.println(game.getNameFirstPlayer() + " - win");
                game.getScore()[0]++;
                break;
            }

            if (game.isPvp()) {
                movePlayer(game.getSymbolSecondPlayer(), game.getMoveSecondPlayer());
            } else {
                moveComputer();
            }

            if (checkWin(game.getMoveSecondPlayer())) {
                System.out.println(game.getNameSecondPlayer() + " - win");
                game.getScore()[1]++;
                break;
            }
        }
        System.out.println(Arrays.toString(game.getScore()));
    }

    private void movePlayer(String symbolPlayer, List<Integer> movePlayer) {
        String gameBoard = game.getGameBoard();
        System.out.println(gameBoard);

        System.out.println("Выберите ход от 1 до 9");
        Integer input = scan.nextInt();

        while (!game.getAccessMove().contains(input)) {
            System.out.println("Некорректный ввод");
            input = scan.nextInt();
        }

        game.setGameBoard(gameBoard.replace(String.valueOf(input), symbolPlayer));
        movePlayer.add(input);
        game.getAccessMove().remove(input);
    }

    private void moveComputer() {
        int random = new Random().nextInt(game.getAccessMove().size());
        Integer moveComputer = game.getAccessMove().get(random);

        game.setGameBoard(game.getGameBoard().replace(String.valueOf(moveComputer),
                game.getSymbolSecondPlayer()));

        game.getMoveSecondPlayer().add(moveComputer);
        game.getAccessMove().remove(moveComputer);
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
                List.of(7, 5, 9));

        return winCombinations.stream()
                .anyMatch(movesPlayer::containsAll);
    }

    private void cleanGame() {
        game = new Game(
                game.getScore(),
                game.getNameFirstPlayer(),
                game.getNameSecondPlayer());
    }

    private boolean repeatGame() {
        System.out.println("Хотите ли вы повторить игру? 1 - да, 2 - нет");
        int input = scan.nextInt();

        while (input != 1 && input != 2) {
            System.out.println("Неккоректный ввод");
            input = scan.nextInt();
        }
        return input == 1;
    }
}