package by.incubator.fromJoseph;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<T> implements List<T> {
    private final int PRIMARY_CAPACITY = 10;
    private Object[] dataArr;
    private int size = 0;

    public ArrayList() {
        dataArr = new Object[PRIMARY_CAPACITY];
    }

    public ArrayList(int capacity) {
        dataArr = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        if (!checkCapacity(size + 1)) {
            increaseCapacity();
        }

        dataArr[size++] = t;
        return true;
    }

    private boolean checkCapacity(int minCapacity) {
        return minCapacity < dataArr.length;
    }

    private void increaseCapacity() {
        int newCapacity = dataArr.length * 3 / 2 + 1;
        Object[] newDataArr = new Object[newCapacity];
        System.arraycopy(dataArr, 0, newDataArr, 0, dataArr.length);
        dataArr = newDataArr;
    }

    @Override
    public T remove(int index) {
        if (index > size || index < 0) {
            throw  new IndexOutOfBoundsException("There is no element with such index!");
        }

        Object element = dataArr[index];
        int numMoved = size - index - 1;
        System.arraycopy(dataArr, index + 1, dataArr, index, numMoved);
        dataArr[size--] = null;

        return (T) element;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("There is no element with such index!");
        }
        return (T) dataArr[index];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
