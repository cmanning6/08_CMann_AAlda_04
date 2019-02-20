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

		public void advance() {
			current = current.next;
		}

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			T tmp = current.data;
			current = current.next;
			return tmp;
		}

		public void remove() {
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = current.previous = null;
		}

	}

	public MyList(int size) {
		this.size = size;
		this.head = this.tail = null;

	}

	public void pop(T obj) {
		for(int i =0; i < size; ++i) {
			add(obj);
		}
	}

	/*public void print() {
		Iterator<T> itr = iterator();

		while(itr.hasNext()){
		    System.out.println(itr.next());
		}
	}
	*/

	public boolean isEmpty() {
		return (size == 0) || (tail == null);
	}

	public int getSize() {
		return this.size;
	}

	public void add(T obj) {
		Node newNode = new Node(obj);

		if(isEmpty()){
			tail = newNode;
		} else {
			newNode.next = head;
		}
		head = newNode;
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

