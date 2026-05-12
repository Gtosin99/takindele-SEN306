public class LinkedQueue implements QueueADT {

    private Node head;
    private Node tail;
    private int count;

    // Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }

        int value = head.data;
        head = head.next;

        // If queue becomes empty
        if (head == null) {
            tail = null;
        }

        count--;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}