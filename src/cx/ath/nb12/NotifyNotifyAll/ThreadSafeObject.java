package cx.ath.nb12.NotifyNotifyAll;

public class ThreadSafeObject implements Runnable {

	public void run() 
	{
		this.sayHello();
	}
	
	public synchronized void sayHello()
	{
		System.out.printf( "Thread %s: waiting\n", Thread.currentThread().getName() );
		try{ wait(); } catch( Exception e ) {};
		System.out.printf( "Thread %s: Hello!\n", Thread.currentThread().getName() );
	}
}
