package SnakeLadder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Board board;
    Dice dice;
    Queue<Player> players = new LinkedList<>();

    public Game() {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void playGame() {
        System.out.println("Starting a new game with 2 players: p1 and p2");
        while (true) {
            Player playerTurn = findPlayerTurn();
            int diceNumbers = dice.rollDice();

            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = board.moveToNextPosition(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("Player turn is " + playerTurn.id + " New Position is: " + playerNewPosition);

            if(playerNewPosition == board.cells.length*board.cells.length - 1) {
                System.out.println("Winner is " + playerTurn.id);
                break;
            }
        }
    }

    private Player findPlayerTurn() {
        Player player = players.remove();
        players.add(player);
        return player;
    }
}
