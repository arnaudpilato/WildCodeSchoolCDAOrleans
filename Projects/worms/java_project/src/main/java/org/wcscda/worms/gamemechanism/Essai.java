package org.wcscda.worms.gamemechanism;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.AbstractDrawableElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class Essai extends AbstractDrawableElement {
    private static final String imagePath = "src/resources/start.jpeg";
    private static Image image = null;

    private static void initImages() {
        image = new ImageIcon(imagePath).getImage().getScaledInstance(1200, 800, 0);
    }

    public Essai() {
        JButton start = new JButton("Essai");
        JPanel pnlButton = new JPanel();
        Helper.getPC().setLayout(null);
        pnlButton.setLayout(null);
        start.setFont(new Font("Arial", Font.BOLD, 30));
        start.setSize(300,50);
        start.setLocation(700,600);

        pnlButton.add(start);
        Helper.getPC().add(start);
        pnlButton.setLocation(0,0);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                menu();
            }
        });
    }

    public void menu() {
        JButton newGame  = new JButton("New Game");
        newGame.setFont(new Font("Arial", Font.BOLD, 30));
        Helper.getPC().add(newGame);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World");
            }
        });

        JButton options = new JButton("Options");
        options.setFont(new Font("Arial", Font.BOLD, 30));
        Helper.getPC().add(options);

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World");
            }
        });

    }


    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        if (image == null) {
            initImages();
        }

        g.drawImage(image, 0,0, io);

    }
}
