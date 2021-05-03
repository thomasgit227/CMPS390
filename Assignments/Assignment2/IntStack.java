package Assignments.Assignment2;

public class IntStack {

    int top = -1;
    int maxSize = 0;

    int[] stack;
	public IntStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

	public void push(int item) {
        if( (top + 1) == maxSize) {
            System.out.println("ERR: Cannot Push Item to Full Stack");
            System.exit(0);
        }
        stack[++top] = item;
	}
	
	public int pop() {
        if(isEmpty()) {
            System.out.println("ERR: Cannot Pop Item Out of Empty Stack");
            System.exit(1);
        }
		return stack[top--];
	}

    public int peek() {
        if(isEmpty()) {
            System.out.println("ERR: Cannot Peek an Empty Stack");
            System.exit(2);
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