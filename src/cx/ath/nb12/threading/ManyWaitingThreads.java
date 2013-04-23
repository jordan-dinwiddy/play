package cx.ath.nb12.threading;

public class ManyWaitingThreads {

	public static void main( String[] args )
	{
		Object lockObject = new Object();
		
		for( int i = 0; i < 10; i++ )
		{
			Thread t = new Thread( new TheTask( i, lockObject ) );
			t.start();
		}
	}
}
