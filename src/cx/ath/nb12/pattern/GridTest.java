package cx.ath.nb12.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void testCreateGrid1() {

		Grid grid = new Grid(3, 3);

		assertEquals(3, grid.getWidth());
		assertEquals(3, grid.getHeight());
	}

	@Test
	public void testCreateGrid2() {

		Grid grid = new Grid(3, 3);

		// Test each element in our new grid is inited to Null
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				assertNull(grid.getElementAt(row, col));
			}
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCreateGrid3() {

		new Grid(0, 0);
	}

	@Test
	public void testCreateGrid4() {

		// The smallest grid we can have - shouldn't throw an exceptions
		new Grid(1, 1);
	}

	@Test
	public void testGetElementValidRange() {

		Grid grid = new Grid(3, 3);

		// Check that none of these result in exceptions being thrown
		assertNull(grid.getElementAt(0, 0));	// Top left
		assertNull(grid.getElementAt(0, 2));	// Top right
		assertNull(grid.getElementAt(2, 0));	// Bottom left
		assertNull(grid.getElementAt(2, 2));	// Bottom right
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetElementInvalidLowRowRange() {

		Grid grid = new Grid(3, 3);

		grid.getElementAt(-1, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetElementInvalidHighRowRange() {

		Grid grid = new Grid(3, 3);

		grid.getElementAt(3, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetElementInvalidLowColRange() {

		Grid grid = new Grid(3, 3);

		grid.getElementAt(2, -1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetElementInvalidHighColRange() {

		Grid grid = new Grid(3, 3);

		grid.getElementAt(2, 3);
	}

	@Test
	public void testSetElementValidRange() {

		Grid grid = new Grid(3, 3);

		grid.setElementAt(0, 0, BasicElement.COAL);
		grid.setElementAt(0, 2, BasicElement.IRON);
		grid.setElementAt(2, 0, BasicElement.MUD);
		grid.setElementAt(2, 2, BasicElement.STICK);

		assertEquals(BasicElement.COAL, grid.getElementAt(0, 0));
		assertEquals(BasicElement.IRON, grid.getElementAt(0, 2));
		assertEquals(BasicElement.MUD, grid.getElementAt(2, 0));
		assertEquals(BasicElement.STICK, grid.getElementAt(2, 2));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetElementInvalidLowRowRange() {

		Grid grid = new Grid(3, 3);

		grid.setElementAt(-1, 2, BasicElement.COAL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetElementInvalidHighRowRange() {

		Grid grid = new Grid(3, 3);

		grid.setElementAt(3, 2, BasicElement.COAL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetElementInvalidLowColRange() {

		Grid grid = new Grid(3, 3);

		grid.setElementAt(2, -1, BasicElement.COAL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetElementInvalidHighColRange() {

		Grid grid = new Grid(3, 3);

		grid.setElementAt(2, 3, BasicElement.COAL);
	}
}
