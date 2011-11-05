package cx.ath.nb12.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cx.ath.nb12.GenericStack;
import static org.junit.Assert.*;

public class GenericStackTest {
	private GenericStack<String> stack;
	private final int BIG_STACK_SIZE = 1000000;
	
	@Before
	public void setUp() throws Exception {
		stack = new GenericStack<String>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void newStackTest() throws Exception 
	{
		assertEquals( stack.getSize(), 0 );
		assertTrue( stack.isEmpty() );
	}
	
	@Test(expected=Exception.class) 
	public void newStackExceptionTest() throws Exception
	{
		stack.pop();
	}
	
	@Test(expected=Exception.class) 
	public void popExceptionTest() throws Exception
	{
		stack.push( "Item1" );
		assertEquals( "Item1", stack.pop() );
		stack.pop();
	}
	
	@Test
	public void testSimplePush() throws Exception
	{
		assertTrue( stack.isEmpty() );
		assertEquals( stack.getSize(), 0 );
		
		stack.push( "Item1" );
		assertFalse( stack.isEmpty() );
		assertEquals( stack.getSize(), 1 );
	}
	
	@Test
	public void testSimplePop() throws Exception
	{
		stack.push( "Item1" );
		stack.push( "Item2" );
		stack.push( "Item3" );
		
		assertEquals( "Item3", stack.pop() );
		assertEquals( "Item2", stack.pop() );
		assertEquals( "Item1", stack.pop() );
		
		assertEquals( 0, stack.getSize() );
		assertTrue( stack.isEmpty() );
	}
	
	@Test
	public void testComplexPop() throws Exception
	{
		stack.push( "Item1" );
		assertEquals( "Item1", stack.pop() );
		
		stack.push( "Item2" );
		stack.push( "Item3" );
		assertEquals( "Item3", stack.pop() );
		assertEquals( "Item2", stack.pop() );
	}
	
	@Test
	public void testExhaustive() throws Exception
	{
		for( int i = 0; i < BIG_STACK_SIZE; i++ )
		{
			stack.push( "Item" + i );
		}
		
		assertFalse( stack.isEmpty() );
		assertEquals( BIG_STACK_SIZE, stack.getSize() );
		
		for( int i = 0; i < BIG_STACK_SIZE; i++ )
		{
			assertEquals( "Item" + ( BIG_STACK_SIZE - i - 1 ), stack.pop() );
		}
		
		assertTrue( stack.isEmpty() );
		assertEquals( 0, stack.getSize() );
	}
	
	
	

}