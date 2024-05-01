package SnakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game() {
        initialiseGame();
    }

    private void initialiseGame() {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        addPlayers();
        winner = null;
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame() {
        System.out.println("Starting a new game with 2 players: p1 and p2");
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            int diceNumbers = dice.rollDice();

            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition, playerTurn);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("Player turn is " + playerTurn.id + " New Position is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length*board.cells.length - 1)
                winner = playerTurn;
        }
        System.out.println("Winner is " + winner.id);
    }
    private Player findPlayerTurn() {
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }

    private int jumpCheck(int position, Player player) {
        if(position >= board.cells.length*board.cells.length - 1)
            return position;

        Cell cell = board.getCell(position);
        if(cell.jump != null && cell.jump.start == position) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            switch (jumpBy) {
                case "Ladder":
                    System.out.println("Player " + player.id + " Climbed a Ladder");
                    break;
                case "Snake":
                    System.out.println("Player " + player.id + " Bitten by Snake");
                    break;
                default:
                    System.out.println("Some error occurred");
            }
            return cell.jump.end;
        }
        return position;
    }
}
