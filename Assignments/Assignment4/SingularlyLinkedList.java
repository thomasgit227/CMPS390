package Assignments.Assignment4;

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
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        tail = curr;
        return curr;
    }

	Node makeNode(String word, String definition) {
        return new Node(word, definition);
    }

    Node makeNode(String word) {
        return new Node(word);
    }

    int getAmount() {
        int sum = 0;
        Node curr = head;
        while(curr != null) {
            sum++;
            curr = curr.next;
        }
        return sum;
    }

    int getAmount(String section) {
        int sum = 0;
        Node curr = head;
        while(curr != null) {
            if(curr.location == Character.toLowerCase(section.charAt(0))) {
                sum ++;  
            }   
            curr = curr.next; 
        }
        return sum;
    }

    void addNodeToList(String word, String definition) {
        Node curr = head;
        Node newNode = makeNode(word, definition);
        //First Node in List
        if(head == null) {
            head = newNode;
        }
        while(curr != null) {
            //New Node needs to be Moved Down List
            if(newNode.getValue() > curr.getValue()) {
                //New Node is Biggest in List
                if(curr.next == null) {
                    curr.next = newNode;
                    break;
                }
                else if(newNode.getValue() < curr.next.getValue()) {
                    newNode.next = curr.next;
                    curr.next = newNode;
                    break;
                }
                //Iterate Down List
                else {
                    curr = curr.next;
                }
            }
            //Repeat Word Codes do not count
            else if(newNode.getValue() == curr.getValue()) {
                //Majority of Cases
                if(newNode.word.equals(curr.word)) {
                    break;
                }
                //If Codes Match but not Words Insert After (Rare Edge Case)
                else {
                    newNode.next = curr.next;
                    curr.next = newNode;
                    break;
                }
            }
            //First iteration of Loop, Curr is at Head
            else {
                newNode.next = head;
                head = newNode;
                break;
            }
        }
    }

    void addNodeToList(String word) {
        Node curr = head;
        Node newNode = makeNode(word);
        //First Node in List
        if(head == null) {
            head = newNode;
        }
        while(curr != null) {
            //New Node needs to be Moved Down List
            if(newNode.getValue() > curr.getValue()) {
                //New Node is Biggest in List
                if(curr.next == null) {
                    curr.next = newNode;
                    break;
                }
                else if(newNode.getValue() < curr.next.getValue()) {
                    newNode.next = curr.next;
                    curr.next = newNode;
                    break;
                }
                //Iterate Down List
                else {
                    curr = curr.next;
                }
            }
            //Repeat Word Codes do not count
            else if(newNode.getValue() == curr.getValue()) {
                break;
            }
            //First iteration of Loop, Curr is at Head
            else {
                newNode.next = head;
                head = newNode;
                break;
            }
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

    void changeDefinition(String word, String newDef) {
        Node curr = head;
        while(curr != null) {
            if(curr.word.equals(word)) {
                curr.setDefinition(newDef);
            }
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

    void showSection(String section) {
        Node curr = head;    
        while(curr != null) {    
            if(curr.location == Character.toLowerCase(section.charAt(0))) {
                curr.print();  
            }   
            curr = curr.next; 
        }  
    }
}