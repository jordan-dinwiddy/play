package cx.ath.nb12;

public class TheTask implements Runnable
{
	private int id;
	private Object theLock;
	
	public TheTask( int id ) 
	{
		this.id = id;
	}
	
	public TheTask( int id, Object theLock )
	{
		this.id = id;
		this.theLock = theLock;
	}
	
	@Override
	public void run() {
		System.out.println( "In run..." );
		Object lockObject = ( theLock != null ) ? theLock : this;
		
		synchronized( lockObject )
		{
			System.out.println( "I'm in!" );
			for( int i = 0; i < 5; i++ )
			{
				System.out.printf( "Thread %d on cycle %d\n", this.id, i );
				try {
					Thread.sleep( 1000 );
				}
				catch( InterruptedException e ) { }
			}
		
			lockObject.notifyAll(); // you need the notify to notify processes that are
									// waiting. simply release the monitor/lock will not do
			System.out.println(" I've notified everyone" );
		}
	}
}