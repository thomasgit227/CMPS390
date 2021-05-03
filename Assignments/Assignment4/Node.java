package Assignments.Assignment4;

public class Node {

    Node next = null;
    String word = "";
    String definition = "";
    Character location = 0;
    int wordValue = 0;

    public Node() {
        changeCase();
    }

    public Node(String word) {
        this.word = word;
        changeCase();
        calculateValue();
        setLocation();
    }

    public Node(String word, String definition) {
        this.word = word;
        this.definition = definition;
        changeCase();
        calculateValue();
        setLocation();
    }

    public Node(String word, String definition, Node next) {
        this.word = word;
        this.definition = definition;
        this.next = next;
        changeCase();
        calculateValue();
        setLocation();
    }

    public int getValue() {
        return wordValue;
    }

    public Node getNext() {
        return next;
    }

    public String toString() {
        return word;
    }

    public void print() {
        System.out.printf("(%c) - %s: %s (%d) \n", location, word, definition, wordValue);
    }
    
    public void changeCase() {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                char newCh = Character.toLowerCase(word.charAt(i));
                word = word.replace(word.charAt(i), newCh);
            }
            else if(!Character.isLetterOrDigit(word.charAt(i))) {
                word = word.replace(word.charAt(i), (char)0);
            }
        }
    }

    public void calculateValue() {
        int value = 0;

        if(word.length() < 3) {
            for(int i = 0; i < word.length(); i++) {
                value += (word.charAt(i) - 'a') * Math.pow(26, 2 - i);
            }
        }
        else {
            for(int i = 0; i < 3; i++) {
                value += (word.charAt(i) - 'a') * Math.pow(26, 2 - i);
            }
        }

        wordValue = value;
    }

    public void setLocation() {
        if(word.length() != 0) {
            location = word.charAt(0);
        }
    }

    public void setDefinition(String newDef) {
        this.definition = newDef;
    }
}