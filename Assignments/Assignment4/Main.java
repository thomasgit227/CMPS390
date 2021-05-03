package Assignments.Assignment4;

public class Main {
    public static void main(String[] args) {
        SingularlyLinkedList sll = new SingularlyLinkedList();
        UserInterface ui = new UserInterface(sll);
        ui.loop();
    }
}