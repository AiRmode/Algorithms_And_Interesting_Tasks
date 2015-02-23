package adt;

/**
 * Created by alshevchuk on 22.02.2015.
 */
public class Queue<T> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int size() {
        return size;
    }

    private class Node {
        T item = null;
        Node next = null;
    }

    public void enqueue(T t) {
        size++;
        Node node = new Node();
        node.item = t;

        if (first == null) {
            first = node;
        } else if (last == null) {
            last = node;
            first.next = last;
        } else {
            last.next = node;
            last = node;
        }
    }

    public T dequeue() {
        size--;
        T temp = first.item;
        first = first.next;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while (node != null) {
            sb.append(node.item);
            node = node.next;
            sb.append(", ");
        }
        return sb.toString();
    }
}
