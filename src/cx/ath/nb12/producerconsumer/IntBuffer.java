package cx.ath.nb12.producerconsumer;

public class IntBuffer {
	private int index;
	private int[] buffer = new int[8];
	
	public synchronized void add( int n )
	{
		while( index == ( buffer.length - 1 ) )
		{
			System.out.println( "Waiting for space..." );
			try 
			{
				wait();
			}
			catch( InterruptedException e )
			{
				
			}
		}
		
		buffer[index++] = n;
		notifyAll();
	}
	
	public synchronized int remove()
	{
		while( index == 0 )
		{
			try
			{
				wait();
			}
			catch( InterruptedException e )
			{
				
			}
		}
		
		int ret = buffer[--index];
		notifyAll();
		return ret;
	}
}
