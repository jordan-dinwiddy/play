package cx.ath.nb12;

public class DefaultModifier {

	// public by default
	String myStr = "Hello";
	
	public static void main(String[] args)
	{
		doOne();
	}
	
	// public by default. 
	static void doOne()
	{
		System.out.println("I'm doing one.");
	}
	
	
	// public by default (see DefaultModifier2 );
	static class MyTestInnerClass
	{
		
	}
}
