package minesweeper;

/**
 *
 * @author pedzero
 */
public class Cell {

    private State state;
    private boolean minedCell;
    private int adjascentMines;

    public enum State {
        closed,
        opened,
        flagged
    }

    public int getAdjascentMines() {
        return adjascentMines;
    }

    public void setAdjascentMines(int adjascentMines) {
        this.adjascentMines = adjascentMines;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isMinedCell() {
        return minedCell;
    }

    public void setMinedCell(boolean minedCell) {
        this.minedCell = minedCell;
    }
}
