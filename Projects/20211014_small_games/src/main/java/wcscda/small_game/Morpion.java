package wcscda.small_game;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Morpion extends Drawable implements SmallGameInterface {
    private int positionTopX1 = 390;
    private int positionDownX1 = 390;
    private int positionTopY1 = 390;
    private int positionDownY1 = 390;
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        drawGrid(g, io);

        g.setFont(new Font("Roboto", Font.BOLD, 50));
        g.drawString("Morpion", 50, 50);
    }

    private void drawGrid(Graphics2D g, ImageObserver io) {
        g.setColor(Color.green);
        g.setStroke(new BasicStroke(5));
        int distance = 0;
        for (int i = 0; i < 2; i++) {
            g.drawLine(390, 330 + distance, 810, 330 + distance);
            g.drawLine(530 + distance, 190, 530 + distance, 610);
            distance += 140;
        }
    }
}
