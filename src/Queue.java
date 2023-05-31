
public class Queue {
	
	// Attributes
	private int rear, front;
	private Object[] elements;
	
	// Constructor
	public Queue(int capacity) {
		elements = new Object[capacity];
		rear = -1;
		front = 0;
	}
	
	// Checking if our queue is Empty or not
	public boolean isEmpty() {
		return rear < front;
	}
	
	// Checking if our queue is Full or not
	public boolean isFull() {
		return (rear + 1 == elements.length);
	}
	
	// Set the Size of the queue
	int size() {
		return rear - front + 1;
	}
	
	// Push in to the queue
	public void enqueue(Object data) {
		if(isFull())
			System.out.println("Queue Overflow!");
		else {
			rear++;
			elements[rear] = data;
		}
	}
	
	// Pop object out of the queue
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}
	}
	
	// Peek the top data in the queue
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else
			return elements[front];
	}
}
