package cx.ath.nb12.poly;

public class Driver {

	public static void main( String[] args )
	{
		Parent p1 = new ChildA();
		Parent p2 = new ChildB();
		
		// So here we have polymorphism because the same method call goes to completely different
		//implementations.
		
		/**
		 * Polymorphism is the capability of an action or method to do 
		 * different things based on the object that it is acting upon. 
		 * This is the third basic principle of object oriented programming. 
		 * Overloading, overriding and dynamic method binding are three types 
		 * of polymorphism.
		 */
		System.out.println( p1.desc() );
		System.out.println( p2.desc() );
	}
	

}
