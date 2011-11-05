package cx.ath.nb12;

public class JavaException {

	private String name;
	
	public JavaException( String name )
	{
		this.name = name;
	}
	
	public String getName( )
	{
		return this.name; 
	}
	
	public String introduce() 
	{
		return String.format( "Hello, my name is %s. Who are you?", this.getName() );
	}
	
	public void shakeHands() throws Error
	{
		throw new Error( "I'm sorry, I am not going to shake your hand." );
	}
	
	public static void main( String args[] )
	{
		JavaException je = new JavaException( "Jordan Dinwiddy" );
		System.out.println( je.introduce() );
		
		je.shakeHands();
	}
}