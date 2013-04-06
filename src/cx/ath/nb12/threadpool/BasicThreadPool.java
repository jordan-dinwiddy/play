package cx.ath.nb12.threadpool;

import cx.ath.nb12.BlockingQueue;
import cx.ath.nb12.Logger;

/**
 * A basic thread pool implementation that immediately launches numExecutors
 * worker threads that dequeue jobs off of a blocking queue, execute and then
 * attempt to dequeue again. 
 * 
 * The blocking queue has no limit in size and therefore the submit() method
 * should never block.
 * 
 */
public class BasicThreadPool {

	private int numExecutors; 
	private BlockingQueue<Runnable> blockingQueue; 
	private ThreadPoolMember[] executors;
	
	public BasicThreadPool(int numExecutors) {
		
		Logger.log("Creating basic thread pool with numExecutors=" + numExecutors);
		this.numExecutors = numExecutors;
		this.blockingQueue = new BlockingQueue<Runnable>();
		this.executors = new ThreadPoolMember[numExecutors];
	}
	
	public void start() {
		
		Logger.log("Staring basic thread pool with " + numExecutors + " executing threads...");
		for(int i = 0; i < numExecutors; i++) {
			executors[i] = new ThreadPoolMember("ThreadPoolMember" + i);
			executors[i].start();
		}
	}
	
	public void submit(Runnable job) {
		
		blockingQueue.enqueue(job);
	}
	
	/**
	 * The worker thread.
	 */
	private class ThreadPoolMember implements Runnable {

		private String memberName; 
		private Thread thisThread;
		private int jobsCompleted = 0;
		
		private ThreadPoolMember(String memberName) {
			
			this.memberName = memberName; 
		}
		
		private void start() {
			
			thisThread = new Thread(this, memberName);
			thisThread.start();
		}
		
		@Override
		public void run() {
			
			while(true) {
				Runnable job = blockingQueue.dequeue();
				
				Logger.log(Thread.currentThread().getName() + ": Running my " + (jobsCompleted+1) + "'th job...");
				job.run();
				jobsCompleted++;
			}
		}
	}
}
