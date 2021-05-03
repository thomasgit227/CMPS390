package Assignments.Assignment2;

public class PostfixSolver {
    
    int solve(String expression) {
        //Empty Check
        if(expression.isBlank()) {
            return 0;
        }

         //Creates Stack that can Contain Whole Expression
        IntStack stack = new IntStack(expression.length());

        //Parse Through Expression
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            //Push Numbers to Stack
            if(Character.isDigit(c)) {
                stack.push(Integer.parseInt(""+c));
            }

            //Operations (Note: The Second Number is on Top the Stack)
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                int b = Integer.parseInt(""+stack.pop());
                int a = Integer.parseInt(""+stack.pop());
                
                if(c == '+') {
                    stack.push(a+b);
                }
                if(c == '-') {
                    stack.push(a-b);
                }
                if(c == '*') {
                    stack.push(a*b);
                }
                if(c == '/') {
                    stack.push(a/b);
                }
            }
        }
        return stack.peek();
    }
}