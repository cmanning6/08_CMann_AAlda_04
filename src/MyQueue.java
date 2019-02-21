public class MyQueue<T> extends MyList<T> {

	int maxSize;

	public MyQueue(int size) {
		super();
		head = null;
		tail = null;
		int maxSize = size;
	}
	public void enqueue(T data) {
		if(getSize() < maxSize)
			insertBack(data);
	}

	public T dequeue() {
		if (getSize() == 0)
            System.out.println("Queue is empty");
        return removeBack();
	}
}
