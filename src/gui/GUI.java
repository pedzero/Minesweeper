package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import com.formdev.flatlaf.*;
import minesweeper.*;
import minesweeper.Cell.State;

/**
 *
 * @author pedzero
 */
public class GUI extends javax.swing.JFrame {

    private final int defaultSize = 10;
    private final int cellSize = 20;
    private final List<Component> addedCells = new ArrayList<>();

    private Board game;
    private JButton[][] cellsBoard;
    private int width = defaultSize;
    private int height = defaultSize;
    private int level;

    public enum MineAdjacentColor {
        zero("#000000"),
        one("#24A6B9"),
        two("#009F94"),
        three("#209462"),
        four("#51852A"),
        five("#767000"),
        six("#965300"),
        seven("#B01D06"),
        eight("#6507A7");

        private final String hexCode;

        MineAdjacentColor(String hexCode) {
            this.hexCode = hexCode;
        }

        public String getHexCode() {
            return hexCode;
        }

        public static MineAdjacentColor getColorFromMines(int adjacentMinesCount) {
            if (adjacentMinesCount >= 0 && adjacentMinesCount <= 8) {
                return MineAdjacentColor.values()[adjacentMinesCount];
            } else {
                return MineAdjacentColor.values()[0];
            }
        }
    }

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
        buttonNewGame.setText("New Game");
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
        radioButtonEasy.setText("Easy");

        buttonGroup.add(radioButtonNormal);
        radioButtonNormal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonNormal.setText("Normal");

        buttonGroup.add(radioButtonHard);
        radioButtonHard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioButtonHard.setText("Hard");

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
        labelLevel.setText("Mode");

        labelBoardSize.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelBoardSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBoardSize.setText("Board Size");

