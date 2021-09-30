package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.AbstractDrawableElement;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Explosion extends AbstractDrawableElement {

    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        if (Helper.getClock() % 20 < 10) {
            g.drawString("Michel", (int) 20, (int) 30);
            removeSelf();
        }

    }
}
