package cx.ath.nb12.NotifyNotifyAll;

public class Driver {

	public static void main( String[] args ) 
	{

		
	
		ThreadSafeObject o = new ThreadSafeObject();
		// launch some threads. 
		for( int i = 0; i < 10; i++ ) 
		{
			Thread t = new Thread( o );
			t.start();
		}
		System.out.println( "All threads launched" );
		
		// sleep is important to allow each thread to get to the wait() stage.
		// if we call notifyAll before every thread is at wait() then some
		// threads will be live forever. 
		try{ Thread.sleep( 1000 ); } catch( Exception e ) {};
		
		synchronized( o )
		{	
			
			// we should at this point (after the sleep - IMPORTANT) have 10 threads 
			// in the 'im not interested state'. we use notify.. to put them back in the
			// i am intersted state. at which point they will get scheduled once
			// we release lock o. 
			// notify we trigger 1 thread to go. notifyAll will trigger them all. 
			o.notifyAll();
		}
		
		System.out.println( "I'm done... bye" );
	}
}
