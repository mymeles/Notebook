package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for TaskList class
 *
 * @author Meles Meles
 * @author Helen Solomon
 * 
 */
public class TaskListTest {
	/**
	 * Tests the constructor
	 */
	@Test
	public void testTaskList() {
		TaskList list;
		//test tasklist with empty name
		try {
			list = new TaskList("", 21);
		} catch (Exception e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		//test tasklist with null name
		try {
			list = new TaskList(null, 21);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		//test tasklist with invalid completed count
		try {
			list = new TaskList("Party", -1);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid completed count.", e.getMessage());
		}
		//test tasklist with invalid name
		try {
			list = new TaskList("Active Tasks", 3);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		
		//test valid task list
		list = new TaskList("Party", 21);
		assertEquals(21, list.getCompletedCount());
		assertEquals("Party", list.getTaskListName());
	}

	/**
	 * Tests getTasksAsArray()
	 */
	@Test
	public void testGetTasksAsArray() {
		TaskList list = new TaskList("Party", 21);
		
		Task task1 = new Task("HomeWork", "Do it today", false, true);
		Task task2 = new Task("HomeWork1", "Do it today", false, true);
		Task task3 = new Task("HomeWork2", "Do it today", false, true);
		Task task4 = new Task("HomeWork3", "Do it today", false, true);
		
		list.addTask(task4);
		list.addTask(task3);
		list.addTask(task2);
		list.addTask(task1);

		assertEquals(4, list.getTasks().size());
		//tasks are added at the lowest priority
		assertEquals(list.getTasks().get(0).getTaskName(), list.getTasksAsArray()[0][1]); //HomeWork
		assertEquals(list.getTasks().get(1).getTaskName(), list.getTasksAsArray()[1][1]); //HomeWork1
		assertEquals(list.getTasks().get(2).getTaskName(), list.getTasksAsArray()[2][1]); //HomeWork2
		assertEquals(list.getTasks().get(3).getTaskName(), list.getTasksAsArray()[3][1]); //HomeWork3
	}

	/**
	 * Tests compareTo()
	 */
	@Test
	public void testCompareTo() {
		TaskList list1 = new TaskList("Party", 21);
		TaskList list2 = new TaskList("School", 14);
		TaskList list3 = new TaskList("Church", 7);
		TaskList list4 = new TaskList("School", 2);
		
		assertTrue(list1.compareTo(list2) < 0);
		assertTrue(list1.compareTo(list3) > 0);
		assertEquals(0, list1.compareTo(list1));
	}

}
