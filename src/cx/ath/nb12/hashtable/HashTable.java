package cx.ath.nb12.hashtable;

public class HashTable<T,U> {
	private final int HASH_TABLE_SIZE = 21;
	private Node[] table;
	
	public HashTable()
	{
		table = new Node[ HASH_TABLE_SIZE ];
	}
	
	private int hash( T key )
	{
		int hash = key.hashCode();
		if( hash < 0 ) hash = -hash;
		
		return hash % this.table.length;
	}
	
	public boolean insert( T key, U value )
	{
		int ix = hash( key );
		Node currentNode = table[ ix ];
		
		while( currentNode != null )
		{
			if( value.equals( currentNode.getValue() ) )
				return false;
			else
				currentNode = currentNode.getNext();
		}
		
		//
	}
	
	public U lookup( T key )
	{
		int ix = hash( key );
		Node currentNode = table[ ix ];
		
		while( currentNode != null )
		{
			if( key.equals( currentNode.getKey() ) )
				return false;
			else
				currentNode = currentNode.getNext();
		}
	}
}
