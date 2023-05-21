package map;

import java.awt.Point;
import javax.swing.JButton;
import minesweeper.Cell;

/**
 *
 * @author pedzero
 */
public class CellMap {

    private final Cell cellData;
    private final JButton cellButton;
    private final Point position;

    public CellMap(Cell cell, Point position) {
        cellData = cell;
        cellButton = new JButton();
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public Cell getCellData() {
        return cellData;
    }

    public JButton getCellButton() {
        return cellButton;
    }
}
