package cx.ath.nb12;

public class Stack {
	
	private String[] buf;
	private int stackPtr;
	private final int STACK_DEFAULT_SIZE = 64;
	
	public Stack( int stackSize )
	{
		this.init( stackSize );
	}
	
	public Stack()
	{
		this.init( STACK_DEFAULT_SIZE );
	}
	
	private void init( int stackSize )
	{
		buf = new String[ stackSize ];
		stackPtr = stackSize;
	}
	
	public void push( String s ) throws Exception
	{
		if( stackPtr-- < 1 )
			throw new Exception( "Stack overflow" );
		
		buf[ stackPtr ] = s;
		
		System.out.print( String.format( "Pushed %s. Size is now %d\n", s, this.getSize() ) );
	}
	
	public String pop() throws Exception
	{
		if( stackPtr >= buf.length )
			throw new Exception( "Stack empty" );
		
		String retVal = buf[ stackPtr++ ];
		
		System.out.print( String.format( "Popped %s. Size is now %d\n", retVal, this.getSize() ) );
		
		return retVal;
	}
	
	public int getSize() 
	{
		return buf.length - stackPtr;
	}

}
