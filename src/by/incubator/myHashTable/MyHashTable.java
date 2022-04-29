package by.incubator.myHashTable;

import java.util.*;

public class MyHashTable<K, V> implements Map<K, V>{
    private static final int PRIMARY_CAPACITY = 16;
    private Object[] table;
    private int size;

    public MyHashTable() {
        table = new Object[PRIMARY_CAPACITY];
    }

    public MyHashTable(int initialCapacity) {
        table = new Node<?, ?>[initialCapacity];
    }


    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException("You can't put null value");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        if (table[index] != null) {
            V oldValue = replaceIfExists(key, value, index, hash);

            if (oldValue == null) {
                Node<K, V> lastNode = getLastNode(index);
                Node<K, V> newNode = new Node<>(hash, key, value, null);
                lastNode.next = newNode;
                size++;
            }

            return oldValue;
        }
        else {
            table[index] = new Node<>(hash, key, value, null);
            size++;
        }

        return null;
    }

    private Node<K, V> getLastNode(int index) {
        Node<K, V> lastNode = (Node<K, V>) table[index];

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        return lastNode;
    }

    private V replaceIfExists(K key, V value, int index, int hash) {
        Node<K, V> node = (Node<K, V>) table[index];

        do {
            if (node.hash != hash && !node.key.equals(key)) {
                node = node.next;
                continue;
            }

            V oldValue = node.value;
            node.setValue(value);
            return oldValue;
        } while (node != null);

        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException("the key is null");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        if (table[index] == null) {
            return null;
        }

        Node<K,V> node = (Node<K, V>) table[index];
        if (node.hash == hash && node.key.equals(key)) {
            V oldValue = node.value;
            table[index] = node.next;
            size--;
            return oldValue;
        }

        Node<K, V> preNode = getPreNode(index, hash, key);

        if (preNode == null) {
            return null;
        }

        V oldValue = preNode.next.value;
        preNode.next = preNode.next.next;
        size--;

        return oldValue;
    }

    private Node<K,V> getPreNode(int index, int hash, Object key) {
        Node<K,V> preNode = (Node<K, V>) table[index];

        while (preNode != null) {
            if (preNode.next.hash == hash && preNode.next.key.equals(key)) {
                return preNode;
            }
        }

        return null;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("The key can't be null");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        if (table[index] == null) {
            return null;
        }

        Node<K,V> node = (Node<K, V>) table[index];
        if (node.hash == hash && node.key.equals(key)) {
            return node.value;
        }

        Node<K, V> preNode = getPreNode(index, hash, key);

        if (preNode == null) {
            return null;
        }

        V value = preNode.next.value;

        return value;
    }

    @Override
    public synchronized V getOrDefault(Object key, V defaultValue) {
        V result = get(key);
        return (null == result) ? defaultValue : result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
       return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
