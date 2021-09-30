package org.wcscda.worms.board;

import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Score extends AbstractDrawableElement {
    private Player[] players;
    private Map<String, Integer[]> dies;

    public Map<String, Integer[]> getDies() {
        return dies;
    }

    public void setDies(Map<String, Integer[]> dies) {
        this.dies = dies;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        int x = 20;
        int y = 20;
        int line = 20;
        for (Player player : players) {
            g.setColor(Color.GREEN);
            g.drawString(player.getName() + " :", (int) x, (int) y );
            for (Worm worm : player.getWorms()) {
                g.setColor(Color.GREEN);
                g.drawString(worm.getName(), (int) x, (int) y + line );
                if (worm.getLife() <= 20) {
                    g.setColor(Color.ORANGE);
                }
                g.drawString("HP/" + worm.getLife(), (int) x + 70, (int) y + line );
                line += 20;
            }
            x += 150;
            line = 20;
        }
    }
}
