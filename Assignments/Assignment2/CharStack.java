package Assignments.Assignment2;

public class CharStack {

    int top = -1;
    int maxSize = 0;

    char[] stack;
	public CharStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new char[maxSize];
    }

	public void push(char item) {
        if( (top + 1) == maxSize) {
            System.out.println("ERR: Cannot Push Item to Full Stack");
            System.exit(0);
        }
        stack[++top] = item;
	}
	
	public char pop() {
        if(isEmpty()) {
            System.out.println("ERR: Cannot Pop Item Out of Empty Stack");
            System.exit(1);
        }
		return stack[top--];
	}

    public char peek() {
        if(isEmpty()) {
            return 0;
        }
        return stack[top];
    }
	
	public boolean isEmpty() {
		if(top == -1) {
            return true;
        }
        return false;
	}
		
	public int getTop() {
		return top;
	}
	
	public void print() {
        System.out.println(stack);
	}
}