package cx.ath.nb12;

public class BlockingQueueDemo {

	public static class ConsumerThread implements Runnable {
		
		private BlockingQueue<String> bq;
		private String consumerName; 
		
		public ConsumerThread(String consumerName, BlockingQueue<String> bq) {
			this.bq = bq;
			this.consumerName = consumerName;
		}

		@Override
		public void run() {
			while(true) {
				String data = bq.dequeue();
				System.out.println(this.consumerName + ": consumed " + data);
			}
		}
		
		public void start() {
			new Thread(this).start();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new BlockingQueueDemo().run();
	}
	
	public void run() throws InterruptedException {
		
		BlockingQueue<String> bq = new BlockingQueue<String>(50);
		
		for(int i = 0; i < 10; i++) {
			new ConsumerThread("Thread" + i, bq).start();
		}
		
		System.out.println("Sleeping for a bit...");
		Thread.sleep(2000);
		
		for(int i = 0; i < 100; i++) {
			bq.enqueue("Item " + i);
		}
	}
}
