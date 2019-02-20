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
			return current.next != null;
		}

		public T next() {
			T tmp = current.next.data;
			current = current.next;
			return tmp;
		}

		public void remove() {
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = current.previous = null;
		}

	}

	public MyList() {
		this.size = 0;
		this.head = this.tail = null;
	}

	public void pop(T obj) {
		for(int i =0; i < size; ++i) {
			insert(obj, 0);
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

	protected void insert(T obj, int pos) {
		Node newNode = new Node(obj);
        ListIterator litr = new ListIterator(true);

        while(litr.hasNext() && --pos > -1) //advance litr to desired position
            litr.next();
        newNode.previous = litr.current;
        litr.next();
        newNode.next = litr.current;

        if(newNode.previous == null)
            head = newNode;
        if(newNode.next == null)
            tail = newNode;
        ++size;
	}

	public void insertFront(T obj) {
	    insert(obj, 0);
    }

    public void insertBack(T obj) {
	    insert(obj, size);
    }

	protected T remove(int pos) {
	    T tmp = null;
        ListIterator litr = new ListIterator(true);

        while(litr.hasNext() && --pos > 0) //advance litr to desired position
            tmp = litr.next();

        litr.remove();
        --size;
        return tmp;
    }

    public T removeFront() {
	    return remove(0);
    }

    public T removeBack() {
	    return remove(size);
    }

	public Iterator<T> iterator() {
		return iterator(true);
	}

	public Iterator<T> iterator(boolean forward) {
		return new ListIterator(forward);
	}

}
