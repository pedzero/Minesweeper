package gui;

import minesweeper.*;

/**
 *
 * @author pedzero
 */
public class MainTest {

    public static void main(String[] args) {
        Board board = new Board(10, 10);

        board.setRandomMines(250);

        int cont = 0;
        for (int i = 0; i < board.get().length; i++) {
            Cell[] temp = board.get()[i];
            for (int j = 0; j < temp.length; j++) {
                /*if (temp[j].isMinedCell()) {
                    System.out.print("1");
                    cont++;
                } else {
                    System.out.print("0");
                }*/
                System.out.print((char)(temp[j].isMinedCell() == true ? 'X' : (temp[j].getAdjascentMines()+48)));
                System.out.print(" ");

            }
            System.out.println("");
        }
    }
}
