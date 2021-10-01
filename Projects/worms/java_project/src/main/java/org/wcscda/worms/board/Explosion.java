package org.wcscda.worms.board;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import org.wcscda.worms.DrawHelper;
import org.wcscda.worms.Helper;

import javax.swing.*;

public class Explosion extends AbstractDrawableElement {
  private static final int LIFE_DURATION = 40;
  private final double centerX;
  private final double centerY;
  private final double radius;
  private final int createdPhase;
  private static final String[] imagePath = {
          "src/resources/explosion/explosion-1.png",
          "src/resources/explosion/explosion-2.png",
          "src/resources/explosion/explosion-3.png",
          "src/resources/explosion/explosion-4.png",
          "src/resources/explosion/explosion-5.png",
          "src/resources/explosion/explosion-6.png",
          "src/resources/explosion/explosion-7.png",
          "src/resources/explosion/explosion-8.png",
          "src/resources/explosion/explosion-9.png",
          "src/resources/explosion/explosion-10.png",
          "src/resources/explosion/explosion-11.png",
          "src/resources/explosion/explosion-12.png" };
  private static final Image[] image = new Image[11];
  private static void initImages() {
    for (int i = 0; i < imagePath.length; i++) {
      image[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(50, 30, 0);
    }
  }

  public Explosion(double centerX, double centerY, int explosionRadius) {
    super(true);
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = explosionRadius;
    this.createdPhase = Helper.getClock();
  }

  private int getLifeTime() {
    return Helper.getClock() - createdPhase;
  }

  @Override
  protected void drawMain(Graphics2D g, ImageObserver io) {
    if (image == null) {
      initImages();
    }
    /*Shape explosion =

        DrawHelper.getCircle(
            centerX, centerY, (int) (radius * (0.1 + getLifeTime() * 0.9 / LIFE_DURATION)));*/
    AffineTransform trans =
            AffineTransform.getTranslateInstance(centerX, centerY);
    //trans.scale(-1, 1);
    assert image != null;
    for (Image explosion : image) {
      g.drawImage(explosion, trans, io);
    }

    g.setColor(Color.RED);
    //g.fill(explosion);

    if (getLifeTime() == LIFE_DURATION) {
      removeSelf();
    }
  }
}

