package cx.ath.nb12.linkedlist;

public class MyLinkedList {

	public class Item
	{
		private String value;
		private Item next;
		
		public Item( String value, Item next )
		{
			this.value = value;
			this.next = next;
		}
		
		public void setNext( Item next )
		{
			this.next = next;
		}
		
		public Item getNext()
		{
			return this.next;
		}
		
		public String getValue()
		{
			return this.value;
		}
		
		public void setValue( String value )
		{
			this.value = value;
		}
		
		public String toString()
		{
			return this.value;
		}
	}
	
	private Item headPtr;
	
	public void add( String s )
	{
		Item i = new Item( s, this.headPtr );
		headPtr = i;
	}
	
	public boolean remove( String s )
	{
		Item next = headPtr;
		Item prev = null;
		while( next != null )
		{
			if( next.getValue().equals( s ) )
			{
				// this is the guy to remove
				if( prev == null )
					headPtr = next.getNext();
				else
					prev.setNext( next.getNext() );
				
				return true;
			}
			
			prev = next;
			next = next.getNext();
		}
		
		return false;
	}
	
	public void print()
	{
		Item i = headPtr;
		while( i != null )
		{
			System.out.println( i.getValue() );
			i = i.getNext();
		}
	}
	
	public static void main( String[] args )
	{
		MyLinkedList ml = new MyLinkedList();
		ml.add( "Jordan" );
		ml.add( "James" );
		ml.add( "Dinwiddy" );
		ml.add( "Sarah" );
		ml.add( "Rachel" );
		ml.add( "Schuman" );
		ml.add( "Dinwiddy" );
		
		ml.remove( "Dinwiddy" );
		ml.remove( "Dinwiddy" );
		ml.remove( "James" );
		
		ml.print();
	}
	
}
