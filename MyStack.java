public class MyStack<T> extends MyList<T>
{
    int maxSize;

    public MyStack(int size) {
        super();
        int maxSize = size;
	}

	public void push(T obj) {
	    if(getSize() < maxSize)
		    insertFront(obj);
	}

	public T pop() {
        if (getSize() == 0)
            System.out.println("Stack empty");
        return removeFront();
    }

    public T top() {
        if (getSize() == 0)
            System.out.println("Stack empty");
        return head.data;
    }
}
