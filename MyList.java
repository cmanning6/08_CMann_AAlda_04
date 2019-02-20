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

		protected void forward() {
			current = current.next;
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

	public MyList(int size) {
		this.size = size;
		this.head = this.tail;

	}

	public void pop(T obj) {
		for(int i =0; i < size; ++i) {
			insert(obj , 0);
		}
	}

	public void print() {
		Iterator itr = iterator();
		while(itr.hasNext())
		    System.out.println(itr.next());
	}

	public boolean isEmpty() {
		return (size == 0) || (head == null);
	}

	public int getSize() {
		return this.size;
	}

	public void insert(T obj, int pos) {
		Node newNode = new Node(obj);

		if(isEmpty()){
			head = tail = newNode;
			newNode.data = obj;

		} else {
			newNode.next = head.next;
			newNode.data = obj;
			if(newNode.next == null)
			    tail = newNode;
			head = newNode;

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
