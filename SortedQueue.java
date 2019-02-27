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
	public void enqueue(T obj) {
		T tmpMem = head;
		int pos = 0;

		if (tmpMem == null) {
			insert(obj, 0);
			return;
		}

		while (obj.compareTo(tmpMem) > 0) {
			++pos;
			tmpMem = tmpMem.next;
		}

		insert(obj, pos);
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
