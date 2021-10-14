package wcscda.quest.C_ultron_army;

import wcscda.quest.Sentinel;

import java.util.Collection;

public class ArmyCollection implements UltronArmy {
    private final Collection<Sentinel> collection;

    public ArmyCollection(Collection<Sentinel> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(Sentinel sentinel) {
        if (sentinel != null) {
            collection.add(sentinel);

            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Sentinel[] getPatrol(int patrolSize) {
       Sentinel[] sentinels = new Sentinel[patrolSize];

        int i = 0;
        for (Sentinel sentinel : collection) {
            if (i < patrolSize) {
                sentinels[i] = sentinel;
                i++;
            }
        }

        for (Sentinel sentinel : sentinels) {
            collection.remove(sentinel);
        }

        return sentinels;
    }

    @Override
    public void patrolReturn(Sentinel[] sentinels) {
        for (Sentinel sentinel : sentinels) {
            this.collection.add(sentinel);
        }
    }

    @Override
    public boolean contains(Sentinel sentinel) {
        return collection.contains(sentinel);
    }
}
