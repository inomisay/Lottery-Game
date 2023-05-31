
public class CircularQueue {
	
	// Attributes
	private int rear, front;
	private Object[] elements;
		
	// Constructor
	public CircularQueue(int capacity) {
			elements = new Object[capacity];
			rear = -1;
			front = 0;
	}
		
	// Checking if our queue is Empty or not
	public boolean isEmpty() {
		return elements[front] == null;
	}
		
	// Checking if our queue is Full or not
	public boolean isFull() {
		return (front == (rear + 1) % elements.length && elements[front] != null && elements[rear] != null);
	}
		
	// Set the Size of the queue
	int size() {
		if(elements[front] == null) {
			return 0;
		}
		else {
			if(rear >= front)
				return rear - front + 1;
			else
				return elements.length - (front - rear) + 1;
		}
	}
		
	// Push in to the queue
	public void enqueue(Object data) {
		if(isFull())
			System.out.println("Queue Overflow!");
		else {
			rear = (rear + 1) % elements.length;
			elements[rear] = data;
		}
	}
		
	// Pop object out of the stack
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			return retData;
		}
	}
		
	// Peek the top data in the stack
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else
			return elements[front];
	}
}
