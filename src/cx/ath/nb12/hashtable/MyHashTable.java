package cx.ath.nb12.hashtable;

public class MyHashTable {

	private Value[] table;
	
	public class Value
	{
		private String key;
		private String value;
		private Value next;
		
		public Value( String key, String value )
		{
			this.key = key;
			this.value = value;
		}
		
		public String getKey()
		{
			return this.key;
		}
		
		public String getValue()
		{
			return this.value;
		}
		
		public int hashCode()
		{
			return this.key.hashCode();
		}
		
		public Value getNext()
		{
			return this.next;
		}
		
		public void setNext( Value next )
		{
			this.next = next;
		}
	}
	
	public MyHashTable()
	{
		this( 100 );
	}
	
	private int hash( String s )
	{
		int hash = s.hashCode();
		if( hash < 0 ) hash = -hash;
		
		return hash % this.table.length;
	}
	
	public MyHashTable( int size )
	{
		this.table = new Value[ size ];
	}
	
	public String lookup( String key )
	{
		int ix = hash( key );
		Value a = this.table[ ix ];
		
		while( a != null )
		{
			if( a.getKey().equals( key ) )
				return a.getValue();
			a = a.getNext();
		}
		 
		return null;
	}
	
	public boolean insert( String key, String value )
	{
		
		if( lookup( key ) != null )
		{
			System.out.println( String.format( "Failed to insert %s", key ) );
			return false;
		}
		
		Value v = new Value( key, value );
		int ix = hash( v.getKey() );
		v.setNext( this.table[ ix ] );
		this.table[ ix ] = v;
		
		System.out.println( String.format( "%s=%s inserted at index %d", key, value, ix ) );
		
		return true;
	}
	
	public void print()
	{
		for( int i = 0; i < this.table.length; i++ )
		{
			System.out.print( String.format( "table[%d]=", i ) );
			Value v = this.table[ i ];
			while( v != null )
			{
				System.out.print( v.getValue() + " " );
				v = v.getNext();
			}
			System.out.println();
		}
	}
	
	public static void main( String[] args )
	{
		MyHashTable ht = new MyHashTable( 10 );
		ht.insert( "Jordan", "ja" );
		ht.insert( "Sarah", "sa" );
		ht.insert( "Kelly", "ka" );
		ht.insert( "Lindy", "la" );
		ht.insert( "Rona", "ra" );
		ht.insert( "Roger", "ra" );
		ht.insert( "Jordan", "jb" );
		
		ht.print();
		
	}
	
	
	
}
