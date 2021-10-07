package org.wcscda.worms.board.weapons;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.io.IOException;

import org.wcscda.worms.Helper;
import org.wcscda.worms.gamemechanism.WormSoundPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class HadokenAmmo extends AbstractAmmo {
  private static final int HADOKEN_AMMO_RADIUS = 15;
  private static final int HADOKEN_RECT_SIZE = 30;
  private static final int EXPLOSION_RADIUS = 30;
  private static final int EXPLOSION_DAMAGE = 15;
  private static final int INITIAL_SPEED = 6;
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

    try {
      new WormSoundPlayer().hadokenSound();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
      e.printStackTrace();
    }

    setInitialPosition();
  }

  @Override
  public void drawMain(Graphics2D g, ImageObserver io) {
    if (hadoken[0] == null) {
      initImages();
    }

    if (Helper.getActiveWorm().getDirection() > Math.PI / 2) {
      AffineTransform trans =
              AffineTransform.getTranslateInstance(getMovable().getX() + 55, getMovable().getY() - 8);
      trans.scale(-1, 1);

      g.drawImage(hadoken[Helper.getClock() % hadoken.length], trans, io);

    } else {
      g.drawImage(hadoken[Helper.getClock() % hadoken.length], (int) getMovable().getCenterX() - 40, (int) getMovable().getCenterY() - 22, io);
    }
  }

}
