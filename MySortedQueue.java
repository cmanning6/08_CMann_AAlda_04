/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 *
 * Class that sorts its contents and puts them into a queue
 */
public class MySortedQueue<T extends Comparable<T>> extends MyList<T>{
	/*
	* Prints the menu
	*/
	public MySortedQueue() {
		super();
	}
	/*
	* Compares item to others in queue and puts it in proper place
	*/
	public void enqueue(T obj) {
		insert(obj, findPos(obj));
	}

	/*
	* Takes front most item off the queue
	*/
	public T dequeue(T obj) {
		int pos = findPos(obj);

		return remove(pos);
	}

	private int findPos(T obj) {
		Node currNode = head;
		int pos = 0;

		while (currNode != null) {
			if (currNode.data.compareTo(obj) >= 0) {
				break;
			} else {
				++pos;
				currNode = currNode.next;
			}
		}

		return pos;

	}
}
