package cx.ath.nb12.trees;

import java.util.TreeMap;

public class JavaTreeDriver {

	public static void main( String[] args )
	{
		(new JavaTreeDriver()).runDemo();
	}
	
	public void runDemo()
	{
		TreeMap<String, Object> tm = new TreeMap<String, Object>();
		
		
		
		tm.put( "Roger", null );
		tm.put( "Rona", null );
		tm.put( "Kelly", null );
		tm.put( "Lindy", null );
		tm.put( "Jordan", null );
		
		/// our keys are nicely ordered. 
		for( String key : tm.keySet() )
		{
			System.out.printf( "%s\n", key );
		}
	}
}
