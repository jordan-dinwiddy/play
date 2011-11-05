package cx.ath.nb12.trees;

public class Node {
	private int val;
	private Node left;
	private Node right;
	
	public Node( Node left, Node right, int val )
	{
		this.val = val;
		this.right = right;
		this.left = left;
	}
	
	public int getVal()
	{
		return val;
	}
	
	public Node getLeft() 
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setVal( int val )
	{
		this.val = val;
	}
	
	public void setLeft( Node left )
	{
		this.left = left;
	}
	
	public void setRight( Node right )
	{
		this.right = right;
	}

}
