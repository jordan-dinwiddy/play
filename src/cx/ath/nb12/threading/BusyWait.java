package cx.ath.nb12.threading;

public class BusyWait {

	public static void main( String[] args )
	{
		//doBusyWait();
		useMonitors();
		
	}
	
	private static void doBusyWait()
	{
		Thread t = new Thread( new TheTask( 1 ) );
		t.start();
		
		System.out.println( "Thread is running, waiting..." );
		while( t.isAlive() )
		;
		
		System.out.println( "Thread finished, exiting..." );
		
	}
	
	private static void useMonitors()
	{
		Runnable r = new TheTask( 1 );
		Thread t = new Thread( r );
		System.out.println( "Thread is running..." );
		
		synchronized( r )
		{
			t.start();
			try { Thread.sleep( 2000 ); } catch( Exception e ) {}
			try 
			{
				System.out.println( "Sticking the wait on" );
				r.wait();
				System.out.println( "wait released" );
			}
			catch( InterruptedException e ) {}
		} // end of synchronise statement unleases the lock and continues thread.
		  // o.wait() unleases the lock BUT pauses the thread until there is a notify. 
		
		System.out.println( "Done" );
	}
}


