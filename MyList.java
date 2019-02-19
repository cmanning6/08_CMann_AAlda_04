import java.lang.Iterable;
import java.util.Iterator;

public class MyList<T> implements Iterable<T>
{
	protected Node head, tail;
	protected int size;

	protected class Node
	{
		T data;
		Node next, previous;

		public Node(T d) {
			this.data = d;
			this.next = null;
			this.previous = null;
		}
	}

	protected class ListIterator implements Iterator<T>
   	{
		Node current;
		boolean forward;

		public ListIterator(boolean forward) {
			this.forward = forward;
			current = forward ? head : tail;
		}

		protected Node currentNode() {
			return current;
		}

		protected boolean forward() {
			return this.forward;
		}

		public boolean hasNext() {
			return current.next != null;
		}

		public T next() {
			return current.next.data;
		}

		public void remove() {
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = current.previous = null;
		}

	}

	public MyList(int s) {
		this.size = s;
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return this.size;
	}

	public void insert(T obj, int pos) {
		if(isEmpty()){
			head = tail = new Node(obj);
		} else {
			for(int i = 0; i < size; ++i) {
			/*
			 *TODO: finish for loop
			 * */	
			}
		}
	}

	/*
	 *TODO: Add insert and remove
	 */

	public Iterator<T> iterator() {
		return iterator(true);
	}

	public Iterator<T> iterator(boolean forward) {
		return new ListIterator(forward);
	}

}
