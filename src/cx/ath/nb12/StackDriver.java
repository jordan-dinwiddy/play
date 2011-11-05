package cx.ath.nb12;

public class StackDriver {

	public static void main( String[] args )
	{
		Stack s1 = new Stack( 16 );
		
		try {
			s1.push( "Hello" );
			s1.push( "My" );
			s1.push( "Name" );
			
			s1.pop();
			s1.pop();
			s1.pop();
			//s1.pop();
			
			int a = '1';
			int b = '2';
			System.out.println( (char) (9 + '0') );
		}
		catch( Exception e )
		{
			System.out.println( String.format( "Stack Exception: %s\n", e.toString() ) );
		}
	}
}
