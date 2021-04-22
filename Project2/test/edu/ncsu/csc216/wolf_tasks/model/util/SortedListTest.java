package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * A Test class for SortedList.java
 * 
 * @author Meles Meles
 * @author Helen Solomon
 *
 */
public class SortedListTest {

	/**
	 * A test for SortedList Constructor
	 */
	@Test
	public void testSortedList() {
		ISortedList<Integer> int1 = new SortedList<Integer>();
		int1.add(2);
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(1, int1.size());
		int1.add(1);

		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(2, int1.size());
		int1.add(5);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(5, (int) (int1.get(2)));
		assertEquals(3, int1.size());
		int1.add(4);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(4, (int) (int1.get(2)));
		assertEquals(5, (int) (int1.get(3)));
		assertEquals(4, int1.size());
		int1.add(3);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(3, (int) (int1.get(2)));
		assertEquals(4, (int) (int1.get(3)));
		assertEquals(5, (int) (int1.get(4)));
		assertEquals(5, int1.size());

	}

	/**
	 * A test method for add()
	 */
	@Test
	public void testAdd() {
		// testing valid inputs
		ISortedList<Integer> int1 = new SortedList<Integer>();
		int1.add(2);
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(1, int1.size());
		int1.add(1);

		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(2, int1.size());
		int1.add(5);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(5, (int) (int1.get(2)));
		assertEquals(3, int1.size());
		int1.add(4);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(4, (int) (int1.get(2)));
		assertEquals(5, (int) (int1.get(3)));
		assertEquals(4, int1.size());
		int1.add(3);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(3, (int) (int1.get(2)));
		assertEquals(4, (int) (int1.get(3)));
		assertEquals(5, (int) (int1.get(4)));
		assertEquals(5, int1.size());

//		// testing duplicate items
		try {
			int1.add(1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot add duplicate element.", e.getMessage());
			assertEquals(1, (int) (int1.get(0)));
			assertEquals(2, (int) (int1.get(1)));
			assertEquals(3, (int) (int1.get(2)));
			assertEquals(4, (int) (int1.get(3)));
			assertEquals(5, (int) (int1.get(4)));
			assertEquals(5, int1.size());
		}

//		// testing null item
		try {
			int1.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals("Cannot add null element.", e.getMessage());
			assertEquals(1, (int) (int1.get(0)));
			assertEquals(2, (int) (int1.get(1)));
			assertEquals(3, (int) (int1.get(2)));
			assertEquals(4, (int) (int1.get(3)));
			assertEquals(5, (int) (int1.get(4)));
			assertEquals(5, int1.size());
		}

		// to get elements at non-exasisitng index
		try {
			int1.get(10);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Invalid index.", e.getMessage());
			assertEquals(1, (int) (int1.get(0)));
			assertEquals(2, (int) (int1.get(1)));
			assertEquals(3, (int) (int1.get(2)));
			assertEquals(4, (int) (int1.get(3)));
			assertEquals(5, (int) (int1.get(4)));
			assertEquals(5, int1.size());
		}

	}

	/**
	 * Testing SoretdList.remove()
	 */
	@Test
	public void testRemove() {
		// testing valid inputs
		ISortedList<Integer> int1 = new SortedList<Integer>();
		int1.add(2);
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(1, int1.size());
		int1.add(1);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(2, int1.size());
		int1.add(5);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(5, (int) (int1.get(2)));
		assertEquals(3, int1.size());
		int1.add(4);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(4, (int) (int1.get(2)));
		assertEquals(5, (int) (int1.get(3)));
		assertEquals(4, int1.size());
		int1.add(3);
		assertEquals(1, (int) (int1.get(0)));
		assertEquals(2, (int) (int1.get(1)));
		assertEquals(3, (int) (int1.get(2)));
		assertEquals(4, (int) (int1.get(3)));
		assertEquals(5, (int) (int1.get(4)));
		assertEquals(5, int1.size());

		// removing items fromo the first index
		assertEquals(1, (int) int1.remove(0));
		// check the list
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(3, (int) (int1.get(1)));
		assertEquals(4, (int) (int1.get(2)));
		assertEquals(5, (int) (int1.get(3)));
		assertEquals(4, int1.size());

		// removing items fromo the last index
		assertEquals(5, (int) int1.remove(int1.size() - 1));
		// check the list
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(3, (int) (int1.get(1)));
		assertEquals(4, (int) (int1.get(2)));
		assertEquals(3, int1.size());

		// removing items from the middle of the list
		assertEquals(3, (int) int1.remove(1));
		// check the list
		assertEquals(2, (int) (int1.get(0)));
		assertEquals(4, (int) (int1.get(1)));
		assertEquals(2, int1.size());
	}
}
