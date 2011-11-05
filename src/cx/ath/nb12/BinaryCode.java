package cx.ath.nb12;

public class BinaryCode {

	public String[] decode( String inputQ )
	{
		String[] retval = new String[2];
		
		
		char[] Q = inputQ.toCharArray();
		int length = Q.length;
		char[] P1 = new char[ length ];
		char[] P2 = new char[ length ];
		
		//assume P[0] = 0;
		P1[0] = '0';
		for( int i = 0; i < length-1; i++ )
		{
			// Q[i] = P[i-1] + P[i] + P[i+1]. We're trying to fill P[i+1]
			// P[i+1] = Q[i] - P[i-1] -P[i];
			//        = qi   - piminus - pi
			int qi 		= charToInt( Q[ i ] );
			int pminus 	= (i < 1) ? 0 : charToInt( P1[i-1] );
			int pi 		= charToInt( P1[ i ] );
			
			int pplus = qi - pminus - pi;
			if( pplus > 1 )
			{
				retval[0] = "NONE";
				break;
			}
			P1[ i+1 ] = intToChar( pplus );
		}
		
		if( length > 1 )
//			retval[0] = ( ) do the final check here. P[n-1] + P[n] == Q[ n ];
			
		int last 		= charToInt( P1[ length - 1 ] );
		int lastbutone	= ( P1.)
		
		P2[0] = '1';
		for( int i = 0; i < length-1; i++ )
		{
			// Q[i] = P[i-1] + P[i] + P[i+1]. We're trying to fill P[i+1]
			// P[i+1] = Q[i] - P[i-1] -P[i];
			//        = qi   - piminus - pi
			int qi 		= charToInt( Q[ i ] );
			int pminus 	= (i < 1) ? 0 : charToInt( P2[i-1] );
			int pi 		= charToInt( P2[ i ] );
			
			int pplus = qi - pminus - pi;
			if( pplus > 1 )
			{
				retval[1] = "NONE";
				break;
			}
			P2[ i+1 ] = intToChar( pplus );
		}
		
		if( retval[0] == null) retval[0] = new String( P1 );
		if( retval[1] == null) retval[1] = new String( P2 );
		
		
		return retval;
		
	}
	
	private static int charToInt( char c )
	{
		return c - '0';
	}
	
	private static char intToChar( int i )
	{
		return (char) (i + '0');
	}
	
	public static void main( String[] args )
	{
		BinaryCode decoder = new BinaryCode();
		String[] result = decoder.decode( "2" );
		System.out.println( result[ 0 ] );
		System.out.println( result[ 1 ] );
	}
}	
