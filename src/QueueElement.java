
public class QueueElement {
	
	// Attributes
	private Object data;
	private int priority;
	
	// Constructor
	public QueueElement(Object data, int priority) {
		this.data = data;
		this.priority = priority;
	}
	
	// Getters
	public int getPriority() {
		return priority;
	}
	
	public Object getData() {
		return data;
	}
}
