public class MyList<T> implements Iterable<T>
{
	protected Node head, tail;
	protected size;

	protected class Node
	{
		T data;
		Node next, previous;

		public Node() {
			Node(0, null, null);
		}
		public Node(T d, Node n, Node p) {
			this.data = d;
			this.next = n;
			this.previous = p;
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
			return this.current;
		}

		protected boolean forward() {
			return this.forward;
		}

		public boolean hasNext() {
			return current.next != null;
		}

		public T next() {
			return current.next;
		}

		public void remove() {
			this.previous.next = this.next;
			this.next.previous = this.previous;
			this.next = this.previous = null;
		}

	}

	public MyList() {
		MyList(0, null, null);
	}

	public MyList(int s, Node h, Node t) {
		this.size = s;
		this.head = h;
		this.tail = t;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return this.size;
	}

	public void insert(T obj, int pos) {
		if(isEmpty()){
			head = tail = new Node(size, null, null);
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

	public Iterator<t> iterator() {
		return iterator(true);
	}

	public Iterator<T> iterator(boolean forward) {
		return new ListIterator(forward);
	}

}
