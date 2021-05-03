package Assignments.Assignment2;

class ParenthesisValidator {

    boolean isValid(String input) {
        //Creates Stack that can Contain Whole Input
        CharStack stack = new CharStack(input.length());

        //Parse Through Input
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //Finds and Pushes 'Openers' to Stack 
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }

            //Filters Lone Closers
            if( (c == '}' || c == ']' || c == ')') && stack.isEmpty()) {
                return false;
            }

            //Finds Closers and Determines if Pairing is Valid
            if((c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[') || (c == ')' && stack.peek() == '(') ) {
                char opener = stack.pop();
                char closer = c;
                if( (opener == '{' && closer != '}') || (opener == '[' && closer != ']') || (opener == '(' && closer != ')') ) {
                    return false;
                }
            }

        }

        //Empty Stack Implies Expression must be Valid
        if(stack.isEmpty()) {
            return true;
        }

        //A Nonempty Stack Implies Unmatched Opener
        return false;
    }

}
