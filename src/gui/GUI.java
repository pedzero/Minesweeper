package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import com.formdev.flatlaf.*;
import map.*;
import minesweeper.*;
import minesweeper.Cell.State;
import static minesweeper.Cell.State.*;

/**
 *
 * @author pedzero
 */
public class GUI extends javax.swing.JFrame {

    private final int defaultSize = 10;
    private final int cellSize = 20;
    private final List<Component> boardCells = new ArrayList<>();

    private Board game;
    private CellMap[][] map;
    private boolean running, gameOver;
    private int sizeX = defaultSize;
    private int sizeY = defaultSize;
    private int level = 60;
    private int flagsCount;
    private int cellsRevealed;

    public GUI() {
        initComponents();
        initSettings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonNewGame = new javax.swing.JButton();
        tabbedPanel = new javax.swing.JTabbedPane();
        panelSettings = new javax.swing.JPanel();
        radioButtonEasy = new javax.swing.JRadioButton();
        radioButtonNormal = new javax.swing.JRadioButton();
        radioButtonHard = new javax.swing.JRadioButton();
        radioButtonCustom = new javax.swing.JRadioButton();
        labelLevel = new javax.swing.JLabel();
        labelBoardSize = new javax.swing.JLabel();
        sliderLevel = new javax.swing.JSlider();
        labelDifficulty = new javax.swing.JLabel();
        labelSettedLevel = new javax.swing.JLabel();
        textFieldLengthX = new javax.swing.JTextField();
        textFieldLengthY = new javax.swing.JTextField();
        separatorDifficultyCustom = new javax.swing.JSeparator();
        separatorLogoConfig = new javax.swing.JSeparator();
        labelLogo = new javax.swing.JLabel();
        panelGame = new javax.swing.JPanel();
        buttonClose = new javax.swing.JButton();
        buttonStartGame = new javax.swing.JButton();
        labelFlags = new javax.swing.JLabel();
        separatorMainPanel = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MineSweeper");
        setName("minesweeper"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));

