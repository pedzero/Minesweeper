package minesweeper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pedzero
 */
public class Board {

    private final boolean[][] safePoints;
    private final double[][] safeAreaProbability;
    private int controlSafePointsAmount;

    private final Cell[][] board;
    private final List<Point> settedMines = new ArrayList<>();
    private boolean bombsCreated = false;
    int sizeX, sizeY;
    int mineCount;

    public Board(int sizeX, int sizeY) {
        board = new Cell[sizeX][sizeY];
        safePoints = new boolean[sizeX][sizeY];
        safeAreaProbability = new double[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[i][j] = new Cell();
                board[i][j].setState(Cell.State.closed);
            }
        }
    }

    public void setRandomMines(Point startPosition, int level) {
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

        createSafeArea(startPosition);

        Random random = new Random();

        float levelMultiplier = ((float) level / 100) * 0.22F;

        mineCount = (Math.round((sizeX * sizeY) * levelMultiplier));

        for (int i = 0; i < mineCount; i++) {
            int randomPosX;
            int randomPosY;

            do {
                randomPosX = random.nextInt(sizeX);
                randomPosY = random.nextInt(sizeY);
            } while (board[randomPosX][randomPosY].isMinedCell() || isWithinDistance(startPosition, randomPosX, randomPosY, 2));

            board[randomPosX][randomPosY].setMinedCell(true);
            settedMines.add(new Point(randomPosX, randomPosY));

            if (random.nextDouble() <= 0.9) {
                // Gerar uma bomba adjacente em uma posição adjacente aleatória
                List<Point> adjacentPositions = getAdjacentPositions(new Point(randomPosX, randomPosY));
                if (!adjacentPositions.isEmpty()) {
                    int randomIndex;
                    Point adjacentPosition;
                    do {
                        randomIndex = random.nextInt(adjacentPositions.size());
                        adjacentPosition = adjacentPositions.get(randomIndex);
                    } while (adjacentPosition.equals(startPosition));

                    board[adjacentPosition.x][adjacentPosition.y].setMinedCell(true);
                    settedMines.add(adjacentPosition);
                    i++;
                }
            }
        }
        setAdjacentMines();
    }

    private void createSafeArea(Point startPosition) {
        Random random = new Random();
        float safePointsMultiplier = random.nextFloat(0.07F, 0.15F);

        int safePointsAmount = Math.round((sizeX * sizeY) * safePointsMultiplier);
        controlSafePointsAmount = safePointsAmount;

        initializeSafeAreaStructure(startPosition);
        createSafeAreaRecursively(startPosition);
    }

    private void initializeSafeAreaStructure(Point startPosition) {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                double distance = Math.sqrt(Math.pow(startPosition.x - x, 2) + Math.pow(startPosition.y - y, 2));
                double attenuation = Math.pow(0.9, distance);
                safeAreaProbability[x][y] = attenuation;
            }
        }
    }

    private void createSafeAreaRecursively(Point position) {
        if (safePoints[position.x][position.y]) {
            return;
        }

        if (controlSafePointsAmount <= 0) {
            return;
        }

        safePoints[position.x][position.y] = true;
        controlSafePointsAmount--;

        List<Point> adjacentPositions = getAdjacentPositions(position);
        Collections.shuffle(adjacentPositions);

        for (Point adjacent : adjacentPositions) {
            double probability = safeAreaProbability[adjacent.x][adjacent.y];
            if (probability >= 0.7) {
                createSafeAreaRecursively(adjacent);
            } else {
                if (Math.random() <= probability) {
                    createSafeAreaRecursively(adjacent);
                }
            }
        }
    }

    private boolean isWithinDistance(Point startPoint, int x, int y, int distance) {
        int dx = Math.abs(startPoint.x - x);
        int dy = Math.abs(startPoint.y - y);
        return dx <= distance && dy <= distance;
    }

    private List<Point> getAdjacentPositions(Point positions) {
        List<Point> adjacentPositions = new ArrayList<>();

        int startX = Math.max(0, positions.x - 1);
        int startY = Math.max(0, positions.y - 1);
        int endX = Math.min(sizeX - 1, positions.x + 1);
        int endY = Math.min(sizeY - 1, positions.y + 1);

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != positions.x || y != positions.y) {
                    adjacentPositions.add(new Point(x, y));
                }
            }
        }
        return adjacentPositions;
    }

    private void setAdjacentMines() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setAdjacentMines(countMinesAround(i, j));
            }
        }
    }

    private int countMinesAround(int posX, int posY) {
        int minesAround = 0;

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
