package cx.ath.nb12.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternTest {

	@Test
	public void testCreatePattern1() {
		
		Pattern p = Pattern.newEmptyPattern("Test Pattern", 3, 3);
		
		assertEquals("Test Pattern", p.getName());
		assertEquals(3, p.getWidth());
		assertEquals(3, p.getHeight());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreatePattern2() {
		
		Pattern.newEmptyPattern("Test Pattern", 1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreatePattern3() {
		
		Pattern.newEmptyPattern("Test Pattern", 0, 1);
	}
	
	@Test
	public void testCreatePattern4() {
		
		// The smallest allowed pattern
		Pattern.newEmptyPattern("Test Pattern", 1, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreatePattern5() {
		
		// Cannot have null or empty name
		Pattern.newEmptyPattern("", 1, 1);
	}
	
	@Test
	public void testEmptyPattern() {
		
		Pattern p = Pattern.newEmptyPattern("Test Pattern", 3, 3);
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				assertNull(p.getElementAt(row, col));
			}
		}
	}

}
