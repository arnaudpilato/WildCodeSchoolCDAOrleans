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
<<<<<<< HEAD
        if (sentinel != null) {
            collection.add(sentinel);

            return true;
        }
=======
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
        return false;
    }

    @Override
    public int size() {
<<<<<<< HEAD
        return collection.size();
=======
        return 0;
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public Sentinel[] getPatrol(int patrolSize) {
<<<<<<< HEAD
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
=======
        return new Sentinel[0];
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public void patrolReturn(Sentinel[] sentinels) {
<<<<<<< HEAD
        for (Sentinel sentinel : sentinels) {
            this.collection.add(sentinel);
        }
=======

>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }

    @Override
    public boolean contains(Sentinel sentinel) {
<<<<<<< HEAD
        return collection.contains(sentinel);
=======
        return false;
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
    }
}
