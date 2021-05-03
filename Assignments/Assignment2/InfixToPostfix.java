package Assignments.Assignment2;

public class InfixToPostfix {

    String translate(String infix) {
        //Creates Two Stacks - One to Hold the Postfix Expression we Create, and One to Temporarily Store Found Operators
        CharStack postfix = new CharStack(infix.length());
        CharStack operators = new CharStack(infix.length());

        //Parse Through Expression
        for(int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            //Operator Check
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                operators.push(c);
            }

            //Push Operands as they Arrive
            if(Character.isDigit(c)) {
                postfix.push(c);
            }

            //After Parenthesis Move Operators Over
            if(c == ')') {
                postfix.push(operators.pop());
            }
        }

        //Extra Lone Operators
        while(!operators.isEmpty()) {
            postfix.push(operators.pop());
        }
        
        return String.valueOf(postfix.stack);
    }
}