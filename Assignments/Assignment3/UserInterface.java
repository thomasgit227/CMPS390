package Assignments.Assignment3;
import java.util.Scanner;

public class UserInterface {
    
    Scanner user = new Scanner(System.in);
    SingularlyLinkedList sll;
    String res = "";
    boolean isDone = false;
    boolean needsList = true;

    UserInterface() {
        System.out.println("Hello & Welcome to the Linked List Interface");
    }

    UserInterface(SingularlyLinkedList sll) {
        this.sll = sll;
        needsList = false;
        System.out.println("Hello & Welcome to the Linked List Interface");
    }

    void loop() {
        while(!isDone) {
            if(needsList || sll.getTail() == null) {
                System.out.println("List not Found, Let's Create One, How Long Would you Like Your Initial List?");
                int len = user.nextInt();
                user.nextLine();
                sll.buildSimpleList(len);
                needsList = false;
            }

            res = "";
            prompt();
            getResponse();

            if(res.equals("show")) {
                sll.showList();
            }
            else if(res.equals("add")) {
                addSequence();
            }
            else if(res.equals("delete")) {
                delSequence();
            }
            else if(res.equals("reset")) {
                sll.head.next = null;
                sll.head = null;
                needsList = true;
            }
            else if(res.equals("exit")) {
                isDone = true;
            }
            else {
                System.out.println("Try Again...");
            }
        }
    }

    void prompt() {
        System.out.println("Please Enter an Action:");
        System.out.printf(""+ 
            "   'show' - Displays Current Linked List \n" +
            "   'add' - Creates Node at User Specified Location \n" +
            "   'delete' - Removes User Specified Node \n" +
            "   'reset' - Recreate List \n" +  
            "   'exit' - Leave Program \n");
    }   

    void addSequence() {
        int value;

        System.out.println("What would you like to add? (Enter an Integer)");
        value = user.nextInt();
        user.nextLine();
        Node newNode = new Node(value);

        System.out.println("Would you to like add this before or after another Node? (Enter 'before' or 'after') ");
        String placement = user.nextLine();

        System.out.printf("Would you to like to add %d %s by index or by found value (Enter 'index or 'value') \n", value, placement);
        String method = user.nextLine();

        System.out.printf("And what %s are you referring to? (Enter %s)\n", method, method);
        int indexOrValue = user.nextInt();
        user.nextLine();
 
        if(placement.equals("before")) {
            if(method.equals("index")) {
                sll.addBeforeIndex(indexOrValue, newNode);
            }
            else if(method.equals("value")) {
                sll.addBeforeValue(indexOrValue, newNode);
            }
            else {
                System.out.println("There was an issue handling your request, please try again");
            }
        }
        else if(placement.equals("after")) {
            if(method.equals("index")) {
                sll.addAfterIndex(indexOrValue, newNode);
            }
            else if(method.equals("value")) {
                sll.addAfterValue(indexOrValue, newNode);
            }
            else {
                System.out.println("There was an issue handling your request, please try again");
            }
        }
        else {
            System.out.println("There was an issue handling your request, please try again");
        }
    }

    void delSequence() {
        System.out.println("Would you to like to delete a(n) index or value (Enter 'index or 'value')");
        String method = user.nextLine();

        System.out.printf("And what %s are you referring to? (Enter %s)\n", method, method);
        int indexOrValue = user.nextInt();
        user.nextLine();
 
        if(method.equals("value")) {
            sll.deleteValue(indexOrValue);
        }
        else if(method.equals("index")) {
            sll.deleteIndex(indexOrValue);
        }
        else {
            System.out.println("There was an issue handling your request, please try again");
        }
    }

    void getResponse() {
        res = user.nextLine();
    }
}