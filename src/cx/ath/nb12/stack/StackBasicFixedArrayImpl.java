package cx.ath.nb12.stack;

public class StackBasicFixedArrayImpl implements Stack {
	
	private String[] buf;
	private int stackPtr;
	private final int STACK_DEFAULT_SIZE = 64;
	
	public StackBasicFixedArrayImpl( int stackSize )
	{
		this.init( stackSize );
	}
	
	public StackBasicFixedArrayImpl()
	{
		this.init( STACK_DEFAULT_SIZE );
	}
	
	private void init( int stackSize )
	{
		buf = new String[ stackSize ];
		stackPtr = stackSize;
	}
	
	/* (non-Javadoc)
	 * @see cx.ath.nb12.stack.Stack#push(java.lang.String)
	 */
	@Override
	public void push( String s ) throws Exception
	{
		if( stackPtr-- < 1 )
			throw new Exception( "Stack overflow" );
		
		buf[ stackPtr ] = s;
		
		System.out.print( String.format( "Pushed %s. Size is now %d\n", s, this.getSize() ) );
	}
	
	/* (non-Javadoc)
	 * @see cx.ath.nb12.stack.Stack#pop()
	 */
	@Override
	public String pop() throws Exception
	{
		if( stackPtr >= buf.length )
			throw new Exception( "Stack empty" );
		
		String retVal = buf[ stackPtr++ ];
		
		System.out.print( String.format( "Popped %s. Size is now %d\n", retVal, this.getSize() ) );
		
		return retVal;
	}
	
	/* (non-Javadoc)
	 * @see cx.ath.nb12.stack.Stack#getSize()
	 */
	@Override
	public int getSize() 
	{
		return buf.length - stackPtr;
	}

}
