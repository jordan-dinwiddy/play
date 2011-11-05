package cx.ath.nb12.trees;

import cx.ath.nb12.GenericStack;

public class BSTUtil {

	public static Node lookup( Node root, int val )
	{
		Node currentNode = root;		// don't really need the extra var
		while( currentNode != null )
		{
			if( currentNode.getVal() == val ) break;
			if( currentNode.getVal() > val )
				currentNode = currentNode.getLeft();
			else 
				currentNode = currentNode.getRight();
		}
		
		return currentNode;
	}
	
	public static void TraversePreOrder( Node root )
	{
		if( root == null ) return;
		System.out.print( root.getVal() + " " );
		TraversePreOrder( root.getLeft() );
		TraversePreOrder( root.getRight() );
	}
	
	public static void TraverseInOrder( Node root )
	{
		if( root == null ) return;
		TraverseInOrder( root.getLeft() );
		System.out.print( root.getVal() + " " );
		TraverseInOrder( root.getRight() );
	}
	
	public static void TraversePostOrder( Node root )
	{
		if( root == null ) return;
		TraversePostOrder( root.getLeft() );
		TraversePostOrder( root.getRight() );
		System.out.print( root.getVal() + " " );
	}
	
	public static void TraversePreOrderNoRecurse( Node root )
	{
		GenericStack<Node> stack = new GenericStack<Node>();
		stack.push( root );
		
		try 
		{
			while( !stack.isEmpty() )
			{
				Node n = stack.pop();
				System.out.print( n.getVal() + " " );
				
				if( n.getRight() != null )
					stack.push( n.getRight() );
				if( n.getLeft() != null )
					stack.push( n.getLeft() );
			}
		}
		catch( Exception e )
		{
			// stack empty error wont happen in this algo. safe to ignore.
		}
	}
	
	public static int min( Node root ) throws Exception
	{
		if( root == null )
			throw new Exception( "No tree specified" );
		
		while( root.getLeft() != null )
			root = root.getLeft();
		
		return root.getVal();
	}
	
	public static boolean add( Node root, Node newNode )
	{
		if( root == null ) return false;
		
		/**
		 * note: looks like there is a small bug in this. Once we setLeft or setRight
		 * we can actually break from the loop. But we never do. So instead we make a further
		 * 2 unecessary iterations. 
		 */
		while( root != null )
		{
			// Don't wanna dup anything 
			if( root.getVal() == newNode.getVal() ) 
				return false;
		
			if( root.getVal() > newNode.getVal() )
			{
				if( root.getLeft() == null )
					root.setLeft( newNode );
				else
					root = root.getLeft();
			}
			else
			{
				if( root.getRight() == null )
					root.setRight( newNode );
				else
					root = root.getRight();
			}
		}
		
		return true;
	}
	
	public static boolean add( Node root, int val )
	{
		Node newNode = new Node( null, null, val );
		return BSTUtil.add( root, newNode );
	}
				
	public static Node buildExampleBST()
	{
//		Node n1 = new Node( null, null, 2 );
//		Node n2 = new Node( n1, null, 7 );
//		Node n3 = new Node( null, null, 9 );
//		Node n4 = new Node( n2, n3, 8 );
//		Node n5 = new Node( null, null, 12 );
//		Node n6 = new Node( null, null, 99 );
//		Node n7 = new Node( n5, n6, 23 );
//		Node n8 = new Node( n4, n7, 10 );
		
		//int[] newNodeVals = {8, -99, 23, 7, 9, 12, 99, 2, -1};
		int[] newNodeVals = {50, 25, 75, 150, 125, 175, 110 };
		Node root = new Node( null, null, 100 );
		for( int newVal : newNodeVals )
			BSTUtil.add(root, newVal);
			
		return root;
	}
}
