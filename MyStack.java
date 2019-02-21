/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 *
 * Class that imitates a stack from computers
 */
public class MyStack<T> extends MyList<T>
{

	/*
	* Base constructor
	*/
    public MyStack() {
        size = 0;
        head = tail = null;
    }

	/*
	* Pushed a type of object onto the stack
	*/
    public void push(T obj) {
        insert(obj, 0);
    }

	/*
	* Removes object from the stack while returning its value
	*/
    public T pop() {
        return remove(0);
    }

	/*
	* Returns information from top of stack without deleting
	*/
    public T top() {
        if (getSize() == 0)
            System.out.println("Stack empty");
        return head.data;
    }
}
