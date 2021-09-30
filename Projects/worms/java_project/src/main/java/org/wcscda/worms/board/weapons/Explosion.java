package org.wcscda.worms.board.weapons;

import org.wcscda.worms.board.AbstractDrawableElement;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Explosion extends AbstractDrawableElement {
    public Explosion(double centerX, double centerY, int explosionRadius) {

    }
    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {

        g.drawString("HP/" , (int)  70, (int)  30 );
        removeSelf();
    }
}
