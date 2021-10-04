package org.wcscda.worms.board.weapons;

import org.wcscda.worms.Helper;
import org.wcscda.worms.Worm;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

public class GrenadeAmmo extends AbstractAmmo {
    private static final int EXPLOSION_RADIUS = 80;
    private static final int EXPLOSION_DAMAGE = 15;
    private static final int GRENADE_RECT_SIZE = 10;
    private final double initialX;
    private final double initialY;
    private static final Image[] grenade = new Image[16];
    private static final String[] imagePath = {
            "src/resources/grenade/grenade-1.png",
            "src/resources/grenade/grenade-2.png",
            "src/resources/grenade/grenade-3.png",
            "src/resources/grenade/grenade-4.png",
            "src/resources/grenade/grenade-5.png",
            "src/resources/grenade/grenade-6.png",
            "src/resources/grenade/grenade-7.png",
            "src/resources/grenade/grenade-8.png",
            "src/resources/grenade/grenade-9.png",
            "src/resources/grenade/grenade-10.png",
            "src/resources/grenade/grenade-11.png",
            "src/resources/grenade/grenade-12.png",
            "src/resources/grenade/grenade-13.png",
            "src/resources/grenade/grenade-14.png",
            "src/resources/grenade/grenade-15.png",
            "src/resources/grenade/grenade-16.png",
    };

    private static void initImages() {
        for (int i = 0; i < imagePath.length; i++) {
            grenade[i] = new ImageIcon(imagePath[i]).getImage().getScaledInstance(30, 30, 0);
        }
    }

    public GrenadeAmmo(Double angle) {
        super(EXPLOSION_RADIUS, EXPLOSION_DAMAGE);
        createMovableRect(GRENADE_RECT_SIZE, GRENADE_RECT_SIZE);
        getMovable().setDirection(angle);
        getMovable().setSpeed(5);

        initialX = Helper.getWormX();
        initialY = Helper.getWormY();
    }

    @Override
    public void drawMain(Graphics2D g, ImageObserver io) {
        // TODO Auto-generated method stub
        if (grenade[0] == null) {
            initImages();
        }

        if (Helper.getActiveWorm().getDirection() > Math.PI / 2) {
            g.drawImage(grenade[Helper.getClock() % grenade.length], (int) getMovable().getCenterX(), (int) getMovable().getCenterY() - 18, io);
        } else {
            AffineTransform trans =
                    AffineTransform.getTranslateInstance(getMovable().getX(), getMovable().getY());
            trans.scale(-1, 1);

            g.drawImage(grenade[Helper.getClock() % grenade.length], trans, io);
        }
    }
}
