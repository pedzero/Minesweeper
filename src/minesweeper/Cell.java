package minesweeper;

/**
 *
 * @author pedzero
 */
public class Cell {

    private State state;
    private boolean minedCell;
    private int adjacentMines;
    
    public enum State {
        closed('\u2800'),
        opened('\u2800'),
        flagged('\u2691');
        
        private final char UnicodeChar;

        State(char unicode) {
            this.UnicodeChar = unicode;
        }

        public char getChar() {
            return UnicodeChar;
        }
    }
    
    public Cell() {
        state = State.closed;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
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
    
    public boolean isOpened() {
        return this.state == State.opened;
    }
}
