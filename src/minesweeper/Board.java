package minesweeper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import minesweeper.Cell.State;
import static minesweeper.Cell.State.*;

/**
 * Represents a board and has methods to be played.
 *
 * @author pedzero
 */
public class Board {

    private final Cell[][] board;
    private final double[][] safeAreaProbability;
    private final boolean[][] safePoints;
    private final List<Point> settedMines = new ArrayList<>();
    private final int width, height;

    private GameState state;
    private int controlSafePointsCount;
    private int maxMineCount;
    private int flagsCount;
    private int cellsRevealed;

    private enum GameState {
        created,
        running,
        over,
        overWin
    }

    /**
     * Creates a new board, with specified dimensions and difficulty level. Size
     * smaller than 10 can generate bugs.
     *
     * @param width Specifies the width of the board.
     * @param height Specifies the height of the board.
     * @param level Specifies the difficulty level.
     */
    public Board(int width, int height, int level) {
        board = new Cell[width][height];
        safePoints = new boolean[width][height];
        safeAreaProbability = new double[width][height];
        this.width = width;
        this.height = height;

        initBoard(level);
    }

    /**
     * Places or removes a flag on a cell on the board.
     *
     * @param position Selected cell position.
     */
    public void flagCell(Point position) {
        if (state == GameState.created) {
            firstClick(position);
        }

        if (state == GameState.over) {
            return;
        }

        if (flagsCount == 0) {
            return;
        }

        Cell cellData = board[position.x][position.y];
        State cellState = cellData.getState();

        switch (cellState) {
            case closed -> {
                flagsCount--;
                cellData.setState(flagged);
            }

            case flagged -> {
                flagsCount++;
                cellData.setState(closed);
            }
        }
    }

    /**
     * Opens a cell on the board, checking whether the game was lost or won.
     *
     * @param position Selected cell position.
     */
    public void openCell(Point position) {
        if (state == GameState.created) {
            firstClick(position);
        }

        if (state == GameState.over) {
            return;
        }

        Cell cellData = board[position.x][position.y];

        if (cellData.isMinedCell()) {
            state = GameState.over;
        } else {
            openCellsRecursively(position);
        }

        if (isWon()) {
            state = GameState.overWin;
        }
    }

