package cx.ath.nb12.priorityqueue;

public class TreeBasedPriorityQueue<T> implements Queue<T> {

	/**
	 * Generally, the array based approach is easier and more efficient because the use of an 
	 * array naturally and implicitly keeps track of the insertion point of the heap. This
	 * also allows us to keep a 'complete binary tree' (a tree where all levels apart from maybe the 
	 * last are complete). This is important because when we insert/delete new items into the heap
	 * we insert/delete the element to the left most available leaf on the final level of the tree
	 * - that's just how our heap works. 
	 * 
	 * The trick for the tree based implementation is to use a queue that allows us to keep track
	 * of available (non full) nodes on the final few levels of the tree. We basically peak on 
	 * insertion, if the peaked node has an available leaf spot we insert. Otherwise we dequeue
	 * that node and move onto the next until we find an available space. In both cases we enqueue
	 * the new node.
	 */

	@Override
	public void enqueue(T item) {
		// TODO Auto-generated method stub

	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
}
