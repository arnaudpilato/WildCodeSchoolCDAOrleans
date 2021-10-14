package wcscda.quest.C_ultron_army;

import wcscda.quest.Sentinel;

import java.util.ArrayList;
<<<<<<< HEAD

public class ArmyArrayList implements UltronArmy {
    private final ArrayList<Sentinel> sentinelArrayList = new ArrayList<>();
    private final ArrayList<Integer> patrolArrayList = new ArrayList<Integer>();
    private int patrol;

    @Override
    public boolean add(Sentinel sentinel) {
        if (sentinel != null) {
            this.sentinelArrayList.add(sentinel);

            return true;
        }

=======
import java.util.Arrays;

public class ArmyArrayList implements UltronArmy {
    private ArrayList<Sentinel> sentinelArrayList = new ArrayList<>();

    @Override
    public boolean add(Sentinel sentinel) {
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
        return false;
    }

    @Override
    public int size() {
<<<<<<< HEAD
        return sentinelArrayList.size();
=======
        return 0;
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public Sentinel[] getPatrol(int patrolSize) {
<<<<<<< HEAD
        for (int i = 0;  i < patrolSize; i++) {
            sentinelArrayList.remove(sentinelArrayList.size() - 1);
            patrolArrayList.add(patrolSize);
        }



        return new Sentinel[patrolSize];
=======
        return new Sentinel[0];
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public void patrolReturn(Sentinel[] sentinels) {
<<<<<<< HEAD
        for (Sentinel sentinel : sentinels) {
            this.sentinelArrayList.add(sentinel);
        }
=======

>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public boolean contains(Sentinel sentinel) {
        return sentinelArrayList.contains(sentinel);
    }
}
