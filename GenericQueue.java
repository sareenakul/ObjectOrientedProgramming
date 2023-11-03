package ObjectOrientedProgramming;
import java.util.*;
/**
 * This class is a GenericQueue that holds an unlimited number of 
 * objects. It is able to remove objects and add objects.
 * @author akulsareen
 */

public class GenericQueue {
	// No instance variable should be defined for this class.
	private ArrayList<Object> queue;


	/**
	 * This method adds the <code> obj </code> to the GenericQueue.
	 * @param object is the object that is added to the GenericQueue.
	 */
	
	void add(Object object) {
		// insert your code here
		this.queue.add(object);
	}

	/**
	 * This method removes the object from the GenericQueue
	 * @return returns the removed object.
	 */
	Object remove() {
		// insert your code here. You may want to change the return value.
		if(this.queue.size() == 0) {
			return null;
		}
		return this.queue.remove(queue);
	}

	/**
	 * @return It returns the number of elements in the GenericQueue.
	 */
	int getSize() {
		// insert your code here. You may need to change the return value. 
		return this.queue.size();
	}

}

/**
 * 
 * This class simulates a Queue, which is a data structure that insert and remove data 
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends GenericQueue{
	ArrayList<Object> queue; 
	
	/**
	 * This is the constructor that initializes the <code> queue </code>
	 */
	public Queue() {
		this.queue = new ArrayList<Object>();
	}
	
	/**
	 * This method adds the object into the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 * @param obj is the object that is added to the queue. 
	 */
	@Override
	public void add(Object obj) {
		//automatically adds the object to last index
		this.queue.add(obj);
	}
	/**
	 * This method removes an object from the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 */
	@Override
	public Object remove() {
		if(this.queue.size() == 0) {
			return null;
		}
		//since the element first enters 0th index so each time 0th element will be removed
		return this.queue.remove(0);
	}
	/**
	 * @return returns the object which is in front of the queue.
	 */
	public Object top() {
		if(this.queue.size() == 0) {
			return null;
		}
		//returns the front element
		return this.queue.get(0);
	}
	
	/**
	 * Returns the number of items in the queue.
	 */
	@Override 
	public int getSize(){
	      return this.queue.size();
	}
}

/**
 * 
 * This class simulates a Deque, which is a data structure that insert and remove data 
 * by FILO (first-in, last-out) rule
 *
 */
class Deque extends Queue{

	/**
	 * This is the constructor that initializes the <code> deque </code>
	 */
	public Deque() {
	
	}
	
	/**
	 * This method adds an object to the deque treated as a stack. 
	 * Please note that the rule of the deque insertion/removal is 
	 * both First in, first out (FIFO), as well as Last in, First out (LIFO) 
	 */
	public void push(Object obj) {
		this.queue.add(0, obj);
	}
	
	/**
	 * This method removes an object from the deque treated as a stack. 
	 * Please note that the rule of the deque insertion/removal is 
	 * both First in, first out (FIFO), as well as Last in, First out (LIFO) 
	 */
	public Object pop() {
		if(this.queue.size() == 0) {
			return null;
		}
		return this.queue.remove(0);
	}
}