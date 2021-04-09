package edu.ncsu.csc216.wolf_tasks.model.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SortedListTest {

	@Test
	public void testAdd() {
		ISortedList<Integer> int1 = new SortedList<Integer>();
		int1.add(2);
		int1.add(1);
		int1.add(5);
		int1.add(4);
		int1.add(3);
		
		assertEquals(1, (int)(int1.get(0)));
		assertEquals(2, (int)(int1.get(1)));
		assertEquals(3, (int)(int1.get(2)));
		assertEquals(4, (int)(int1.get(3)));
		assertEquals(5, (int)(int1.get(4)));
		
		System.out.println(int1.size());
		
		for(int i = 0; i < int1.size(); i++) {
			System.out.println(int1.get(i));
		}
		
	} 

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

}
