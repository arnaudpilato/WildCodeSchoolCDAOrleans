package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class ShotgunAmmo extends AbstractAmmo {
  private static final int EXPLOSION_RADIUS = 30;
  private static final int EXPLOSION_DAMAGE = 15;
  private static final int HADOKEN_RECT_SIZE = 10;
  private static final String imagePathBullet = "src/resources/weapons/bullet.png";
  private static final String imagePathShotgun = "src/resources/weapons/Shotgun_small.png";
  private static Image imageBullet = null;
  private static Image imageShotgun = null;

  private static void initImages() {
    imageBullet = new ImageIcon(imagePathBullet).getImage().getScaledInstance(10, 5, 0);
    imageShotgun = new ImageIcon(imagePathShotgun).getImage().getScaledInstance(50, 35, 0);
  }

  public ShotgunAmmo(Double angle) {
    super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
    createMovableRect(HADOKEN_RECT_SIZE, HADOKEN_RECT_SIZE);
    getMovable().setDirection(angle);
    getMovable().setSpeed(10);
  }

  @Override
  public void drawMain(Graphics2D g, ImageObserver io) {
    // TODO Auto-generated method stub
    if (imageBullet == null) {
      initImages();
    }

    if (Helper.getActiveWorm().getDirection() > Math.PI / 2) {
      AffineTransform transShotgun =
              AffineTransform.getTranslateInstance(Helper.getWormX(), Helper.getWormY() - 10);
      transShotgun.scale(-1, 1);

      AffineTransform transBullet =
              AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY() + 5);
      transBullet.scale(-1, 1);

      g.drawImage(imageBullet, transBullet, io);
      g.drawImage(imageShotgun, transShotgun, io);
    } else {
      g.drawImage(imageBullet, (int) getMovable().getX(), (int) getMovable().getY() + 5, io);
      g.drawImage(imageShotgun, (int) Helper.getWormX(), (int) Helper.getWormY() - 10, io);
    }
  }
}
