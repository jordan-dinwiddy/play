import java.util.ArrayList;


public class MySet {

	private ArrayList<String>[] table;
	
	public MySet( int size )
	{
		this.table = new ArrayList[ size ];
	}
	
	public MySet()
	{
		this( 100 );
	}
	
	public boolean add( String s )
	{
		int ix = hash( s );
		
		if( table[ ix ] == null )
			table[ ix ] = new ArrayList<String>();
		
		if( table[ ix ].contains( s ) )
			return false;
		
		table[ ix ].add( s );
		
		System.out.println( String.format( "Inserted %s into ix %d", s, ix ) ); 
		return true;
	}
	
	public boolean contains( String s )
	{
		int ix = hash( s );
		
		if( table[ ix ] == null ) 
			return false;
		
		return table[ ix ].contains( s );
	}
	
	private int hash( String s )
	{
		int hashCode = s.hashCode();
		if( hashCode < 0 ) hashCode = -hashCode;
		
		return hashCode % table.length;
	}
	
	public void print()
	{
		for( ArrayList<String> list : this.table )
		{
			if( list == null ) continue;
			
			for( String item : list )
				System.out.println( item );
		}
	}
	
	public static void main( String[] args )
	{
		MySet ms = new MySet( 10 );
		ms.add( "Jordan " );
		ms.add( "Dinwiddy" );
		ms.add( "Kelly" );
		ms.add( "Dinwiddy" );
		ms.add( "Foo" );
		ms.add( "Bar" );
		ms.print();
	}
	
}
