package cx.ath.nb12.trees;

public class Driver {

	public static void main(String args[]) {
		
		Driver d = new Driver();
		d.doBstLookupExample();
		d.doMinValueExample();
		d.doTraverseExample();
		d.doPreOrderExample();
		d.doPrintExample();
	}
	
	private void doPrintExample() {
		
		System.out.println("Print: ");
		Node root = BSTUtil.buildExampleBST();
		
		BSTUtil.printTreeSingleQueue(root);
		BSTUtil.printTreeSingleQueue(root);
	}

	private void doPreOrderExample() {
		
		Node root = BSTUtil.buildExampleBST();
		
		System.out.print("Pre-Order (recursive): ");
		BSTUtil.TraversePreOrder(root);
		System.out.println();
		
		System.out.print("Pre-Order (no recurse): ");
		BSTUtil.TraversePreOrderNoRecurse(root);
		System.out.println();
	}
	
	private void doTraverseExample() {
		
		Node root = BSTUtil.buildExampleBST();
		
		System.out.print("Pre-order: ");
		BSTUtil.TraversePreOrder(root);
		System.out.println();
		
		System.out.print("In-order: ");
		BSTUtil.TraverseInOrder(root);
		System.out.println();
		
		System.out.print("Post-order: ");
		BSTUtil.TraversePostOrder(root);
		System.out.println();
	}
	
	private void doBstLookupExample() {
		
		Node root = BSTUtil.buildExampleBST();
		
		verboseLookup(root, 8);
		verboseLookup(root, 12);
		verboseLookup(root, 2);
		verboseLookup(root, 3);
	}
	
	private void doMinValueExample() {
		try  {
			Node root = BSTUtil.buildExampleBST();
			int minVal = BSTUtil.min(root);
			
			System.out.println("Smallest value in BST: " + minVal);
		}
		catch(Exception e) { System.out.println(e); }
	}
	
	private void verboseLookup(Node root, int val) {
		
		String result = (BSTUtil.lookup(root, val) == null) ? "Not Found" : "Found";
		
		System.out.printf("Looking up %d in tree at %s: %s\n", val, root, result);
	}
}
