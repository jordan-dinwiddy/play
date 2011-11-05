package cx.ath.nb12;

public class Shell {

	public static void main( String[] args )
	{
		Object o = new Object();
		
		synchronized( o )
		{
		for( int i = 0; i < 100; i++ )
		{
			Thread t = new Thread( new SpecialTask( i, o ) );
			t.start();
		}
		
		System.out.println( "About to notify" );
		try{ Thread.sleep( 2000 ); } catch( Exception e ) { };
		System.out.println( "Notifying..." );
		o.notify();
		System.out.println( "Notifying done" );
		};
	}
}
