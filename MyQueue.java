/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 *
 * Class that imitates a queue
 */
public class MyQueue<T> extends MyList<T> {

	int maxSize;

	/*
	* Base constructor 
	*/
	public MyQueue(int size) {
		super();
		head = null;
		tail = null;
		int maxSize = size;
	}
	/*
	* Adds new item to the back of the queue
	*/
	public void enqueue(T data) {
		if(getSize() < maxSize)
			insertBack(data);
	}

	/*
	* Removes front most item from queue
	*/
	public T dequeue() {
		if (getSize() == 0)
            System.out.println("Queue is empty");
        return removeBack();
	}
}
