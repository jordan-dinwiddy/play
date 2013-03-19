package cx.ath.nb12.priorityqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cx.ath.nb12.priorityqueue.ArrayBasedPriorityQueue.Priority;

public class ArrayBasedPriorityQueueTest {

	private ArrayBasedPriorityQueue<String> queue;
	
	@Before
	public void setup() {
		
		queue = new ArrayBasedPriorityQueue<String>();
	}
	
	@Test
	public void testEmpty() {
		
		assertNull(queue.dequeue());
	}
	
	@Test
	public void testOneItem() {
		
		queue.enqueue("Item1");
		
		assertEquals("Item1", queue.dequeue());
		assertNull(queue.dequeue());
	}
	
	@Test
	public void testManyItem() {
		
		for(int i = 0; i < 50; i++) {
			queue.enqueue("Item" + i + "_low", Priority.LOW);
			queue.enqueue("Item" + i + "_medium", Priority.MEDIUM);
			queue.enqueue("Item" + i + "_high", Priority.HIGH);
		}
		
		// We should have 150 items on there, 50 high, 50 medium, 50 low
		String[] expectedPriorityTypes = {"high", "medium", "low"};
		for(String priorityType : expectedPriorityTypes) {
			for(int i = 0; i < 50; i++) {
				String item = queue.dequeue();
				String[] parts = item.split("_");
				assertEquals(priorityType, parts[1]);
			}
		}
		
		assertNull(queue.dequeue());
	}
	
	@Test
	public void testCommonUse() {
		
		ArrayBasedPriorityQueue<String> queue = new ArrayBasedPriorityQueue<String>();
		queue.enqueue("Item1", Priority.LOW);
		queue.enqueue("Item2", Priority.LOW);
		queue.enqueue("Item3", Priority.HIGH);
		queue.enqueue("Item4", Priority.MEDIUM);
		
		// Dequeue order should be from start to finish:
		// Item3, Item4, Nondeterministic_order(Item1, Item2)
		assertEquals("Item3", queue.dequeue());
		assertEquals("Item4", queue.dequeue());
		assertEquals("Item1", queue.dequeue());
		assertEquals("Item2", queue.dequeue());
		assertNull(queue.dequeue());
	}
}
