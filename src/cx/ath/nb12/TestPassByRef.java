package cx.ath.nb12;

public class TestPassByRef {

	public static void main( String[] args ) 
	{
		int[] myInts = {1, 2, 3};
		modifyArray( myInts );
		
		for( int i : myInts )
		{
			System.out.println( i );
		}
	}
	
	
	// so note. array are like objects in java. they're not objects but they are passed as objects. so 
	// below is pass by value and it correctly passes the value of the start memory region of 
	// the array. try re-assinging arr... doesn't work does it. 
	
	// formal and actual parameters... i can't remember difference. 
	public static void modifyArray( int[] arr )
	{
		// uncomment the below to prove we use pass by value. 
		//arr = new int[] {1};
		
		if( arr.length > 0 )
			arr[0] = 99;
	}

}
