public class MyList<T> ()
{
	public class Node<T> ()
	{
		public:
			T data;
			Node next, previous;
		Node<T>() {
			data = 0;
			next = previous = null;
		}
		Node<T>(T d, Node p, Node n) {
			data = 0;
			next = n;
			previous = p;
		}
	}

	public class ListIterator implements Iterator<T> 
	{
		public ListIterator( boolean dir );
		protected Node currentNode;
		protected bool forward;
		public boolean hasNext();
		public T next();
		public void remove();	
	}

	public class 
}
