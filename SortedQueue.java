/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 *
 * Class that sorts its contents and puts them into a queue
 */
public class SortedQueue<T extends Comparable<T>> extends MyList<T>{
	/*
	* Prints the menu
	*/
	public SortedQueue() {
		super();
	}
	/*
	* Compares item to others in queue and puts it in proper place
	*/
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

	/*
	* Takes front most item off the queue
	*/
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
