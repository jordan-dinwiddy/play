package cx.ath.nb12.threadpool;

import java.util.Random;

import cx.ath.nb12.Logger;

/**
 * Just demo's a really basic thread pool implementation. 
 *
 */
public class BasicThreadPoolDemo {

	private final int NUM_EXECUTORS = 10;
	private Random ranGen;
	
	public static void main(String[] args) {
		
		new BasicThreadPoolDemo().run(1000);
	}
	
	public BasicThreadPoolDemo() {
		
		this.ranGen = new Random();
	}
	
	public void run(int numJobs) {
		
		BasicThreadPool pool = new BasicThreadPool(NUM_EXECUTORS); 
		
		Runnable job = getJob();
		
		Logger.log("Submitting " + numJobs + " jobs to thread pool...");
		for(int i = 0; i < numJobs; i++) {
			pool.submit(job);
		}
		
		Logger.log("Starting thread pool...");
		pool.start();
		
		Logger.log("Main thread sleeping.");
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch(InterruptedException e) {
			
		}
	}

	private Runnable getJob() {
		
		Runnable job = new Runnable() {
			
			@Override
			public void run() {
				
				// Expensive work goes on here...
				
				try {
					Thread.sleep(ranGen.nextInt(1000));
				} catch(InterruptedException e) {
					
				}
			}
		};
		
		return job;
	}
}
