package cx.ath.nb12;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	
	
	public Person( String firstName, String lastName, int age )
	{
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.age 		= age;
		
		System.out.println( "Person has been initiated." );
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return( String.format( "Hello my name is %s %s and I am %d years old. " +
				"My first name is %d chars long.", 
				this.getFirstName(),
				this.getLastName(),
				this.getAge(),
				this.getFirstName().length()
		) );
	}
	
	public boolean equals( Object o )
	{
		if( o.getClass() != this.getClass() )
			return false;
		
		Person p = (Person) o;
		return( p.getAge() 			== this.getAge() &&
				p.getFirstName() 	== this.getFirstName() &&
				p.getLastName() 	== this.getLastName()
		);
	}
	
	public int hashCode()
	{
		return( 19 );
	}
	
	
	

}
