package org.wcscda.worms.gamemechanism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;

import org.wcscda.worms.Config;
import org.wcscda.worms.Helper;
import org.wcscda.worms.Player;
import org.wcscda.worms.Worm;
import org.wcscda.worms.board.AmmunitionBox;
import org.wcscda.worms.board.Score;
import org.wcscda.worms.board.Winner;
import org.wcscda.worms.gamemechanism.phases.AbstractPhase;
import org.wcscda.worms.gamemechanism.phases.EndOfGamePhase;
import org.wcscda.worms.gamemechanism.phases.WormMovingPhase;

public class TimeController implements ActionListener {
    private static TimeController instance;
    private PhysicalController board;
    private Timer timer;
    private ArrayList<Player> players = new ArrayList<Player>();
    private int activePlayerIndex = 0;
    private AbstractPhase currentPhase;
    private int phaseCount = 0;
    private boolean delayedSetNextWorm;
    private Random rand = new Random();
    private int randX = rand.nextInt(1150);
//    private int randY = rand.nextInt(300);

    public TimeController() {
        instance = this;
        initGame();

        board.addKeyListener(new KeyboardController());

        timer = new Timer(Config.getClockDelay(), this);
        timer.start();
    }

    private void initGame() {
        board = new PhysicalController();
        Map<String, String[]> teams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre de joueurs :");
        int numberOfTeams = scanner.nextInt();
        // Player[] players = new Player[numberOfTeams];
        System.out.println("Saisissez le nombre de Worms :");
        int numberOfWorms = scanner.nextInt();
        //Worm[] worms = new Worm[numberOfWorms];
        for (int i = 0; i < numberOfTeams; i++) {
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
            for (int i = 0; i < worms.length; i++) {
                wormsName[j][i] = playerName[j].createWorm(worms[i]);
                board.wormInitialPlacement(wormsName[j][i]);
            }
            j++;
        }
        doSetNextWorm();
        Score score = new Score();
        score.setPlayers(playerName);
        AmmunitionBox ammunition = new AmmunitionBox(randX,10, 80 ,55);

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
