package wcscda.quest.B_generic;

import wcscda.quest.Sentinel;

import java.lang.reflect.Array;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 246f7321dd240ede60abce8b892d82ca9d827a80
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class FixedSizeCollection<T> implements Collection<T> {
    private int maxSize;
    private T[] array;
    private int currentSize;

    public FixedSizeCollection(Class<T> clazz, int maxSize) {
        this.maxSize = maxSize;
        this.array = (T[])Array.newInstance(clazz, maxSize);
        this.currentSize = 0;
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
        for (T a: array) {
            if (a == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = t;
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
    public boolean addAll(Collection<? extends T> collection) {
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