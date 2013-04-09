package cx.ath.nb12.threadpool;

import cx.ath.nb12.blockingqueue.BlockingQueue;
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
	
	/**
	 * Prompts each thread executor to finish it's current task and then exit. If the executors 
	 * current task is long running, then it will take some time for the pool to 'shutdown'.
	 * 
	 * This call does not block.
	 */
	public void softStop() {
		
		for(ThreadPoolMember executor : executors) {
			executor.softStop();
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
		private boolean running = false;
		
		private ThreadPoolMember(String memberName) {
			
			this.memberName = memberName; 
		}
		
		private void start() {
			
			running = true;
			thisThread = new Thread(this, memberName);
			thisThread.start();
		}
		
		private void softStop() {
			
			running = false;
		}
		
		@Override
		public void run() {
			
			while(running) {
				Runnable job = blockingQueue.dequeue();
				
				Logger.log(Thread.currentThread().getName() + ": Running my " + (jobsCompleted+1) + "'th job...");
				job.run();
				jobsCompleted++;
			}
			
			Logger.log(Thread.currentThread().getName() + ": Exiting");
		}
	}
}
