
public class PriorityQueue {
	
	// Attributes
	private int rear, front;
	private QueueElement[] elements;
	private int temprear, tempfront;
	private QueueElement[] tempelements;
	
	// Constructor
	PriorityQueue(int capacity){
		elements = new QueueElement[capacity];
		tempelements = new QueueElement[capacity];
		rear = -1;
		front = 0;
		temprear = -1;
		tempfront = 0;
	}
	
	// Checking if our queue is Empty or not
	public boolean isEmpty() {
		return elements[front] == null;
	}
	public boolean isEmptyTemp() {
		return tempelements[tempfront] == null;
	}
			
	// Checking if our queue is Full or not
	public boolean isFull() {
		return (front == (rear + 1) % elements.length && elements[front] != null && elements[rear] != null);
	}
	public boolean isFullTemp() {
		return (tempfront == (temprear + 1) % tempelements.length && tempelements[tempfront] != null && tempelements[temprear] != null);
	}
			
	// Enqueue in to the queue
	public void enqueue(QueueElement item) {
		if(isFull())
			System.out.println("Queue Overflow!");
		else {
			while(!isEmpty() && item.getPriority() <= peek().getPriority())
				tempEnqueue(dequeue());
			tempEnqueue(item);
			
			while(!isEmpty())
				tempEnqueue(dequeue());
			while(!isEmptyTemp())
				simpleEnqueue(tempDequeue());
		}
	}
	public void tempEnqueue(QueueElement item) {
		if(isFull())
			System.out.println("Queue Overflow!");
		else {
			temprear = (temprear + 1) % tempelements.length;
			tempelements[temprear] = item;
		}
	}
	public void simpleEnqueue(QueueElement item) {
		if(isFull())
			System.out.println("Queue Overflow!");
		else {
			rear = (rear + 1) % elements.length;
			elements[rear] = item;
		}
	}
			
	// Dequeue object out of the queue
	public QueueElement dequeue() {
		if(isEmptyTemp()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else {
			QueueElement item = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			return item;
		}
	}
	public QueueElement tempDequeue() {
		if(isEmptyTemp()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else {
			QueueElement item = tempelements[tempfront];
			tempelements[tempfront] = null;
			tempfront = (tempfront + 1) % tempelements.length;
			return item;
		}
	}
			
	// Peek the top data in the queue
	public QueueElement peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		else
			return elements[front];
	}

}
