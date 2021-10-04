package org.wcscda.worms.board.weapons;

import java.awt.*;
import java.awt.image.ImageObserver;
import org.wcscda.worms.Helper;

import javax.swing.*;

public class HadokenAmmo extends AbstractAmmo {
  private static final int HADOKEN_AMMO_RADIUS = 15;
  private static final int HADOKEN_RECT_SIZE = 30;
  private static final int EXPLOSION_RADIUS = 30;
  private static final int EXPLOSION_DAMAGE = 30;
  private static final int INITIAL_SPEED = 5;
  private static final String[] imagePath = {
          "src/resources/hadoken/hadoken-1.png",
          "src/resources/hadoken/hadoken-2.png",
          "src/resources/hadoken/hadoken-3.png",
          "src/resources/hadoken/hadoken-4.png",
  };

  private static final Image[] hadoken = new Image[4];

  private final double initialX;
  private final double initialY;

  private static void initImages() {
    for (int i = 0; i < imagePath.length; i++) {
      hadoken[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(56, 43, 0);
    }
  }

  public HadokenAmmo(Double angle) {
    super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
    createMovableRect(HADOKEN_RECT_SIZE, HADOKEN_RECT_SIZE);
    getMovable().setDirection(angle);
    getMovable().setSpeed(INITIAL_SPEED);

    initialX = Helper.getWormX();
    initialY = Helper.getWormY();
  }

  @Override
  public void drawMain(Graphics2D g, ImageObserver io) {
    if (hadoken[0] == null) {
      initImages();
    }
    /*g.setColor(Color.BLUE);
    g.setStroke(new BasicStroke(10));
    g.drawLine(
        (int) initialX,
        (int) initialY,
        (int) getMovable().getCenterX(),
        (int) getMovable().getCenterY());
        */

    g.drawImage(hadoken[Helper.getClock() % hadoken.length], (int) getMovable().getCenterX() - 40, (int) getMovable().getCenterY() - 22, io);

  }
}
