/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 * Total Marks LinkedStack Class: 15 Marks
 */
public class LinkedQueue<T> implements IQueue<T>, Cloneable {

	/** The underlying singly linked list */
	private SList<T> list;

	/**
	* Default constructor
	*/
	public LinkedQueue() {
		list = new SList<>();
	}
	/**
	* Returns the number of elements in the queue.
	* @return number of elements in the queue
	* 2 Marks
	*/
	@Override
	public int size() {
		return this.list.size();
	}

	/**
	* Tests whether the queue is empty.
	* @return true if the queue is empty, false otherwise
	* 2 Marks
	*/
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	* Inserts an element at the rear of the queue.
	* @param elem  the element to be inserted
	* 2 Marks
	*/
	@Override
	public void enqueue(T elem) {
		//TODO: Complete
		this.list.addLast(elem);
	}
	
	/**
	* Returns, but does not remove, the first element of the queue.
	* @return the first element of the queue (or null if empty)
	* 2 Marks
	*/
	@Override
	public T first() {
		//TODO: Complete
		return this.list.first();
	}

	/**
	* Removes and returns the first element of the queue.
	* @return element removed (or null if empty)
	* 2 Marks
	*/
	@Override
	public T dequeue() {
		//TODO: Complete
		return this.list.removeFirst();
	}

	/**
	* Returns clone of LinkedQueue
	* @return clone of LinkedQueue
	* 5 Marks
	*/
	@Override
	public LinkedQueue<T> clone() {
		//TODO: Complete
		LinkedQueue<T> Queue = new LinkedQueue<>();
		Queue.list = this.list.clone();
		return Queue;
	}	
	
	/**
	* Method for displaying (front to back) and serialising items in the queue
	* @return string representation of the queue
	*/
	public String toString() {
		return list.toString();
	}
}
