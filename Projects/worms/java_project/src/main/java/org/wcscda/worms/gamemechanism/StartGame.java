package org.wcscda.worms.gamemechanism;

import org.wcscda.worms.Helper;
import org.wcscda.worms.board.AbstractDrawableElement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StartGame extends AbstractDrawableElement {
    private boolean teamAndWormsMenu = false;
    private boolean nameOfWormsMenu = false;

    private TimeController initialize = new TimeController();

    private int numberOfTeams = 1;
    private int numberOfWorms = 1;

    private final String[] players = new String[numberOfTeams];

    private final String[][] worms = new String[numberOfTeams][numberOfWorms + 1];

    private final Icon iconValidate = new ImageIcon("src/resources/validate.png");

    private static final String imagePath1 = "src/resources/start.jpeg";
    private static final String imagePath2 = "src/resources/background.png";
    private static final String imagePath3 = "src/resources/number-of-players.png";
    private static final String imagePath4 = "src/resources/number-of-worms.png";
    private static final String[] imagePath5 = {
            "src/resources/name-of-player-1.png",
            "src/resources/name-of-player-2.png",
            "src/resources/name-of-player-3.png",
            "src/resources/name-of-player-4.png",
    };

    private static final String[] imagePath6 = {
            "src/resources/numbers/1.png",
            "src/resources/numbers/2.png",
            "src/resources/numbers/3.png",
            "src/resources/numbers/4.png",
            "src/resources/numbers/5.png",
    };

    private static Image image = null;
    private static Image imageBackground = null;
    private static Image imageNumberOfPlayers = null;
    private static Image imageNumberOfWorms = null;
    private static Image[] nameOfPlayer = new Image[4];
    private static Image[] numbers = new Image[5];

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfWorms() {
        return numberOfWorms;
    }

    public String[] getPlayers() {
        return players;
    }

    public String[][] getWorms() {
        return worms;
    }

    private static void initImages() {
        image = new ImageIcon(imagePath1).getImage().getScaledInstance(1200, 800, 0);
        imageBackground = new ImageIcon(imagePath2).getImage().getScaledInstance(800, 500, 0);
        imageNumberOfPlayers = new ImageIcon(imagePath3).getImage().getScaledInstance(423, 35, 0);
        imageNumberOfWorms = new ImageIcon(imagePath4).getImage().getScaledInstance(381, 35, 0);

        for (int i = 0; i < imagePath5.length; i++) {
            nameOfPlayer[i] = new ImageIcon(imagePath5[i]).getImage().getScaledInstance(344, 36, 0);
        }

        for (int i = 0; i < imagePath6.length; i++) {
            numbers[i] = new ImageIcon(imagePath6[i]).getImage().getScaledInstance(40, 37, 0);
        }
    }

    public StartGame() {
        JButton start = new JButton("Start Game");
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
        JPanel pnlButton = new JPanel();
        Helper.getPC().setLayout(null);
        pnlButton.setLayout(null);
        pnlButton.setLocation(0,0);

        JButton newGame = new JButton("New Game");
        newGame.setFont(new Font("Arial", Font.BOLD, 30));
        newGame.setSize(300,50);
        newGame.setLocation(700,600);
        pnlButton.add(newGame);
        Helper.getPC().add(newGame);

        JButton options = new JButton("Options");
        options.setFont(new Font("Arial", Font.BOLD, 30));
        options.setSize(300,50);
        options.setLocation(700,650);
        pnlButton.add(options);
        Helper.getPC().add(options);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamAndWormsMenu = true;
                newGame.setVisible(false);
                options.setVisible(false);
                newGame();
            }
        });

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options.setVisible(false);
                System.out.println("Hello World");
            }
        });

    }

    public void newGame() {
        JPanel pnlButton = new JPanel();
        Helper.getPC().setLayout(null);
        pnlButton.setLayout(null);
        pnlButton.setLocation(0,0);

        // Boutton ajouter des joueurs
        Icon iconUp = new ImageIcon("src/resources/add.png");
        JButton addPlayer = new JButton(iconUp);
        addPlayer.setSize(40,40);
        addPlayer.setLocation(650,320);
        addPlayer.setBorderPainted(false);
        pnlButton.add(addPlayer);
        Helper.getPC().add(addPlayer);

        // Boutton retirer des joueurs
        Icon iconDown = new ImageIcon("src/resources/less.png");
        JButton lessPlayer = new JButton(iconDown);
        lessPlayer.setSize(40,40);
        lessPlayer.setLocation(475,320);
        lessPlayer.setBorderPainted(false);
        pnlButton.add(lessPlayer);
        Helper.getPC().add(lessPlayer);

        // Boutton ajouter des worms
        JButton addWorm = new JButton(iconUp);
        addWorm.setSize(40,40);
        addWorm.setLocation(650,500);
        addWorm.setBorderPainted(false);
        pnlButton.add(addWorm);
        Helper.getPC().add(addWorm);

        // Boutton retirer des worms
        JButton lessWorm = new JButton(iconDown);
        lessWorm.setSize(40,40);
        lessWorm.setLocation(475,500);
        lessWorm.setBorderPainted(false);
        pnlButton.add(lessWorm);
        Helper.getPC().add(lessWorm);

        // Boutton de validation
        JButton validate = new JButton(iconValidate);
        validate.setSize(171,34);
        validate.setLocation(500,600);
        validate.setBorderPainted(false);
        pnlButton.add(validate);
        Helper.getPC().add(validate);

        // Bouton ajout player
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfTeams < 3) {
                    numberOfTeams += 1;
                }
            }
        });

        // Bouton retrait player
        lessPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfTeams > 1) {
                    numberOfTeams -= 1;
                }
            }
        });

        // Bouton Ajout worm
        addWorm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfWorms < 5) {
                    numberOfWorms += 1;
                }
            }
        });

        // Bouton retrait worm
        lessWorm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfWorms > 1) {
                    numberOfWorms -= 1;
                }
            }
        });

        // Bouton validation
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamAndWormsMenu = false;
                nameOfWormsMenu = true;
                addPlayer.setVisible(false);
                lessPlayer.setVisible(false);
                addWorm.setVisible(false);
                lessWorm.setVisible(false);
                validate.setVisible(false);
                nameTeam1();
            }
        });
    }

    public void nameTeam1() {
        JPanel pnlButton = new JPanel();
        Helper.getPC().setLayout(null);
        pnlButton.setLayout(null);
        pnlButton.setLocation(0,0);

        // Boutton de validation
        JButton validate = new JButton(iconValidate);
        validate.setSize(171,34);
        validate.setLocation(500,600);
        validate.setBorderPainted(false);
        pnlButton.add(validate);
        Helper.getPC().add(validate);

        JTextArea setNameOfPlayer1 = new JTextArea("BROCOLI");
        setNameOfPlayer1.setSize(300, 40);
        setNameOfPlayer1.setFont(new Font("Roboto", Font.BOLD, 20));
        setNameOfPlayer1.setForeground(Color.GREEN);
        setNameOfPlayer1.setLocation(50, 300);
        setNameOfPlayer1.setMargin(new Insets(0, 10, 0, 0));
        Helper.getPC().add(setNameOfPlayer1);
        players[0] = setNameOfPlayer1.getText();


        JTextArea nameOfWorm1 = new JTextArea("Michel");
        nameOfWorm1.setSize(300, 40);
        nameOfWorm1.setLocation(500, 300);
        worms[0][0] = nameOfWorm1.getText();
        Helper.getPC().add(nameOfWorm1);

        if (numberOfWorms == 2) {
            JTextArea nameOfWorm2 = new JTextArea("Roger");
            nameOfWorm2.setSize(200, 40);
            nameOfWorm2.setLocation(500, 350);
            worms[0][1] = nameOfWorm2.getText();
            Helper.getPC().add(nameOfWorm2);
        }

        if (numberOfWorms == 3) {
            JTextArea nameOfWorm3 = new JTextArea("Denis");
            nameOfWorm3.setSize(200, 40);
            nameOfWorm3.setLocation(500, 400);
            //worms[0][2] = nameOfWorm3.getText();
            Helper.getPC().add(nameOfWorm3);
        }

        if (numberOfWorms == 4) {
            JTextArea nameOfWorm4 = new JTextArea("Bernard");
            nameOfWorm4.setSize(200, 40);
            nameOfWorm4.setLocation(500, 450);
            //worms[0][3] = nameOfWorm4.getText();
            Helper.getPC().add(nameOfWorm4);
        }

        if (numberOfWorms == 5) {
            JTextArea nameOfWorm5 = new JTextArea("Alice");
            nameOfWorm5.setSize(200, 40);
            nameOfWorm5.setLocation(500, 500);
            //worms[0][4] = nameOfWorm5.getText();
            Helper.getPC().add(nameOfWorm5);
        }




        /*for (int i = 0; i < numberOfWorms; i++) {
            //JTextArea a = new JTextArea();
            essai1[i].setSize(300, 40);
            essai1[i].setLocation(300, 50 + essai);
            essai1[i].getText();
            Helper.getPC().add(essai1[i]);
            essai += 100;
        }*/

        // Bouton validation
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(players[0]);
                /*for (JTextArea essai : essai1) {
                    System.out.println(essai.getText());
                }*/
            }
        });
    }


    @Override
    protected void drawMain(Graphics2D g, ImageObserver io) {
        if (image == null) {
            initImages();
        }

        g.drawImage(image, 0,0, io);

        if (teamAndWormsMenu) {
            // Image de fond
            //g.drawImage(imageBackground, 200, 200, io);

            // Ajouter des joueurs
            g.drawImage(imageNumberOfPlayers, 380, 250, io);
            g.drawImage(numbers[numberOfTeams - 1], 560, 320, io);

            // Ajouter des worms
            g.drawImage(imageNumberOfWorms, 400, 430, io);
            g.drawImage(numbers[numberOfWorms - 1], 560, 500, io);
        }

        if (nameOfWormsMenu) {
            g.drawImage(nameOfPlayer[0], 420, 250, io);
        }
    }
}
