package org.wcscda.worms.board.weapons;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GrenadeAmmo extends AbstractAmmo {
    private static final int EXPLOSION_RADIUS = 30;
    private static final int EXPLOSION_DAMAGE = 15;
    private static final int GRENADE_RECT_SIZE = 10;

    public GrenadeAmmo(Double angle) {
        super(GRENADE_RECT_SIZE, GRENADE_RECT_SIZE, EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
        setDirection(angle);
        setSpeed(5);
    }



    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        // TODO Auto-generated method stub

    }
}
