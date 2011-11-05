package cx.ath.nb12.producerconsumer;

public class Driver {

	public static void main( String[] args )
	{
		IntBuffer b = new IntBuffer();
		Producer p = new Producer( b );
		Consumer c = new Consumer( b );
		Producer p1 = new Producer( b );
		Consumer c1 = new Consumer( b );
		Producer p2 = new Producer( b );
		Consumer c2 = new Consumer( b );
		
		p.start();
//		c.start();
//		p1.start();
//		c1.start();
//		p2.start();
//		c2.start();
	}
}
