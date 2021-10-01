package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.IMovableVisitor;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GrenadeAmmo extends AbstractAmmo {
    private static final int EXPLOSION_RADIUS = 30;
    private static final int EXPLOSION_DAMAGE = 15;
    private static final int GRENADE_RECT_SIZE = 10;
    private static final int MAX_DISTANCE = 10;

    private final double initialX;
    private final double initialY;
    private final double endX;
    private final double endY;

    public GrenadeAmmo(Double angle) {
        super(GRENADE_RECT_SIZE, GRENADE_RECT_SIZE, EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
        setDirection(angle);

        setSpeed(5);

        initialX = Helper.getWormX();
        initialY = Helper.getWormY();
        endX = initialX + 40 * Math.sin(angle);
        endY = initialY + 40 * Math.cos(angle);





//        initialX+=dis/getSpeedX(); //Distance divided by speed
////        mPositionY=(float) (0.5* Math.sin(Math.PI*(Math.abs(mPositionX-mOriginalX))/mDistanceX);
    }

    @Override
    public void move(IMovableVisitor visitor) {
        super.move(visitor);
        double distance = Math.sqrt(Math.pow(initialX - getCenterX(), 2) + Math.pow(initialY - getCenterY(), 2));
    }

    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        // TODO Auto-generated method stub

    }
}
