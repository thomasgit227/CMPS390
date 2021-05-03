package Assignments.Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ParenthesisValidator parenValidator = new ParenthesisValidator();
        PostfixSolver postfixSolver = new PostfixSolver();
        InfixToPostfix translator = new InfixToPostfix();

        try {
            File file = new File("AssignmentTwo/buff.txt");
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);

                    if(parenValidator.isValid(line)) {
                        System.out.println("is Valid");
                        System.out.println("Postfix: " + translator.translate(line));
                        System.out.println("Equal to: " + postfixSolver.solve(translator.translate(line)));
                    }
                    else {
                        System.out.println("is Invalid");
                    }

                System.out.println("");
            }
            sc.close();
          } 
          
          catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
    }
}

