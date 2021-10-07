package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Timer;

import org.wcscda.worms.Config;
import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.Score;
import org.wcscda.worms.board.Winner;
import org.wcscda.worms.gamemechanism.phases.AbstractPhase;
import org.wcscda.worms.gamemechanism.phases.EndOfGamePhase;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerPlayer;
import org.wcscda.worms.gamemechanism.playerrecorder.KeyboardControllerRecorder;

public class TimeController implements ActionListener {
    private final KeyboardController keyboardController;
    private static TimeController instance;
    private PhysicalController board;
    private Timer timer;
    private ArrayList<Player> players = new ArrayList<Player>();
    private int activePlayerIndex = 0;
    private AbstractPhase currentPhase;
    private int phaseCount = 0;
    private boolean delayedSetNextWorm;
    private boolean start = false;

    public TimeController() {
        instance = this;
        board = new PhysicalController();
        keyboardController = createController();
        board.addKeyListener(keyboardController);
        initGame();
    }

    /* package */ void postInitGame() {


        timer = new Timer(Config.getClockDelay(), this);
        timer.start();
    }

    private KeyboardController createController() {
        if (Config.getRecordGame()) {
            return new KeyboardControllerRecorder(this.board);
        } else if (Config.getPlayRecord()) {
            return new KeyboardControllerPlayer();
        } else {
            return new KeyboardController();
        }
    }

    private void initGame() {











        StartGame initialize = new StartGame(this);

//
//        Map<String, String[]> teams = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Saisissez le nombre de joueurs :");
//        int numberOfTeams = scanner.nextInt();
//        // Player[] players = new Player[numberOfTeams];
//        System.out.println("Saisissez le nombre de Worms :");
//        int numberOfWorms = scanner.nextInt();
//        //Worm[] worms = new Worm[numberOfWorms];
//        for (int i = 0; i < numberOfTeams; i++) {
//            System.out.println("Choisissez le nom de la team du joueur " + (i + 1) + " :");
//            String playerName = scanner.next();
//            // players[i] = createPlayer(playerName, Color.BLUE);
//            teams.put(playerName, new String[numberOfWorms]);
//            for (int j = 0; j < numberOfWorms; j++) {
//                System.out.println("Nom du joueur " + (j + 1) + " : ");
//                teams.get(playerName)[j] = scanner.next();
//                // worms[j] = players[i].createWorm(playerName);
//            }
//        }
//
//        Random random = new Random();
//
//        int j = 0;
//        Player[] playerName = new Player[numberOfTeams];
//        Worm[][] wormsName = new Worm[numberOfTeams][numberOfWorms];
//
//        for (Map.Entry<String, String[]> entry : teams.entrySet()) {
//            float r = random.nextFloat();
//            float g = random.nextFloat();
//            float b = random.nextFloat();
//
//            Color randomColor = new Color(r, g, b);
//
//            String player = entry.getKey();
//            String[] worms = entry.getValue();
//
//            playerName[j] = createPlayer(player, randomColor);
//            for (int i = 0; i < worms.length; i++) {
//                wormsName[j][i] = playerName[j].createWorm(worms[i]);
//                board.wormInitialPlacement(wormsName[j][i]);
//            }
//            j++;
//        }













            Random random = new Random();
            Player[] playerName = new Player[initialize.getNumberOfTeams()];
            Worm[][] wormsName = new Worm[initialize.getNumberOfTeams()][initialize.getNumberOfWorms()];

            for (int i = 0; i < playerName.length; i++) {
                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();

                Color randomColor = new Color(r, g, b);

                playerName[i] = createPlayer(initialize.getPlayers()[i], randomColor);
                for (int j = 0; j < wormsName.length; j++) {
                    wormsName[i][j] = playerName[i].createWorm(initialize.getWorms()[i][j]);
                    board.wormInitialPlacement(wormsName[j][i]);
                }




        }

















       doSetNextWorm();
        Score score = new Score();
       score.setPlayers(playerName);

     try {
            new WormSoundPlayer().startSound();
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
       }

       try {
           new WormSoundPlayer().ambientSound();
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
           e.printStackTrace();
       }





    }


  public KeyboardController getKeyboardController() {
    return keyboardController;

    }

    public void setNextWorm() {
        delayedSetNextWorm = true;
    }

    protected void delayedActions() {
        if (delayedSetNextWorm) {
            delayedSetNextWorm = false;
            doSetNextWorm();
        }
    }

    protected void doSetNextWorm() {
        for (int i = 0; i < players.size(); ++i) {
            activePlayerIndex += 1;
            activePlayerIndex %= players.size();
            if (getActivePlayer().hasWorms()) break;
        }

        // No player have any worm, it is sad ...
        if (!getActivePlayer().hasWorms()) {
            return;
        }



        int nbLooser = 0;
        for (int i = 0; i < Helper.getTC().getPlayers().size(); i++) {
            if ((Helper.getActivePlayer().getWorms().size() > 0) && (Helper.getTC().getPlayers().get(i).getWorms().size() < 1)) {
                System.out.println(" l'équipe " + Helper.getTC().getPlayers().get(i).getName() + " à perdu");
                nbLooser++;
                if (nbLooser == players.size() - 1) {
                    System.out.println(" l'équipe " + Helper.getActivePlayer().getName() + " à gagné");
                    Worm.winner = true;
                    new Winner((int) Helper.getWormX(), (int) Helper.getWormY());
                    try {
                        new WormSoundPlayer().winSound();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        getActivePlayer().setNextWorm();
        getActivePlayer().initWeapon();

        AbstractPhase phase = new WormMovingPhase();
        this.setCurrentPhase(phase);
    }

    private Player createPlayer(String name, Color color) {
        Player player = new Player(name, color);
        players.add(player);

        return player;
    }

    public Component getBoard() {
        return board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        phaseCount++;
        board.actionPerformed(e);
    }

    public static TimeController getInstance() {
        if (instance == null) {
            instance = new TimeController();
        }
        return instance;
    }

    public AbstractPhase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(AbstractPhase currentPhase) {
        if ((this.currentPhase != null) && this.currentPhase != currentPhase) {
            this.currentPhase.removeSelf();
        }
        this.currentPhase = currentPhase;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getPhaseCount() {
        return phaseCount;
    }

    public void setPhaseCount(int phaseCount) {
        this.phaseCount = phaseCount;
    }

    public Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }
}