    /**
     * Starts the attributes of the board, creating variations according to the
     * level.
     *
     * @param level Selected difficulty level.
     */
    private void initBoard(int level) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = new Cell();
                board[i][j].setState(Cell.State.closed);
            }
        }

        if (level < 40) {
            level = 40;
        } else if (level > 100) {
            level = 100;
        }

        float mineDensity = ((float) level / 100) * 0.22F;
        maxMineCount = (Math.round((width * height) * mineDensity));
        flagsCount = 0;
        cellsRevealed = 0;
        state = GameState.created;
    }

    /**
     * Places mines randomly across the board, but respects some rules, ensuring
     * that the game becomes more deterministic.
     *
     * @param startPosition Start position or first-click position.
     */
    private void setRandomMines(Point startPosition) {

        createSafeArea(startPosition);

        Random random = new Random();

        for (int i = 0; i < maxMineCount; i++) {
            Point randomPos;

            do {
                randomPos = new Point(random.nextInt(width), random.nextInt(height));
            } while (board[randomPos.x][randomPos.y].isMinedCell() || isWithinDistance(startPosition, randomPos, 2));

            createMine(randomPos);

            // 90% chance to place two adjacent mines.
            if (random.nextDouble() <= 0.8) {
                List<Point> adjacentPositions = getAdjacentPositions(randomPos);
                if (!adjacentPositions.isEmpty()) {
                    int randomIndex;
                    Point adjacentPosition;
                    do {
                        randomIndex = random.nextInt(adjacentPositions.size());
                        adjacentPosition = adjacentPositions.get(randomIndex);
                    } while (adjacentPosition.equals(startPosition) || board[adjacentPosition.x][adjacentPosition.y].isMinedCell());

                    createMine(adjacentPosition);
                    i++;
                }
            }
        }
        setAdjacentMines();
    }

    /**
     * Apply the necessary methods to start the game.
     *
     * @param startPosition Start position or first-click position.
     */
    private void firstClick(Point startPosition) {
        if (state == GameState.running) {
            return;
        }
        state = GameState.running;
        setRandomMines(startPosition);
    }

    /**
     * Open adjacent cells recursively until find a cell that has adjacent
     * mines.
     *
     * @param position Opened cell position.
     */
    private void openCellsRecursively(Point position) {
        Cell cellData = board[position.x][position.y];

        if (cellData.isOpened()) {
            return;
        }

        if (cellData.getState() == flagged) {
            flagsCount++;
        }
        cellData.setState(opened);
        cellsRevealed++;

        int adjacentMines = cellData.getAdjacentMinesCount();
        if (!cellData.isMinedCell() && adjacentMines == 0) {
            List<Point> adjacentPositions = getAdjacentPositions(position);
            for (Point adjacentPosition : adjacentPositions) {
                openCellsRecursively(adjacentPosition);
            }
        }
    }

    /**
     * Apply the methods needed to create a mine.
     *
     * @param position Position where the mine will be created.
     */
    private void createMine(Point position) {
        if (board[position.x][position.y].isMinedCell()) {
            return;
        }
        board[position.x][position.y].setMinedCell(true);
        settedMines.add(new Point(position.x, position.y));
        flagsCount++;
    }

    /**
     * Apply methods to create a safe area (no mines), with varying size.
     *
     * @param startPosition Starting position of safe area.
     */
    private void createSafeArea(Point startPosition) {
        Random random = new Random();
        float safePointsMultiplier = random.nextFloat(0.07F, 0.14F);

        int safePointsCount = Math.round((width * height) * safePointsMultiplier);
        controlSafePointsCount = safePointsCount;

        initializeSafeAreaStructure(startPosition);
        createSafeAreaRecursively(startPosition);
    }

    /**
     * Initialize control variables and define a probability for each cell to be
     * a safe position or not.
     *
     * @param startPosition Starting position of safe area.
     */
    private void initializeSafeAreaStructure(Point startPosition) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double distance = Math.sqrt(Math.pow(startPosition.x - x, 2) + Math.pow(startPosition.y - y, 2));
                double attenuation = Math.pow(0.9, distance);
                safeAreaProbability[x][y] = attenuation;
            }
        }
    }

    /**
     * Create safe cells on the board, respecting the probability rules created.
     *
     * @param position Position of the selected cell.
     */
    private void createSafeAreaRecursively(Point position) {
        if (safePoints[position.x][position.y]) {
            return;
        }

        if (controlSafePointsCount <= 0) {
            return;
        }

        safePoints[position.x][position.y] = true;
        controlSafePointsCount--;

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

    /**
     * Checks whether two points are a minimum distance apart.
     *
     * @param position1 Position of a cell.
     * @param position2 Position of another cell.
     * @param distance Minimum distance between cells.
     * @return True for closely spaced cells, false otherwise.
     */
    private boolean isWithinDistance(Point position1, Point position2, int distance) {
        int dx = Math.abs(position1.x - position2.x);
        int dy = Math.abs(position1.y - position2.y);
        return dx <= distance && dy <= distance;
    }

    /**
     * Groups the positions of all cells adjacent to the selected one.
     *
     * @param position Selected cell position.
     * @return List with the positions of adjacent cells.
     */
    private List<Point> getAdjacentPositions(Point position) {
        List<Point> adjacentPositions = new ArrayList<>();

        int startX = Math.max(0, position.x - 1);
        int startY = Math.max(0, position.y - 1);
        int endX = Math.min(width - 1, position.x + 1);
        int endY = Math.min(height - 1, position.y + 1);

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != position.x || y != position.y) {
                    adjacentPositions.add(new Point(x, y));
                }
            }
        }
        return adjacentPositions;
    }

    /**
     * Sets the amount of mines adjacent to each cell on the board.
     */
    private void setAdjacentMines() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setAdjacentMinesCount(countMinesAround(new Point(i, j)));
            }
        }
    }

    /**
     * Checks the amount of mines around a selected cell.
     *
     * @param position Selected cell position.
     * @return
     */
    private int countMinesAround(Point position) {
        int minesAround = 0;

        for (int i = position.x - 1; i <= position.x + 1; i++) {
            for (int j = position.y - 1; j <= position.y + 1; j++) {
                if (i >= 0 && i < width && j >= 0 && j < height && !(i == position.x && j == position.y)) {
                    if (board[i][j].isMinedCell()) {
                        minesAround++;
                    }
                }
            }
        }
        return minesAround;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getMineCount() {
        return settedMines.size();
    }

    public List<Point> getSettedMines() {
        return settedMines;
    }

    public int getFlagsCount() {
        return flagsCount;
    }

    public boolean isWon() {
        return (flagsCount == 0) && (cellsRevealed + settedMines.size() == (width * height));
    }

    public boolean isLost() {
        return state == GameState.over;
    }

    public boolean isRunning() {
        return state == GameState.running;
    }
}
