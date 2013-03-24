package cx.ath.nb12.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedPriorityQueue<T> implements Queue<T> {

	private List<QueueEntry<T>> data; 

	public enum Priority {
		LOW(0),
		MEDIUM(1),
		HIGH(2);

		private int nValue;

		private Priority(int nValue) {
			this.nValue = nValue;
		}

		public int getNValue() {
			return nValue;
		}
	}

	private static class QueueEntry<T> {

		private Priority priority;
		private T item;

		private QueueEntry(T item, Priority p) {
			this.item = item;
			this.priority = p;
		}
	}

	public ArrayBasedPriorityQueue() {

		data = new ArrayList<QueueEntry<T>>();
	}

	@Override
	public void enqueue(T item) {

		enqueue(item, Priority.LOW);
	}

	public void enqueue(T item, Priority p) {

		QueueEntry<T> newEntry = new QueueEntry<T>(item, p);

		// Add the item to the end of the tree
		// then bubble it up until the heap condition (left child,right child < parent) holds true
		data.add(newEntry);					// Add item to the end
		heapUpNonRecurse(data.size() - 1);	// Move it up the heap
	}

	@Override
	public T dequeue() {

		// We dequeue items with highest priority
		// So select the item at the top, replace it with the item 
		// at the bottom of the heap, then call downHeap starting at
		// the root so that the item get's moved to it's appropriate
		// position
		if(data.size() == 0) {
			return null;
		}

		QueueEntry<T> result = data.get(0);

		// If we have more than 1 item in the list then we need to change the root
		// node of the tree and then sink it down the heap
		if(data.size() > 1) {
			data.set(0, data.get(data.size() - 1));
			heapDownNonRecurse(0);
		}

		// Since this node now exists elsewhere in the heap, we can delete it
		data.remove(data.size() - 1);

		return result.item;
	}

	/**
	 * Moves the element at the specified index up the heap until the heap condition holds true.
	 * 
	 * @param ix
	 */
	private void heapUpRecurse(int ix) {

		if(ix == 0) {
			// Item is at the top
			return;
		}

		int parentIx = (ix-1)/2;
		QueueEntry<T> child = data.get(ix);
		QueueEntry<T> parent = data.get(parentIx);

		//This is how you would do it recursively
		if(child.priority.nValue > parent.priority.nValue) {
			swap(ix, parentIx);
			heapUpRecurse(parentIx);
		}

	}

	/**
	 * Moves the element at the specified index up the heap until the heap condition holds true.
	 * 
	 * @param ix
	 */
	private void heapUpNonRecurse(int ix) {

		if(ix == 0) {
			// Item is at the top
			return;
		}

		int parentIx = (ix-1)/2;
		QueueEntry<T> child = data.get(ix);
		QueueEntry<T> parent = data.get(parentIx);

		//This is how you would do it non recursively
		while(child.priority.nValue > parent.priority.nValue) {
			swap(ix, parentIx);

			// Recalc indexes
			ix = parentIx; 
			parentIx =  (ix-1)/2;
			child = data.get(ix);
			parent = data.get(parentIx);
		}
	}

	/**
	 * Moves the element at the specified index down the heap until the heap condition holds true.
	 * 
	 * @param ix
	 */
	private void heapDownRecurse(int ix) {

		QueueEntry<T> entry = data.get(ix);
		int leftChildIx = 2 * ix + 1;
		int rightChildIx = 2 * ix + 2;

		if(leftChildIx >= data.size()) {
			// This means there are no children for the node (left node always gets added first so if there's no
			// left then there is no right)
			return;
		}

		int largestChildIx = getLargerNodeIx(leftChildIx, rightChildIx);
		QueueEntry<T> largestChildEntry = data.get(largestChildIx);

		if(entry.priority.nValue < largestChildEntry.priority.nValue) {
			swap(ix, largestChildIx);
			heapDownRecurse(largestChildIx);
		}
	}

	/**
	 * Moves the element at the specified index down the heap until the heap condition holds true.
	 * 
	 * @param ix
	 */
	private void heapDownNonRecurse(int ix) {

		int currentIx = ix;
		
		while(true) {
			QueueEntry<T> currentEntry = data.get(currentIx);
			int leftChildIx = 2 * currentIx + 1;
			int rightChildIx = 2 * currentIx + 2;

			if(leftChildIx >= data.size()) {
				// This means there are no children for the node (left node always gets added first so if there's no
				// left then there is no right)
				break;
			}

			int largestChildIx = getLargerNodeIx(leftChildIx, rightChildIx);
			QueueEntry<T> largestChildEntry = data.get(largestChildIx);

			if(currentEntry.priority.nValue >= largestChildEntry.priority.nValue) {
				break;
			}

			swap(currentIx, largestChildIx);
			currentIx = largestChildIx;
		}
	}

	/**
	 * Returns the index of the node that has the larger priority. 
	 * 
	 * @param ix0 the index of the first node
	 * @param ix1 the index of the second node
	 * @return the index (either ix0 or ix1) of the node that has the higher data.get(ix).priority
	 */
	private int getLargerNodeIx(int ix0, int ix1) {

		QueueEntry<T> entry0 = data.get(ix0);

		if(ix1 < data.size()) {
			// If we have a right child and the right is greater than the left...
			QueueEntry<T> entry1 = data.get(ix1);

			if(entry1.priority.nValue > entry0.priority.nValue) {
				return ix1;
			}
		}

		return ix0;
	}

	private void swap(int ixA, int ixB) {

		QueueEntry<T> tmp = data.get(ixA);
		data.set(ixA, data.get(ixB));
		data.set(ixB, tmp);
	}
}
