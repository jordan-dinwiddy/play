package cx.ath.nb12.blockingqueue;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> implements CustomQueue<T> {


	private List<T> items = new ArrayList<T>();
	private int maxCapacity;

	public BlockingQueue(int capacity) {
		this.maxCapacity = capacity;
		this.items = new ArrayList<T>(capacity);
	}
	
	/**
	 * Creates a blocking queue with no size limit.
	 */
	public BlockingQueue() {
		this.maxCapacity = -1;
		this.items = new ArrayList<T>();
	}
	
	@Override
	public synchronized void enqueue(T item) {

		while(items.size() == maxCapacity) {
			try {
				this.wait();
			} catch(InterruptedException e) {
				
			}
		}
		
		// Add to end of queue
		items.add(item);
		this.notifyAll();
	}

	@Override
	public synchronized T dequeue() {
		
		while(items.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {

			}
		}
		
		// Remove from front
		this.notifyAll();
		return items.remove(0);
	}
}
