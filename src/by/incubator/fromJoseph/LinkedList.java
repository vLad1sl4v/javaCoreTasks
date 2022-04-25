package by.incubator.fromJoseph;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T>{
    int size;
    Node<T> first;
    Node<T> last;

    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        Node (T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        if (size == 0) {
            first = new Node<>(t, null, null);
            last = first;
        } else {
            last = new Node<>(t, last, null);
            last.previous.next = last;
        }

        size++;

        return true;
    }

    @Override
    public T remove(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("There is no element with such index");
        }

        if (index == 0) {
            Object returnValue = first.value;
            first = first.next;
            first.previous = null;

            size--;
            return (T)returnValue;
        }

        if (index == size - 1) {
            Object returnValue = last.value;
            last = last.previous;
            last.next = null;

            size--;
            return (T)returnValue;
        }

        Node<T> nodeToRemove = findNodeByIndex(index);
        Object returnValue = nodeToRemove.value;

        nodeToRemove.previous.next = nodeToRemove.next;
        nodeToRemove.next.previous = nodeToRemove.previous;
        nodeToRemove = null;
        size--;

        return (T)returnValue;
    }

    private Node<T> findNodeByIndex(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("There is no element with such index");
        }

        int nodeToRemoveIndex = 0;
        Node<T> nodeToRemove = null;

        if (index == 0) {
            return first;
        }

        if (index == size - 1) {
            return last;
        }

        if (index >= size / 2) {
            nodeToRemoveIndex = size - 1;
            nodeToRemove = last;

            while (nodeToRemoveIndex != index) {
                nodeToRemove = nodeToRemove.previous;
                nodeToRemoveIndex--;
            }
        } else {
            nodeToRemove = first;

            while (nodeToRemoveIndex != index) {
                nodeToRemove = nodeToRemove.next;
                nodeToRemoveIndex++;
            }
        }

        return nodeToRemove;
    }

    @Override
    public T get(int index) {
        Node<T> node = findNodeByIndex(index);

        return (T) node.value;
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
    public boolean remove(Object o) {
        return false;
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
