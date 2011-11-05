package cx.ath.nb12;

public class SpecialTask implements Runnable {

	private int id;
	private Object lock;
	
	public SpecialTask( int id, Object lock )
	{
		this.id = id;
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println( "Waiting..." );
		synchronized( lock )
		{
			System.out.printf( "This is thread %d saying hello\n", id );
		}
	}
	
	
}
