package SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board
{
    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initialiseCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initialiseCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {

        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if(snakeTail >= snakeHead)
                continue;
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }
        while (numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if(ladderTail >= ladderHead)
                continue;
            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    private Cell getCell(int cellNumber) {
        int row = cellNumber / cells.length;
        int column = cellNumber % cells.length;
        return cells[row][column];
    }

    public int moveToNextPosition(int position) {
        if(position >= cells.length * cells.length - 1)
            return position;

        Cell cell = getCell(position);
        if(cell.jump != null && cell.jump.start == position) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            switch (jumpBy) {
                case "Ladder":
                    System.out.println(" Climbed a Ladder");
                    break;
                case "Snake":
                    System.out.println(" Bitten by Snake");
                    break;
                default:
                    System.out.println("Some error occurred");
            }
            return cell.jump.end;
        }
        return position;
    }
}
