package wcscda.quest.A_collection;

import org.apache.commons.lang3.ArrayUtils;
import wcscda.quest.Sentinel;

import java.util.*;

public class FixedSizeCollection implements Collection<Integer> {
    private final Integer[] array;

    public FixedSizeCollection(int maxSize) {
        this.array = new Integer[maxSize];
    }

    @Override
    public int size() {
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                length -= 1;
            }
        }

        return length;
    }

    @Override
    public boolean isEmpty() {
        if (Arrays.stream(array).allMatch(Objects::isNull)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Integer a: array) {
            if (a == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = integer;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o == array[i]) {
                while (i < array.length -1) {
                    array[i] = array[i + 1];

                    i++;
                }
                array[i] = null;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}