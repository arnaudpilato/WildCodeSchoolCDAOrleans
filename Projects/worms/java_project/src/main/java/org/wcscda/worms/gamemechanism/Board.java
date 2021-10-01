package org.wcscda.worms.gamemechanism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.*;
import org.wcscda.worms.gamemechanism.events.EndOfTurnEvent;
import org.wcscda.worms.gamemechanism.phases.EndOfGamePhase;

public abstract class Board extends JPanel {

    /* NRO 2021-09-30 : Asked by JPanel */
    private static final long serialVersionUID = 1L;

    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 800;

    private WormField wormField;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.BLACK);
        setFocusable(true);

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        wormField = new WormField(BOARD_WIDTH, BOARD_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing((Graphics2D) g);
    }

    private void doDrawing(Graphics2D g) {
        for (AbstractDrawableElement drawable : AbstractDrawableElement.getAllDrawable()) {
            drawable.draw(g, this);
        }
        int nbLooser = 0;
        for (int i = 0; i < Helper.getTC().getPlayers().size(); i++) {
            if ((Helper.getActivePlayer().getWorms().size() > 0) && (Helper.getTC().getPlayers().get(i).getWorms().size() < 1)) {
                nbLooser++;
                if (nbLooser == Helper.getTC().getPlayers().size() - 1) {
                    String fontName = "Microsoft YaHei";
                    g.drawString(" l'équipe " + Helper.getActivePlayer().getName() + " à gagné la partie ", 500, 100);
                }
            }
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void actionPerformed(ActionEvent e) {
        if (isGameFinished()) {
            Helper.getTC().setCurrentPhase(new EndOfGamePhase());
        }
        repaint();
        doMoves();

        AbstractDrawableElement.processToBeRemovedAndAdded();
        Helper.getTC().delayedActions();

        new EndOfTurnEvent(Helper.getClock());
    }

    /* NRO : TODO-Student : choose when to decide the game is finished
     */
    private boolean isGameFinished() {
        return false;
    }

    protected abstract void doMoves();

    public static int getBWIDTH() {
        return BOARD_WIDTH;
    }

    public static int getBHEIGHT() {
        return BOARD_HEIGHT;
    }

    public WormField getWormField() {
        return wormField;
    }
}