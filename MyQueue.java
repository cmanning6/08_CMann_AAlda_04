/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 *
 * Class that imitates a queue
 */
public class MyQueue<T> extends MyList<T> {

	/*
	* Base constructor 
	*/
	public MyQueue() {
		super();
	}
	/*
	* Adds new item to the back of the queue
	*/
	public void enqueue(T data) {
		insert(data, size);
	}

	/*
	* Removes front most item from queue
	*/
	public T dequeue() {
        return remove(0);
	}
}
