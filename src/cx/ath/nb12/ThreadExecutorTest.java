package cx.ath.nb12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorTest {

	public static void main( String[] args )
	{
		ExecutorService exec = Executors.newFixedThreadPool( 2 );
		for( int i = 0; i < 10; i++ )
			exec.execute( new TheTask( i ) );
	}
}
