package Lesson8;

import java.util.LinkedList;
import java.util.Optional;

public class LinkedHashTableImpl {
    private void decreaseSize(Node<K, V> it) {
        size--;
    }

    private static class Node<K, V> implements HashTable.Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }


    private LinkedList<Node<K, V>>[] data;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize];
        init(data);
    }

    private void init(LinkedList<Node<K,V>>[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {

        int index = hashFunc(key);

        getEntry(key).ifPresentOrElse(
                node -> node.setValue(value),
                () -> addLast(new Node<>(key, value), data[index]));

        return true;
    }

    private void addLast(Node<K, V> e, LinkedList<Node<K, V>> datum) {
        datum.addLast(e);
        size++;
    }

    @Override
    public V get(K key) {
        return getEntry(key)
                .map(Node::getValue)
                .orElse(null);
    }

    private Optional<Node<K, V>> getEntry(K key) {
        int index = hashFunc(key);
        for (Node<K, V> node : data[index]) {
            if (node.getKey().equals(key)) {
                return Optional.of(node);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        Optional<Node<K, V>> entry = getEntry(key);
        entry.ifPresent(data[hashFunc(key)]::remove);
        entry.ifPresent(this::decreaseSize);
        return entry.map(Node::getValue).orElse(null);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void display() {
        System.out.println("---------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("---------");
    }


}