        buttonNewGame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonNewGame.setText("Novo Jogo");
        buttonNewGame.setRequestFocusEnabled(false);
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGameActionPerformed(evt);
            }
        });

        tabbedPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        tabbedPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPanelStateChanged(evt);
            }
        });

        buttonGroup.add(radioButtonEasy);
        radioButtonEasy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonEasy.setText("Fácil");

        buttonGroup.add(radioButtonNormal);
        radioButtonNormal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonNormal.setText("Médio");

        buttonGroup.add(radioButtonHard);
        radioButtonHard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonHard.setText("Difícil");

        buttonGroup.add(radioButtonCustom);
        radioButtonCustom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonCustom.setText("Custom");
        radioButtonCustom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioButtonCustomStateChanged(evt);
            }
        });

        labelLevel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLevel.setText("Nível");

        labelBoardSize.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelBoardSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBoardSize.setText("Tamanho do Tabuleiro");

        sliderLevel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderLevelStateChanged(evt);
            }
        });

        labelDifficulty.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDifficulty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDifficulty.setText("Dificuldade");

        labelSettedLevel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelSettedLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSettedLevel.setText("0");

        textFieldLengthX.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textFieldLengthY.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/logo.png"))); // NOI18N
        labelLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelSettingsLayout = new javax.swing.GroupLayout(panelSettings);
        panelSettings.setLayout(panelSettingsLayout);
        panelSettingsLayout.setHorizontalGroup(
            panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separatorLogoConfig, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separatorDifficultyCustom)
                    .addComponent(labelLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(sliderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSettedLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldLengthX, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldLengthY, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioButtonEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioButtonNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioButtonHard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioButtonCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
                        .addComponent(labelDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(labelBoardSize, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelSettingsLayout.setVerticalGroup(
            panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorLogoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonEasy, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioButtonNormal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButtonCustom)
                        .addComponent(radioButtonHard)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorDifficultyCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBoardSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldLengthY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldLengthX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSettedLevel))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Configurar", panelSettings);

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        tabbedPanel.addTab("Jogo", panelGame);

        buttonClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonClose.setText("Fechar");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        buttonStartGame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonStartGame.setText("Começar");
        buttonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartGameActionPerformed(evt);
            }
        });

        labelFlags.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelFlags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStartGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separatorMainPanel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separatorMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonNewGame)
                        .addComponent(buttonStartGame)
                        .addComponent(buttonClose))
                    .addComponent(labelFlags, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void sliderLevelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderLevelStateChanged
        labelSettedLevel.setText(Integer.toString(sliderLevel.getValue(), 10) + "%");
    }//GEN-LAST:event_sliderLevelStateChanged

    private void radioButtonCustomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioButtonCustomStateChanged
        if (radioButtonCustom.isSelected()) {
            setCustomSettingsVisibility(true);
        } else {
            setCustomSettingsVisibility(false);
        }
    }//GEN-LAST:event_radioButtonCustomStateChanged

    private void buttonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartGameActionPerformed
        if (running) {
            running = false;
        }
        labelFlags.setText("");

        setGameSettings();
        createBoard();

        tabbedPanel.setSelectedComponent(panelGame);
    }//GEN-LAST:event_buttonStartGameActionPerformed

    private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
        tabbedPanel.setSelectedComponent(panelSettings);
    }//GEN-LAST:event_buttonNewGameActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void tabbedPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPanelStateChanged
        Component panel = tabbedPanel.getSelectedComponent();

        if (panel == panelSettings) {
            buttonNewGame.setVisible(false);
            buttonStartGame.setVisible(true);
            labelFlags.setVisible(false);
            setSettingPanelSize();
        } else {
            buttonNewGame.setVisible(true);
            buttonStartGame.setVisible(false);
            setGamePanelSize();
            if (game != null) {
                labelFlags.setVisible(true);
            } else {
                labelFlags.setVisible(false);
            }
        }
        this.requestFocusInWindow();
    }//GEN-LAST:event_tabbedPanelStateChanged

    private void setCustomSettingsVisibility(boolean visible) {
        labelDifficulty.setEnabled(visible);
        labelBoardSize.setEnabled(visible);
        labelSettedLevel.setEnabled(visible);
        sliderLevel.setEnabled(visible);
        textFieldLengthX.setEnabled(visible);
        textFieldLengthY.setEnabled(visible);
    }

    private void initSettings() {
        setCustomSettingsVisibility(false);
        sliderLevel.setMaximum(100);
        sliderLevel.setMinimum(40);
        sliderLevel.setValue(level);
        buttonGroup.setSelected(radioButtonNormal.getModel(), true);
    }

    private void setGameSettings() {
        ButtonModel selectedButton = buttonGroup.getSelection();

        if (selectedButton == radioButtonEasy.getModel()) {
            sizeX = 10;
            sizeY = 10;
            level = 52;
        } else if (selectedButton == radioButtonNormal.getModel()) {
            sizeX = 16;
            sizeY = 16;
            level = 71;
        } else if (selectedButton == radioButtonHard.getModel()) {
            sizeX = 21;
            sizeY = 21;
            level = 95;
        } else {
            setCustomSettings();
        }
    }

    private void setCustomSettings() {
        String textFXValue = textFieldLengthX.getText();
        String textFYValue = textFieldLengthY.getText();

        if (textFXValue.equals("")) {
            sizeX = defaultSize;
        } else {
            sizeX = Integer.max(Integer.min(Integer.parseInt(textFXValue), 21), 10);
            textFieldLengthX.setText(Integer.toString(sizeX));
        }

        if (textFYValue.equals("")) {
            sizeY = defaultSize;
        } else {
            sizeY = Integer.max(Integer.min(Integer.parseInt(textFXValue), 21), 10);
            textFieldLengthY.setText(Integer.toString(sizeY));
        }

        level = sliderLevel.getValue();
    }

    private void createBoard() {

        emptyBoard();

        gameOver = false;
        cellsRevealed = 0;
        game = new Board(sizeX, sizeY);

        Cell[][] board = game.get();
        int gameSizeX = board.length;
        int gameSizeY = board[0].length;
        map = new CellMap[gameSizeX][gameSizeY];

        setGamePanelSize();

        for (int i = 0; i < gameSizeX; i++) {
            for (int j = 0; j < gameSizeY; j++) {
                CellMap cm = createBoardCell(panelGame, Color.GRAY, Color.decode("#b01d06"), i, j);
                cm.getCellButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            cellActionLeftClicked(cm);
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            cellActionRightClicked(cm);
                        }
                    }
                });
            }
        }
        panelGame.revalidate();
        panelGame.repaint();
    }

    private void emptyBoard() {
        for (Component c : panelGame.getComponents()) {
            if (boardCells.contains(c)) {
                panelGame.remove(c);
            }
        }
        boardCells.clear();
        map = null;
    }

    private void setSettingPanelSize() {
        this.setSize(600, 600);
    }

    private void setGamePanelSize() {
        if (game != null) {
            int gameSizeX = game.get().length;

            this.setSize(Integer.max((gameSizeX * cellSize) + 70, 267), 600);
            panelGame.setSize(10, 10);
            checkGameState();
        }
    }

    private CellMap createBoardCell(JPanel panel, Color bgColor, Color fgColor, int i, int j) {
        CellMap cm = new CellMap(game.get()[i][j], new Point(i, j));
        map[i][j] = cm;

        Font font = new Font("Segoe UI Symbol", Font.PLAIN, 10);

        boardCells.addAll(Arrays.asList(cm.getCellButton()));
        cm.getCellButton().setBounds((cellSize * (i + 1)), (cellSize * (j + 1)), cellSize, cellSize);
        cm.getCellButton().setBackground(bgColor);
        cm.getCellButton().setForeground(fgColor);
        cm.getCellButton().setFont(font);
        panel.add(cm.getCellButton());

        return cm;
    }

    private void updateFlagCount(boolean addFlag) {
        if (addFlag) {
            flagsCount++;
        }
        setFlagCountText();
    }

    private void updateFlagCount() {
        flagsCount--;
        setFlagCountText();
    }

    private void setFlagCountText() {
        StringBuilder str = new StringBuilder();

        str.append("<html>\n");
        str.append("    <font color = '#B01D06'>\n");
        str.append(Cell.State.flagged.getChar());
        str.append("</font>");
        str.append(" ");
        str.append(Integer.toString(flagsCount));

        labelFlags.setText(str.toString());
    }

    private void firstClick(CellMap cm) {
        running = true;
        game.setRandomMines(cm.getPosition(), level);
        flagsCount = game.getMineCount();
        updateFlagCount(false);
        printBoard();
    }

    private void cellActionRightClicked(CellMap cm) {
        if (!running) {
            firstClick(cm);
        }

        if (gameOver) {
            return;
        }

        JButton cellButton = cm.getCellButton();
        Cell cellData = cm.getCellData();

        State s = cellData.getState();

        switch (s) {
            case closed -> {
                updateFlagCount();
                cellButton.setText(Character.toString(Cell.State.flagged.getChar()));
                cellData.setState(flagged);
            }

            case flagged -> {
                updateFlagCount(true);
                cellButton.setText("");
                cellData.setState(closed);
            }
        }
    }

    private void cellActionLeftClicked(CellMap cm) {
        if (!running) {
            firstClick(cm);
        }

        if (gameOver) {
            return;
        }

        Cell cellData = cm.getCellData();

        State s = cellData.getState();

        switch (s) {
            case closed -> {
                openCell(cm);
            }

            case flagged -> {
                openCell(cm);
            }
        }
        this.requestFocusInWindow();
    }

    private void openCell(CellMap cm) {
        Point position = cm.getPosition();
        Cell cellData = cm.getCellData();

        if (cellData.isMinedCell()) {
            running = false;
            gameOver = true;
        } else {
            openCellsRecursively(position.x, position.y);
        }
        checkGameState();
    }

    private void openCellsRecursively(int i, int j) {
        CellMap cm = map[i][j];
        Cell cellData = cm.getCellData();
        Point position = cm.getPosition();
        JButton cellButton = cm.getCellButton();

        if (cellData.isOpened()) {
            return;
        }

        if (cellData.getState() == flagged) {
            updateFlagCount(true);
        }

        cellData.setState(opened);
        cellButton.setForeground(Color.BLACK);

        int adjacentMines = cellData.getAdjacentMines();
        if (!cellData.isMinedCell()) {
            if (adjacentMines == 0) {
                openCellsRecursively(position.x, Integer.max(0, (position.y - 1)));
                openCellsRecursively(position.x, Integer.min(sizeY - 1, (position.y + 1)));
                openCellsRecursively(Integer.min(sizeX - 1, (position.x + 1)), position.y);
                openCellsRecursively(Integer.max(0, (position.x - 1)), position.y);
            }
            cellData.setState(opened);
            cellButton.setText(Integer.toString(cellData.getAdjacentMines(), 10));
            cellButton.setBackground(Color.LIGHT_GRAY);
            cellsRevealed++;
        }
    }

    private void revealMines(boolean lose) {
        var mines = game.getSettedMines();

        mines.forEach((var mine) -> {
            CellMap cm = map[mine.x][mine.y];
            JButton cellButton = cm.getCellButton();

            if (lose) {
                cellButton.setBackground(Color.decode("#b01d06"));
            } else {
                cellButton.setBackground(Color.decode("#05B062"));
            }

            cellButton.setForeground(Color.BLACK);
            cellButton.setText("\u25ce");
        });
    }

    private void checkGameState() {
        if (gameOver) {
            labelFlags.setText("Game Over! Você perdeu.");
            revealMines(true);
            this.setSize(600, 600);
            panelGame.setSize(10, 10);
        }
        if (game.gameWin(cellsRevealed)) {
            labelFlags.setText("Parabéns! Você ganhou.");
            revealMines(false);
            this.setSize(600, 600);
            panelGame.setSize(10, 10);
        }
    }

    public void printBoard() {
        for (int i = 0; i < game.get().length; i++) {
            for (int j = 0; j < game.get()[0].length; j++) {
                System.out.print((char) (game.get()[j][i].isMinedCell() == true ? 'X' : (game.get()[j][i].getAdjacentMines() + 48)));
                System.out.print(" ");

            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {

        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#b01d06"));
        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonNewGame;
    private javax.swing.JButton buttonStartGame;
    private javax.swing.JLabel labelBoardSize;
    private javax.swing.JLabel labelDifficulty;
    private javax.swing.JLabel labelFlags;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelSettedLevel;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelSettings;
    private javax.swing.JRadioButton radioButtonCustom;
    private javax.swing.JRadioButton radioButtonEasy;
    private javax.swing.JRadioButton radioButtonHard;
    private javax.swing.JRadioButton radioButtonNormal;
    private javax.swing.JSeparator separatorDifficultyCustom;
    private javax.swing.JSeparator separatorLogoConfig;
    private javax.swing.JSeparator separatorMainPanel;
    private javax.swing.JSlider sliderLevel;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField textFieldLengthX;
    private javax.swing.JTextField textFieldLengthY;
    // End of variables declaration//GEN-END:variables
}
