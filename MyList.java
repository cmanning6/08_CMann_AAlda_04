/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 */
import java.util.Iterator;

public class MyList<T> implements Iterable<T>
{
	protected Node head, tail;
	protected int size;

	/*
	* Node for linked list
	*/
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

	/*
	* Iterator that covers entire list
	*/
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

        public String toString() {
            return current.toString();
        }
	}

	/*
	* Constructor
	*/
	public MyList() {
		this.size = 0;
		this.head = this.tail = null;
	}

	public boolean isEmpty() {
        return size == 0;
	}

	public int getSize() {
		return this.size;
	}

	/*
	* Inserts node into any location
	*/
	protected void insert(T obj, int pos) {
		Node newNode = new Node(obj);
        Node currNode = head;

        if (pos == 0)
            insertFront(obj);
        else if (pos >= size)
            insertBack(obj);
        else {
            for (int i = 0; i < pos-1; ++i) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.previous = currNode;
            currNode.next = currNode.next.previous = newNode;
        }
        ++size;
    }

	/*
	* Helper function for insert
	*/
    private void insertFront(T obj) {
        Node node = new Node(obj);
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        head.previous = node;
        node.next = head;
        head = node;
    }
	
	/*
	* Helper function for insert
	*/
    private void insertBack(T obj) {
        Node node = new Node(obj);

        if (isEmpty()) {
            head = tail= node;
        } else {
        	tail.next = node;
            node.previous = tail;
        }

        tail = node;
    }

	/*
	* Removes node from any position on list
	*/
	protected T remove(int pos) {

        if (pos <= 0) {
            return removeFront();
        }
        if (pos >= (size - 1)) {
            return removeBack();
        }
        Node prevNode = head;
        Node currNode = head.next;
        Node nextNode = head.next.next;

        for (int i = 0; i < pos-1; ++i) {
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        T tmpData = currNode.data;
        
        prevNode.next = nextNode;
        nextNode.previous = prevNode;
        currNode.next = currNode.previous = null;
        --size;
        return tmpData;
    }

	/*
	* Helper function for remove
	*/
    private T removeFront() {
        Node tmpNode = head;
        T tmpData = head.data;

        head = head.next;
        tmpNode.next = null;
        --size;
        return tmpData;
    }

	/*
	* Helper function for remove
	*/
    private T removeBack() {
        Node tmpNode = tail;
        T tmpData = tail.data;

        tail = tmpNode.previous;
        tmpNode.previous.next = null;
        tmpNode.previous = tmpNode.next = null;
        --size;
        return tmpData;
    }

	/*
	* Base case iterator for traversing list
	*/
	public Iterator<T> iterator() {
		return iterator(true);
	}

	/*
	* Custom case iterator for traversing list
	*/
	public Iterator<T> iterator(boolean forward) {
		return new ListIterator(forward);
	}

}
