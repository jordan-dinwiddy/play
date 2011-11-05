package cx.ath.nb12.producerconsumer;

import java.util.Random;

public class Producer extends Thread {
		private IntBuffer buffer;
		
		public Producer( IntBuffer buffer )
		{
			this.buffer = buffer;
		}
		
		public void run()
		{
			Random r = new Random();
			while( true )
			{
				int n = r.nextInt();
				buffer.add( n );
				System.out.printf( "Produced %d\n", n );

			}
		}
}