        sliderLevel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderLevelStateChanged(evt);
            }
        });

        labelDifficulty.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDifficulty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDifficulty.setText("Difficulty");

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

        tabbedPanel.addTab("Settings", panelSettings);

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

        tabbedPanel.addTab("Play", panelGame);

        buttonClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        buttonStartGame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonStartGame.setText("Start");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /**
     * Prevents modification of custom settings.
     *
     * @param visible True to editable, false otherwise.
     */
    private void setCustomSettingsVisibility(boolean visible) {
        labelDifficulty.setEnabled(visible);
        labelBoardSize.setEnabled(visible);
        labelSettedLevel.setEnabled(visible);
        sliderLevel.setEnabled(visible);
        textFieldLengthX.setEnabled(visible);
        textFieldLengthY.setEnabled(visible);
    }

    /**
     * Start the configuration components.
     */
    private void initSettings() {
        setCustomSettingsVisibility(false);
        sliderLevel.setMaximum(100);
        sliderLevel.setMinimum(40);
        sliderLevel.setValue(60);
        buttonGroup.setSelected(radioButtonNormal.getModel(), true);
    }

    /**
     * Defines configuration values ​​for each selected level.
     */
    private void setGameSettings() {
        ButtonModel selectedButton = buttonGroup.getSelection();

        if (selectedButton == radioButtonEasy.getModel()) {
            width = 10;
            height = 10;
            level = 52;
        } else if (selectedButton == radioButtonNormal.getModel()) {
            width = 16;
            height = 16;
            level = 71;
        } else if (selectedButton == radioButtonHard.getModel()) {
            width = 21;
            height = 21;
            level = 95;
        } else {
            setCustomSettings();
        }
    }

    /**
     * Defines configuration values ​​for custom level.
     */
    private void setCustomSettings() {
        String textFXValue = textFieldLengthX.getText();
        String textFYValue = textFieldLengthY.getText();

        if (textFXValue.equals("")) {
            width = defaultSize;
        } else {
            width = Integer.max(Integer.min(Integer.parseInt(textFXValue), 21), 10);
            textFieldLengthX.setText(Integer.toString(width));
        }

        if (textFYValue.equals("")) {
            height = defaultSize;
        } else {
            height = Integer.max(Integer.min(Integer.parseInt(textFXValue), 21), 10);
            textFieldLengthY.setText(Integer.toString(height));
        }

        level = sliderLevel.getValue();
    }

    /**
     * Apply the methods for creating the board.
     */
    private void createBoard() {

        emptyBoard();
        game = new Board(width, height, level);

        setGamePanelSize();
        initCellsBoard(panelGame, Color.decode("#353535"));

        panelGame.revalidate();
        panelGame.repaint();
    }

    /**
     * Clears components and attributes from the previous game.
     */
    private void emptyBoard() {
        for (Component c : panelGame.getComponents()) {
            if (addedCells.contains(c)) {
                panelGame.remove(c);
            }
        }
        addedCells.clear();
        game = null;
    }

    /**
     * Create the buttons for each cell on the board.
     *
     * @param panel Panel where the buttons will be inserted.
     * @param bgColor Initial color of the buttons.
     */
    private void initCellsBoard(JPanel panel, Color bgColor) {
        cellsBoard = new JButton[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                JButton cell = new JButton();
                cellsBoard[i][j] = cell;
                Font font = new Font("Segoe UI Symbol", Font.PLAIN, 10);
                Point position = new Point(i, j);

                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            cellActionLeftClicked(position);
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            cellActionRightClicked(position);
                        }
                        updateGamePanel();
                    }
                });

                addedCells.addAll(Arrays.asList(cell));
                cell.setBounds((cellSize * (i + 1)), (cellSize * (j + 1)), cellSize, cellSize);
                cell.setBackground(bgColor);
                cell.setFont(font);
                panel.add(cell);
            }
        }
    }

    private void cellActionLeftClicked(Point position) {
        game.openCell(position);
    }

    private void cellActionRightClicked(Point position) {
        game.flagCell(position);
    }

    /**
     * Updates components on every user click.
     */
    private void updateGamePanel() {
        updateButtonCells();
        updateFlagCount();
        checkGameState();
        this.requestFocusInWindow();
    }

    /**
     * Updates the attributes of every button in the game.
     */
    private void updateButtonCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cellData = game.getBoard()[i][j];
                JButton cellButton = cellsBoard[i][j];

                if (cellData.isFlagged()) {
                    cellButton.setForeground(Color.decode("#B01D06"));
                    cellButton.setText(Character.toString(State.flagged.getChar()));
                }
                if (cellData.isOpened()) {
                    int adjacentMinesCount = cellData.getAdjacentMinesCount();
                    MineAdjacentColor color = MineAdjacentColor.getColorFromMines(adjacentMinesCount);

                    cellButton.setBackground(Color.decode("#CFCFCF"));
                    cellButton.setForeground(Color.decode(color.getHexCode()));
                    cellButton.setText(Integer.toString(adjacentMinesCount));
                }
                if (cellData.isClosed()) {
                    cellButton.setForeground(Color.BLACK);
                    cellButton.setText("");
                }
            }
        }
    }

    /**
     * Update flag count.
     */
    private void updateFlagCount() {
        StringBuilder str = new StringBuilder();

        str.append("<html>\n");
        str.append("    <font color = '#B01D06'>\n");
        str.append(Cell.State.flagged.getChar());
        str.append("</font>");
        str.append(" ");
        str.append(Integer.toString(game.getFlagsCount()));

        labelFlags.setText(str.toString());
    }

    /**
     * Reveals the mines on the board.
     *
     * @param lost True for lost game.
     */
    private void revealMines(boolean lost) {
        var mines = game.getSettedMines();

        mines.forEach((var mine) -> {
            JButton cellButton = cellsBoard[mine.x][mine.y];

            if (lost) {
                cellButton.setBackground(Color.decode("#b01d06"));
            } else {
                cellButton.setBackground(Color.decode("#05B062"));
            }

            cellButton.setForeground(Color.BLACK);
            cellButton.setText("\u25ce");
        });
    }

    /**
     * Checks whether the game was won or lost.
     */
    private void checkGameState() {
        if (game.isLost()) {
            labelFlags.setText("Game Over! You lost.");
            revealMines(true);
            this.setSize(600, 600);
            panelGame.setSize(10, 10);
        }
        if (game.isWon()) {
            labelFlags.setText("Congratulations, you won.");
            revealMines(false);
            this.setSize(600, 600);
            panelGame.setSize(10, 10);
        }
    }

    private void setSettingPanelSize() {
        this.setSize(600, 600);
    }

    private void setGamePanelSize() {
        if (game != null) {
            this.setSize(Integer.max((width * cellSize) + 70, 267), 600);
            panelGame.setSize(10, 10);
            checkGameState();
        }
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
