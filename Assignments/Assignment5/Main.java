package Assignments.Assignment5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        SingularlyLinkedList sll = new SingularlyLinkedList();

        try {
            sll.addNodesFromFile("Assignments/Assignment5/numbers.txt");
            bt.addNodesFromFile("Assignments/Assignment5/numbers.txt");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        sll.bubbleSort();
        sll.showList();
        bt.printInOrder(bt.root);
    }
}
