package cx.ath.nb12;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> implements MyQueue<T> {


	private List<T> items = new ArrayList<T>();
	private int maxCapacity;

	public BlockingQueue(int capacity) {
		this.maxCapacity = capacity;
		this.items = new ArrayList<T>(capacity);
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
