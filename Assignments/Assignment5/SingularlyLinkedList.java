package Assignments.Assignment5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SingularlyLinkedList {

    Node head;
    Node tail;

    SingularlyLinkedList() {
        head = null;
        tail = head;
    }

    SingularlyLinkedList(Node head) {
        this.head = head;
        tail = head;
    }

    Node getTail() {
        return tail;
    }
    
	Node makeNode(int value) {
        return new Node(value);
    }

    void addNodeToList(int value) {
        if(head == null) {
            tail = new Node(value);
            head = tail;
        }
        else {
            Node curr = makeNode(value);    
            tail.next = curr;    
            tail = curr; 
        }
    }

    void addNodesFromFile(String path) throws IOException{
        File file = new File(path);
        Scanner scanner = new Scanner(file); 
 
        while (scanner.hasNextLine()) {
            int nextInt = scanner.nextInt();
            addNodeToList(nextInt);
        }
        scanner.close();
    }

    void addAfter(int value, Node newNode) {
        Node curr = head; 
        while(curr != null) {
            if(curr.getValue() == value) {
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }
    
    void addBefore(int value, Node newNode) {
        Node curr = head; 
        while(curr != null) {
            if(curr.next.getValue() == value) {
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }

    void delete(int value) {
        Node curr = head;
        Node prev = head;
        while(curr != null) {
            if(curr.getValue() == value) {
                if(curr.equals(head)) {
                    head = head.next;
                    break;
                }
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    void bubbleSort() {
        boolean isFinished = false;
        int comparisons = 0;

        while(!isFinished) {
            boolean itSwapped = false;

            Node curr = head;
            Node prev = head;

            while(curr != null) {
                if(curr.getValue() < prev.getValue()) { //swap values
                    int temp = prev.getValue();
                    prev.value = curr.getValue();
                    curr.value = temp;
                    itSwapped = true;
                }
                comparisons ++;
                prev = curr;
                curr = curr.next;
            }

            if(!itSwapped) { //if no swaps after one pass through, break
                isFinished = true;
            }
        }
        System.out.printf("The List has been Bubble Sorted, and %d Comparisons were Made\n", comparisons);
    }

    void showList() {
        Node curr = head;    
        while(curr != null) {    
            curr.print();  
            curr = curr.next;    
        }    
    }
}
