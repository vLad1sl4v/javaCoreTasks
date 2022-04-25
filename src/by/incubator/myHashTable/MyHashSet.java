package by.incubator.myHashTable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<K> implements Set<K> {
    private static final Object PRESENT = new Object();
    private MyHashTable myHashTable;

    public MyHashSet() {
        myHashTable = new MyHashTable();
    }

    public MyHashSet(int primaryCapacity) {
        myHashTable = new MyHashTable(primaryCapacity);
    }

    @Override
    public boolean remove(Object o) {
        return myHashTable.remove(o) != null;
    }

    @Override
    public boolean add(K k) {
        return myHashTable.put(k, PRESENT) == null;
    }

    @Override
    public boolean contains(Object o) {
        return myHashTable.get(o) != null;
    }

    @Override
    public int size() {
        return myHashTable.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends K> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
