public class SortedQueue<T extends Comparable<T>> extends MyList<T>{
	public SortedQueue() {
		super();
	}
	public SortedQueue enqueue(T data) {
		if (head == null || data.compareTo(head.data) <= 0) {
			insertFront(data);
			return this;
		}
		if (data.compareTo(tail.data >= 0)) {
			insertBack(data);
			return this;
		}

		Node current = head, tmpNode = new Node(data);

		while (current.data.compareTo(data) < 0) {
			current = current.next;
		}

		tmpNode.previous = current.previous;
		tmpNode.next = current;
		current.previous = current.previous.next = tmpNode;
		// super.size++;

		return this;
	}

	public T dequeue(T data) {
		if (head==null)
			return null;
		T data = head.data;
		head = head.next;

		if (head == null)
			tail = null;

		return data;
	}
}
