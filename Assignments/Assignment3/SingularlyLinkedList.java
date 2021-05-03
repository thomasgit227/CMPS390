package Assignments.Assignment3;

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

    void buildSimpleList(int length) {
        for(int i = 0; i < length; i++) {
            addNodeToList(i);
        }
    }

    void addAfterValue(int value, Node newNode) {
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

    void addAfterIndex(int index, Node newNode) {
        Node curr = head;
        int currIndex = 0;
        while(curr != null) {
            if(currIndex == index) {
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            currIndex++;
            curr = curr.next;
        }
    }
    
    void addBeforeValue(int value, Node newNode) {
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

    void addBeforeIndex(int index, Node newNode) {
        Node curr = head;
        Node prev = head;
        int currIndex = 0;
        while(curr != null) {
            if(currIndex == index) {
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            currIndex++;
            prev = curr;
            curr = curr.next;
        }  
    }

    void deleteIndex(int index) {
        Node curr = head;
        Node prev = head;
        int currIndex = 0;
        while(curr != null) {
            if(currIndex == index) {
                if(curr.equals(head)) {
                    head = head.next;
                    break;
                }
                prev.next = curr.next;
                break;
            }
            currIndex++;
            prev = curr;
            curr = curr.next;
        }
    }

    void deleteValue(int value) {
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

    void showList() {
        Node curr = head;    
        while(curr != null) {    
            curr.print();  
            curr = curr.next;    
        }    
    }
}
