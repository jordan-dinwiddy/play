package cx.ath.nb12.stack;

public class GenericStack<T> {
	private Node listHead;
	private int size;
	
	public GenericStack()
	{
		this.size = 0;
	}
	
	public void push( T item )
	{
		Node newNode = new Node( item, listHead );
		listHead = newNode;
		size++;
	}
	
	public T pop() throws Exception
	{
		if( size == 0 )
			throw new Exception( "Stack is empty" );
		
		Node n = listHead;
		listHead = n.getNext();
		size--;
		return n.getValue();
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return ( getSize() == 0 );
	}
	
	private class Node
	{
		private T value;
		private Node next;
		
		public Node( T value, Node next )
		{
			this.value = value;
			this.next = next;
		}
		
		public T getValue()
		{
			return value;
		}
		
		public Node getNext()
		{
			return next;
		}
	}
}
