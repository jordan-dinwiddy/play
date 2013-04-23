package cx.ath.nb12.threading;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	private int i = 0;
	
	private static class MyCallable<V> implements Callable<V>
	{
		private V myV;
		
		public MyCallable( V myV )
		{
			this.myV = myV;
		}
		
		@Override
		public V call() throws Exception {
			try
			{
				Thread.sleep( 2000 );
				
			}
			catch( Exception e )
			{
				
			}
			
			return myV;
			
		}
	}
	
	public static void main( String[] args )
	{
		ExecutorService pool = Executors.newFixedThreadPool( 3 );
		String[] myWords = {"Jordan", "James", "Dinwiddy", "Kelly", "Dinwiddy" };
		List<Future<String>> myfuts = new ArrayList<Future<String>>();
		int k;
	
		for( String w : myWords )
		{
			// this is using the inner class above but i wanted to try this. 
			//Callable<String> c = new MyCallable<String>(w);
	
			// i wanted to play with my anonymous class. 
			Future<String> f = pool.submit(new Callable<String>()
					{
						public String call() throws Exception
						{
							try { Thread.sleep(1000); } catch(Exception e) {}
							return "Jordan James" + k++;
							
						}
					});
			
			
			myfuts.add(f);
		}
		
		for(Future<String> f : myfuts)
		{
			try
			{
				System.out.println(f.get());
			}
			catch(Exception e)
			{
				
			}
		}
		
		pool.shutdown();
		
	}
}
