package diningphilosophers;

public class DiningPhilosophers {

	private Object[] forks;
	private Philosopher[] philosophers;
	private int[] stats;
	
	private DiningPhilosophers( int num )
	{
		forks = new Object[ num ];
		
		philosophers = new Philosopher[ num ];
		stats = new int[num];
		
		for( int i = 0; i < num; ++i )
		{
			forks[i] = new Object();
			stats[i] = 0;
			int fork1 = i;
			int fork2 = ( i + 1 ) % num;
			
		
				philosophers[i] = new Philosopher( i, fork1, fork2 );
		}
	}
	
	public void startEating() throws InterruptedException 
	{
		for( int i = 0; i < philosophers.length; ++i )
		{
			philosophers[i].start();
		}
		
		Thread.sleep( 10000 );
		for( int i = 0; i < philosophers.length; i++ )
		{
			System.out.printf( "philosopher %d ate %d times\n", i, stats[ i ] );
		}
		System.exit( 0 );
	}
	
	public static void main( String[] args )
	{
		try
		{
			DiningPhilosophers d = new DiningPhilosophers( 6 );
			d.startEating();
		}
		catch( InterruptedException e )
		{
			
		}
	}
	
	private class Philosopher extends Thread {
		private int id;
		private int fork1;
		private int fork2;
		
		public Philosopher( int id, int fork1, int fork2 )
		{
			this.id = id;
			this.fork1 = fork1;
			this.fork2 = fork2;
		}
		
		public void run() 
		{
			status( String.format( "Read to eat using forks %d and %d", fork1, fork2 ) );
			
			pause();
			
			while( true )
			{
				status( "Picking up fork " + fork1 );
				synchronized( forks[ fork1 ] )
				{
					status( "Picking up fork " + fork2 );
					synchronized( forks[ fork2 ] )
					{
						status( "Eating" );
						stats[ id ]++;
					}
				}
			}
		}
		
		private void status( String msg )
		{
			System.out.printf( "Philosopher %d: %s\n", id, msg );
		}
		
		private void pause() 
		{

		}
	}
}
