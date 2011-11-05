package cx.ath.nb12;

public class PauseThread {

	public static void main( String[] args )
	{
		MyThread t = new MyThread();
		t.setDaemon( true );
		t.start();
		
		try { Thread.sleep( 2000 ); } catch( Exception e ) {};
		t.pause();
		
		try { Thread.sleep( 2000 ); } catch( Exception e ) {};
		t.unpause();
		
		try { Thread.sleep( 2000 ); } catch( Exception e ) {};
		t.pause();
		
		
		try { Thread.sleep( 2000 ); } catch( Exception e ) {};
		System.out.println( "Terminating.." );
		
		
		
	}
	
	private static class MyThread extends Thread
	{
		private boolean paused = false;
		
		public void run()
		{
			while( true )
			{
				// Note the 'paused' variable is shared resource so we should have
				// the monitor around this. because otherwise what happens
				// if we enter the below and see we are paused. then before
				// we get to the wait() the unpause() is called and notifyAll
				// is sent. then we would be in deadlock. 
//				synchronized( this )
//				{
//					while( paused ) 
//						try { wait(); } catch( Exception e ) {};
//				};
//				
				// only problem i see doing this way is if we enter the block
				// of the while loop below, then unpause gets called and 
				// the interrupt happens, then we will sleep for unnecessary
				// amount of time. but to fix all we have to do is keep the
				// pause time down. 
					while( paused ) 
						try { Thread.sleep(5000); } catch( Exception e ) {};
		
				System.out.println( "I'm not paused!!" );
				try { Thread.sleep( 500 ); } catch( Exception e ) {};
			}
		}
		
//		public synchronized void pause()
//		{
//			System.out.println( "Pausing..." );
//			this.paused = true;
//		}
		
		public void pause()
		{
			System.out.println( "Pausing..." );
			this.paused = true;
		}
		
//		public synchronized void unpause()
//		{
//			System.out.println( "Unpausing..." );
//			this.paused = false;
//			notifyAll();
//		}
		
		public  void unpause()
		{
			System.out.println( "Unpausing..." );
			this.paused = false;
			this.interrupt();
		}
	}
}
