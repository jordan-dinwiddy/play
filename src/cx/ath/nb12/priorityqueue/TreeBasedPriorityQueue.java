package cx.ath.nb12.priorityqueue;

import java.util.LinkedList;
import java.util.Queue;

import cx.ath.nb12.blockingqueue.CustomQueue;

public class TreeBasedPriorityQueue<T> implements CustomQueue<T> {

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

	/**
	 * Hmmm not quite as easy as I thought. I know how to add elements to the tree in order.
	 * But it's tricky for me to get the last item in the tree and replace it at the root
	 * of the tree (during a dequeue operation). 
	 * 
	 * Maybe just a BFS ? Which I think uses a queue. 

	 */
	private static class TreeNode<T> {
		
		private T item;
		private Priority priority;
		private TreeNode<T> parent;
		private TreeNode<T> left;
		private TreeNode<T> right;
		private boolean available=true;
		
		private TreeNode(T item, Priority priority) {
			this.item = item;
			this.priority = priority;
		}
	}
	
	private TreeNode<T> rootTreeNode;
	private Queue<TreeNode<T>> insertionQueue = new LinkedList<TreeNode<T>>();
	
	/**
	 * This guy uses a queue to maintain a complete tree. 
	 * 
	 * @param node
	 */
	private void insertNodeAtEndOfTree(TreeNode<T> node) {
		
		if(rootTreeNode == null) {
			insertionQueue.offer(node);
			rootTreeNode = node;
			return;
		}
		
		boolean inserted = false;
		while(!inserted) {
			TreeNode<T> lastNodeCandidate = insertionQueue.peek();
			
			if(!lastNodeCandidate.available) {
				insertionQueue.poll();
				continue;
			}
			
			if(lastNodeCandidate.left == null) {
				lastNodeCandidate.left = node;
				node.parent = lastNodeCandidate;
				inserted = true;
			} else if(lastNodeCandidate.right == null) {
				lastNodeCandidate.right = node;
				node.parent = lastNodeCandidate;
				inserted = true;
			} else {
				insertionQueue.poll();
			}
		}
		
		insertionQueue.offer(node);
	}
	
	@Override
	public void enqueue(T item) {
		
		enqueue(item, Priority.LOW);
		
	}

	private void enqueue(T item, Priority priority) {
		
		TreeNode<T> newNode = new TreeNode<T>(item, priority);
		insertNodeAtEndOfTree(newNode);
		
		heapUp(newNode);
	}

	private void heapUp(TreeNode<T> thisNode) {
		
		// Move the node up the tree until heap condition (thisNode.priority < thisNode.parent.priority)
		while(thisNode.parent != null && thisNode.priority.nValue > thisNode.parent.priority.nValue) {
			swapTreeNodeValues(thisNode, thisNode.parent);
		}
	}
	
	private void heapDown(TreeNode<T> thisNode) {
		
	}

	private void swapTreeNodeValues(TreeNode<T> nodeA, TreeNode<T> nodeB) {
		
	//		TreeNode<T> tmpParent = nodeA.parent;
	//		TreeNode<T> tmpLeft = nodeA.left;
	//		TreeNode<T> tmpRight = nodeA.right; 
	//		
	//		nodeA.parent = nodeB.parent;
	//		nodeA.left = nodeB.left;
	//		nodeA.right = nodeB.right; 
	//		
	//		nodeB.parent = tmpParent;
	//		nodeB.left = tmpLeft;
	//		nodeB.right = tmpRight;
		
		
		// Moved just the values
		T tmpItem = nodeA.item; 
		Priority tmpPriority = nodeA.priority;
		
		nodeA.item = nodeB.item;
		nodeA.priority = nodeB.priority;
		
		nodeB.item = tmpItem;
		nodeB.priority = tmpPriority;
	}

	@Override
	public T dequeue() {
		
		// Take item from top of tree, take last item from tree and add to top. 
		// Do heap down
		TreeNode<T> topNode = rootTreeNode; 
		
		//srootTreeNode = // last item
		// TODO Auto-generated method stub
		return null;
	}
}
