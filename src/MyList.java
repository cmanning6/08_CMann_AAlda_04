package src;

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

        public String toString() {
            return current.toString();
        }
	}

	public MyList() {
		this.size = 0;
		this.head = this.tail = null;
	}

    public T pop(T obj) {
        T tmp = head.data;
        remove(0);
        return tmp;
	}

	public boolean isEmpty() {
        return size == 0;
	}

	public int getSize() {
		return this.size;
	}

	protected void insert(T obj, int pos) {
		Node newNode = new Node(obj);
        Node currNode = head;

        if (pos == 0)
            insertFront(obj);
        else if (pos >= size)
            insertBack(obj);
        else {
            for (int i = 0; i < pos; ++i) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.previous = currNode;
            currNode.next = currNode.next.previous = newNode;
        }
        ++size;
    }

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

    private void insertBack(T obj) {
        Node node = new Node(obj);

        if (isEmpty()) {
            head = node;
        } else {
            node.previous = tail;
        }

        tail = node;
    }

	protected T remove(int pos) {
        Node tmpNode = head;

        if (pos == 0) {
            return removeFront();
        }
        if (pos > (size - 1)) {
            return removeBack();
        }

        for (int i = 0; i <= pos; ++i) {
            tmpNode = tmpNode.next;
        }

        T tmpData = tmpNode.data;
        tmpNode.previous.next = tmpNode.next;
        tmpNode.next.previous = tmpNode.previous;
        tmpNode.next = tmpNode.previous = null;
        --size;
        return tmpData;
    }

    private T removeFront() {
        Node tmpNode = head;
        T tmpData = head.data;

        head = head.next;
        tmpNode.next = null;
        --size;
        return tmpData;
    }

    private T removeBack() {
        Node tmpNode = tail;
        T tmpData = tail.data;

        tail = tail.previous;
        tmpNode.previous = null;
        --size;
        return tmpData;
    }

	public Iterator<T> iterator() {
		return iterator(true);
	}

	public Iterator<T> iterator(boolean forward) {
		return new ListIterator(forward);
	}

}
