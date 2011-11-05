package cx.ath.nb12.sorting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNull()
	{
		Quicksort.sort( null );
	}
	
	@Test
	public void testEmpty()
	{
		Quicksort.sort( new int[0] );
	}
	
	@Test
	public void testSingle()
	{
		int[] arr = { 1 };
		Quicksort.sort( arr );
		
		assertEquals( 1, arr[ 0 ] );
	}
	
	@Test
	public void testSort()
	{
		int[] arr = { 5, 17, 1, 9, 12, 99, 4, 3, 6, 9, };
		System.out.printf( "Before Sort: %s\n", formatArr( arr ) );
		assertFalse( isSorted( arr ) );
		
		Quicksort.sort( arr );
		
		System.out.printf( "After Sort: %s\n", formatArr( arr ) );
		assertTrue( isSorted( arr ) );
	}
	
	private boolean isSorted( int[] arr ) 
	{
		for( int i = 0; i < ( arr.length - 1 ); i++ )
			if( arr[i] > arr[i+1] )
				return false;
		
		return true;
	}
	
	private String formatArr( int[] arr )
	{
		StringBuffer sb = new StringBuffer();
		sb.append( '[' );
		int i;
		for( i = 0; i < ( arr.length - 1 ); i++ )
		{
			sb.append( arr[i] + ", " );
		}
		
		sb.append( arr[i] + "]" );
		return sb.toString();
	}

}
