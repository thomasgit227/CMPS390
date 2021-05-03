package Assignments.Assignment4;
import java.io.File;
import java.io.IOException;
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
            prompt();
            getResponse();

            if(res.equals("show")) {
                showSequence();
            }
            else if(res.equals("amount")) {
                amountSequence();
            }
            else if(res.equals("add")) {
                addSequence();
            }
            else if(res.equals("delete")) {
                delSequence();
            }
            else if(res.equals("file")) {
                try {
                    fileSequence();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(res.equals("define")) {
                defSequence();
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
            "   'amount' - Displays Amount of Nodes \n" +
            "   'add' - Creates Node at User Specified Location \n" +
            "   'delete' - Removes User Specified Node \n" +
            "   'file' - Gather All Words from a User Specfied Text File \n" +
            "   'define' - Define a User Specified Word \n" +
            "   'reset' - Recreate List \n" +  
            "   'exit' - Leave Program \n");
    }   

    void showSequence() {
        String yn;
        String section;

        System.out.println("Would You like to Display All Nodes? (y / n)");
        yn = user.nextLine();

        if(yn.equals("y")) {
            sll.showList();
        }
        else {
            System.out.printf("What Section of Words would you like to Display? (Enter a Char) \n");
            section = user.nextLine();
            sll.showSection(section);
        }
    }

    void addSequence() {
        String userWord;
        String userDefinition;

        System.out.println("What word would you like to add? (Enter a String)");
        userWord = user.nextLine();

        System.out.printf("What is the definition of %s? (Enter a String) \n", userWord);
        userDefinition = user.nextLine();
 
        sll.addNodeToList(userWord, userDefinition);
    }

    void delSequence() {
        System.out.println("Would word would you like to delete? (Enter a String)");
        String userWord = user.nextLine();
        Node temp = new Node(userWord);
        sll.delete(temp.getValue());
    }

    void amountSequence() {
        String yn;
        String section;

        System.out.println("Would You like to Count All Nodes? (y / n)");
        yn = user.nextLine();

        if(yn.equals("y")) {
            System.out.printf("There are %d Node(s) in this Dictionary \n", sll.getAmount());
        }
        else {
            System.out.println("What Section would you like to Count? (Enter a Char)");
            section = user.nextLine();
            System.out.printf("There are %d Node(s) in the '%s' Section \n", sll.getAmount(section), section);
        }
    }

    void fileSequence() throws IOException {
        String yn;
        String path;

        System.out.println("What is the Path of the File to Read? (.txt Files)");
        path = user.nextLine();  
        System.out.println("Would You like to Define Every Word About to be Input? (y / n)");
        yn = user.nextLine();

        File file = new File(path);
        Scanner fileScan = new Scanner(file); 
 
        while (fileScan.hasNext()) {
            String word = fileScan.next();
            if(yn.equals("y")) {
                String defn;
                System.out.printf("What is the definition of %s? (Enter a String) \n", word);
                defn = user.nextLine();
                sll.addNodeToList(word, defn);
            }
            else if(yn.equals("n")) {
                sll.addNodeToList(word);
            }
            else {
                break;
            }
        }
        fileScan.close();
    }

    void defSequence() {
        String userWord;
        String userDefinition;

        System.out.println("What word would you like to Define? (Enter a String)");
        userWord = user.nextLine();

        System.out.printf("What is the definition of %s? (Enter a String) \n", userWord);
        userDefinition = user.nextLine();
 
        sll.changeDefinition(userWord, userDefinition);
    }

    void getResponse() {
        res = user.nextLine();
    }
}