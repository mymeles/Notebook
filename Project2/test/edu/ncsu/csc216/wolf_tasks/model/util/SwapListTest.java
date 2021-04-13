package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the SwapList class
 * @author Helen Solomon
 * @author Meles Meles
 */
public class SwapListTest {

	/**
	 * Tests the constructor
	 */
	@Test
	public void testSwapList() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
	}

	/**
	 * Tests the add() method
	 */
	@Test
	public void testAdd() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		try {
			list.add(null);
		} catch (NullPointerException e) {
			assertEquals("Cannot add null element.", e.getMessage());
		}
		
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		//try to add over capacity
		list.add("hello");
		assertEquals(11, list.size());

	}

	/**
	 * Tests the remove() method
	 */
	@Test
	public void testRemove() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		list.add("bye");
		assertEquals(2, list.size());
		list.add("winner");
		assertEquals(3, list.size());
		list.add("loser");
		assertEquals(4, list.size());

		assertEquals("hello", list.get(0));
		assertEquals("bye", list.get(1));
		assertEquals("winner", list.get(2));
		assertEquals("loser", list.get(3));
		
		list.remove(0);
		assertEquals(3, list.size());
		assertEquals("bye", list.get(0));
		list.remove(2);
		assertEquals(2, list.size());
		assertEquals("bye", list.get(0));
		assertEquals("winner", list.get(1));
	}

	/**
	 * Tests the moveUp() method
	 */
	@Test
	public void testMoveUp() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		list.add("bye");
		assertEquals(2, list.size());
		list.add("winner");
		assertEquals(3, list.size());
		list.add("loser");
		assertEquals(4, list.size());
		
		list.moveUp(0);
		assertEquals("hello", list.get(0));
		assertEquals("bye", list.get(1));
		assertEquals("winner", list.get(2));
		assertEquals("loser", list.get(3));
		
		list.moveUp(3);
		assertEquals("hello", list.get(0));
		assertEquals("bye", list.get(1));
		assertEquals("loser", list.get(2));
		assertEquals("winner", list.get(3));
	}

	/**
	 * Tests the moveDown() method
	 */
	@Test
	public void testMoveDown() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		list.add("bye");
		assertEquals(2, list.size());
		list.add("winner");
		assertEquals(3, list.size());
		list.add("loser");
		assertEquals(4, list.size());
		
		try {
			list.moveDown(5);
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Invalid index.", e.getMessage());
		}

		list.moveDown(0);
		assertEquals("bye", list.get(0));
		assertEquals("hello", list.get(1));
		assertEquals("winner", list.get(2));
		assertEquals("loser", list.get(3));
		
		list.moveDown(3);
		assertEquals("bye", list.get(0));
		assertEquals("hello", list.get(1));
		assertEquals("winner", list.get(2));
		assertEquals("loser", list.get(3));
		
		list.moveDown(2);
		assertEquals("bye", list.get(0));
		assertEquals("hello", list.get(1));
		assertEquals("loser", list.get(2));
		assertEquals("winner", list.get(3));
	}

	/**
	 * Tests the moveToFront() method
	 */
	@Test
	public void testMoveToFront() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		list.add("bye");
		assertEquals(2, list.size());
		list.add("winner");
		assertEquals(3, list.size());
		list.add("loser");
		assertEquals(4, list.size());
		
		list.moveToFront(0);
		assertEquals("hello", list.get(0));
		assertEquals("bye", list.get(1));
		assertEquals("winner", list.get(2));
		assertEquals("loser", list.get(3));
		
		list.moveToFront(3);
		assertEquals("loser", list.get(0));
		assertEquals("hello", list.get(1));
		assertEquals("bye", list.get(2));
		assertEquals("winner", list.get(3));
		
	}

	/**
	 * Tests the moveToBack() method
	 */
	@Test
	public void testMoveToBack() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
		list.add("hello");
		assertEquals(1, list.size());
		assertEquals("hello", list.get(0));

		list.add("bye");
		assertEquals(2, list.size());
		assertEquals("bye", list.get(1));

		list.add("winner");
		assertEquals(3, list.size());
		assertEquals("winner", list.get(2));

		list.add("loser");
		assertEquals(4, list.size());
		assertEquals("loser", list.get(3));

		
		list.moveToBack(0);
		assertEquals("bye", list.get(0));
		assertEquals("winner", list.get(1));
		assertEquals("loser", list.get(2));
		assertEquals("hello", list.get(3));
		
		list.moveToBack(3);
		assertEquals("bye", list.get(0));
		assertEquals("winner", list.get(1));
		assertEquals("loser", list.get(2));
		assertEquals("hello", list.get(3));
	}

}
