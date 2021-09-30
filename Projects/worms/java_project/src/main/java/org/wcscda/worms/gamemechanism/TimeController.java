package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import org.wcscda.worms.Config;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.Score;
import org.wcscda.worms.gamemechanism.phases.AbstractPhase;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;

public class TimeController implements ActionListener {
    private static TimeController instance;
    private PhysicalController board;
    private Timer timer;
    private ArrayList<Player> players = new ArrayList<Player>();
    private int activePlayerIndex = 0;
    private AbstractPhase currentPhase;
    private int phaseCount = 0;

    public TimeController() {
        instance = this;
        initGame();

        board.addKeyListener(new KeyboardController());

        timer = new Timer(Config.getClockDelay(), this);
        timer.start();
    }

    private void initGame() {
        board = new PhysicalController();
        // Lucky luke because for the moment he is a poor lonesome
        // player

        Map<String, String[]> teams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre de joueurs :");
        int numberOfTeams = scanner.nextInt();
        // Player[] players = new Player[numberOfTeams];
        System.out.println("Saisissez le nombre de Worms :");
        int numberOfWorms = scanner.nextInt();
        //Worm[] worms = new Worm[numberOfWorms];
        for (int i= 0; i < numberOfTeams; i ++) {
            System.out.println("Choisissez le nom de la team du joueur " + (i + 1) + " :");
            String playerName = scanner.next();
            // players[i] = createPlayer(playerName, Color.BLUE);
            teams.put(playerName, new String[numberOfWorms]);
            for (int j = 0; j < numberOfWorms; j++) {
                System.out.println("Nom du joueur " + (j + 1) + " : ");
                teams.get(playerName)[j] = scanner.next();
                // worms[j] = players[i].createWorm(playerName);
            }
        }

        Random random = new Random();

        int j = 0;
        Player[] playerName = new Player[numberOfTeams];
        Worm[][] wormsName = new Worm[numberOfTeams][numberOfWorms];

        for (Map.Entry<String, String[]> entry : teams.entrySet()) {
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();

            Color randomColor = new Color(r, g, b);

            String player = entry.getKey();
            String[] worms = entry.getValue();

            playerName[j] = createPlayer(player, randomColor);
            for (int i=0; i < worms.length; i++) {
                wormsName[j][i] = playerName[j].createWorm(worms[i]);
                board.wormInitialPlacement(wormsName[j][i]);
            }
            j++;
        }

        setNextWorm();

        Score score = new Score();
        score.setPlayers(playerName);
    }

    public void setNextWorm() {
        activePlayerIndex += 1;
        activePlayerIndex %= players.size();
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
        boolean inGame = board.actionPerformed(e);

        if (!inGame) {
            timer.stop();
        }
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
