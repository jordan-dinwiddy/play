package cx.ath.nb12.producerconsumer;

public class Consumer extends Thread {
	private IntBuffer buffer;
	
	public Consumer( IntBuffer buffer )
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		while( true )
		{
			int n = buffer.remove();
			System.out.printf( "Consumed %d\n", n );
			
		}
	}
}
