
public class Stack {
	
	// Attributes
	private int top;
	private Object[] elements;
	
	// Constructor
	public Stack(int capacity) {
		elements = new  Object[capacity];
		top = -1;
	}
	
	// Checking if our stack is Empty or not
	public boolean isEmpty() {
		return (top == -1);
	}
	
	// Checking if our stack is Full or not
	public boolean isFull() {
		return (top + 1 == elements.length);
	}
	
	// Set the Size of the stack
	public int size() {
		return top + 1;
	}
		
	// Push in to the stack
	public void push(Object data) {
		if(isFull())
			System.out.println("Stack Overflow!");
		else {
			top++;
			elements[top] = data;
		}	
	}
	
	// Pop object out of the stack
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return null;
		}
		else {
			Object retData = elements[top];
			top--;
			return retData;
		}
	}
	
	// Peek the top data in the stack
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return null;
		}
		else 
			return elements[top];
	}
}

