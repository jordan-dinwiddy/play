package cx.ath.nb12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {

	public static void main( String[] args )
	{

		Person[] ppl 	= new Person[10];
		ppl[0] 			= new Person( "Jordan", "Diniwddy", 23 );
		ppl[1] 			= new Person( "Sarah", "Schuman", 31 );
		
		
		for( Person p : ppl )
		{
			if( p != null )
				System.out.println( p );
		}
		
		
		List<Person> ppl2 = new ArrayList<Person>();
		ppl2.add( new Person( "Jordan",	"Dinwiddy", 23 ) );
		ppl2.add( new Person( "Jordan", "Dinwiddy", 23 ) );
		ppl2.add( new Person( "Sarah", 	"Schuman", 	31 ) );
		ppl2.add( new Person( "Linda", 	"Deering", 	50 ) );
		ppl2.add( new Person( "Kelly", 	"Dinwiddy",	22 ) );
		ppl2.add( new Person( "Jordan",	"Dinwiddy", 23 ) );
		ppl2.add( new Person( "Sarah", 	"Schuman", 	31 ) );
		ppl2.add( new Person( "Linda", 	"Deering", 	50 ) );
		ppl2.add( new Person( "Kelly", 	"Dinwiddy",	22 ) );
		
		
		HashMap<Person, Integer> map = new HashMap<Person, Integer>();
		
		for( Person p : ppl2 )
		{
			if( !map.containsKey( p ) )
				map.put( p, 0 );
			
			map.put( p, map.get( p ) + 1 );
			
			
		}	
		
		System.out.println( map );
	
	}
}
