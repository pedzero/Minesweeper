package minesweeper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pedzero
 */
public class Board {

    private final Cell[][] board;
    private boolean bombsCreated = false;
    private final List<Point> settedMines = new ArrayList<>();
    int mineCount;

    public Board(int sizeX, int sizeY) {
        board = new Cell[sizeX][sizeY];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell();
                board[i][j].setState(Cell.State.closed);
            }
        }
    }

    public void setRandomMines(int level) {
        if (!bombsCreated) {
            bombsCreated = true;
        } else {
            return;
        }

        if (level < 40) {
            level = 40;
        } else if (level > 100) {
            level = 100;
        }

        Random random = new Random();

        int lengthX = board.length;
        int lengthY = board[0].length;

        float levelMultiplier = ((float) level / 100) * 0.22F;

        mineCount = (Math.round((lengthX * lengthY) * levelMultiplier));

        for (int i = 0; i < mineCount; i++) {
            int randomPosX = random.nextInt(lengthX);
            int randomPosY = random.nextInt(lengthY);

            if (board[randomPosX][randomPosY].isMinedCell()) {
                i--;
            } else {
                board[randomPosX][randomPosY].setMinedCell(true);
                settedMines.add(new Point(randomPosX, randomPosY));
            }
        }
        setAdjscentMines();
    }

    private void setAdjscentMines() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setAdjascentMines(countMinesAround(i, j));
            }
        }
    }

    private int countMinesAround(int posX, int posY) {
        int minesAround = 0;
        int sizeX = board.length;
        int sizeY = board[0].length;

        for (int i = posX - 1; i <= posX + 1; i++) {
            for (int j = posY - 1; j <= posY + 1; j++) {
                if (i >= 0 && i < sizeX && j >= 0 && j < sizeY && !(i == posX && j == posY)) {
                    if (board[i][j].isMinedCell()) {
                        minesAround++;
                    }
                }
            }
        }
        return minesAround;
    }

    public Cell[][] get() {
        return board;
    }

    public int getMineCount() {
        return mineCount;
    }

    public List<Point> getSettedMines() {
        return settedMines;
    }
}
