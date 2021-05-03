package Assignments.Assignment3;

public class Node {
    
    int value;
    Node next;

    public Node() {
        value = 0;
        next = null;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public String toString() {
        return "" + value;
    }

    public void print() {
        System.out.printf("Node Value is: %d\n", value);
    }
}
