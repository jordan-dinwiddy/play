package cx.ath.nb12.sorting;


public class Quicksort {

	
	// Here's our NON-inplace quicksort. lots of memory wasted!
	//	quicksort( array )
	//	{
	//		if( array.length <= 1 )
	//			return array;
	//		
	//		List less, more; 
	//		
	//		pivot = array[0];
	//		array.remove( 0 );
	//		
	//		for( x in array )
	//		{
	//			if( x <= pivot )
	//				less.append( x );
	//			else
	//				more.append( x );
	//		}
	//		
	//		return( concat( quicksort( less ), pivot, quicksort( more ) ) );
	//	}
	
	public static void sort( int[] arr )
	{
		if( arr == null || arr.length == 0 )
			return;
		
		quicksortImpl( 0, ( arr.length - 1 ), arr );
	}
	
	private static void quicksortImpl( int low, int high, int[] arr )
	{
		int i = low;
		int j = high;
		
		int pivot = arr[low + (high-low)/2];
		
		while( i <= j )
		{
			while( arr[i] < pivot )
				i++;
			
			while( arr[j] > pivot )
				j--;
			
			if( i <= j )
				swap( i++, j--, arr );
		};
				
		if( low < j )
			quicksortImpl( low, j, arr );
		if( i < high )
			quicksortImpl( i, high, arr );
	}
	
	private static void swap( int i, int j, int[] arr )
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
