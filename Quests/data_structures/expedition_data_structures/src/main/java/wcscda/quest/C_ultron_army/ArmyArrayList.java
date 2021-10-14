package wcscda.quest.C_ultron_army;

import wcscda.quest.Sentinel;

import java.util.ArrayList;

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

        return false;
    }

    @Override
    public int size() {
        return sentinelArrayList.size();
    }

    @Override
    public Sentinel[] getPatrol(int patrolSize) {
        for (int i = 0;  i < patrolSize; i++) {
            sentinelArrayList.remove(sentinelArrayList.size() - 1);
            patrolArrayList.add(patrolSize);
        }



        return new Sentinel[patrolSize];
    }

    @Override
    public void patrolReturn(Sentinel[] sentinels) {
        for (Sentinel sentinel : sentinels) {
            this.sentinelArrayList.add(sentinel);
        }
    }

    @Override
    public boolean contains(Sentinel sentinel) {
        return sentinelArrayList.contains(sentinel);
    }
}
