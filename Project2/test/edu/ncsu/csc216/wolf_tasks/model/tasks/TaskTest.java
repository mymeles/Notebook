package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Task class
 * 
 * @author Meles Meles
 * @author Helen Solomon
 *
 */
public class TaskTest {

	/**
	 * Tests the constructor
	 */
	@Test
	public void testTask() {
		Task task1 = null;
		task1 = new Task("HomeWork", "Do it now", false, false);
		assertEquals("HomeWork", task1.getTaskName());
		assertEquals("Do it now", task1.getTaskDescription());
		assertFalse(task1.isActive());
		assertFalse(task1.isRecurring());
		assertTrue(task1.getTaskListName().equals(""));

		// trying to add with null task name
		task1 = null;
		try {
			task1 = new Task(null, "Do it now", false, false);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
			assertNull(task1);
		}

		// trying to create a task with empty string
		// trying to add with null task name
		try {
			task1 = new Task("", "Do it now", false, false);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
			assertNull(task1);
		}

		// trying to create a task with null description
		task1 = null;
		try {
			task1 = new Task("HomeWork", null, false, false);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
			assertNull(task1);
		}

	}

	/**
	 * Tests the addTaskList() name
	 */
	@Test
	public void testAddTaskList() {
		Task task = new Task("CSC 126", "description", true, false);
		TaskList list1 = new TaskList("list", 0);

		// testing empty task list name by default
		assertEquals("", task.getTaskListName());

		task.addTaskList(list1);

		// testing list name after adding a task list to task
		assertEquals("list", task.getTaskListName());

		// a null abstracttaskList
		try {
			task.addTaskList(null);
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
		}
	}

	/**
	 * Tests the completeTask() method
	 */
	@Test
	public void testCompleteTask() {
		Task task = new Task("CSC 126", "description", true, false);
		TaskList list1 = new TaskList("list", 0);

		Task task0 = new Task("CSC126", "description", true, false);

		// ???????
		list1.addTask(task);
		list1.addTask(task0);
		task.addTaskList(list1);
		task0.addTaskList(list1);
		assertEquals(2, list1.getTasks().size());
		// ???????
		task.completeTask();
		task0.completeTask();
		assertEquals(2, list1.getCompletedCount());
		assertEquals(2, list1.getTasks().size()); // size should still be 1 because task is recurring

		TaskList list0 = new TaskList("list0", 0);

		Task task1 = new Task("Task 1", "Task 1 Description", false, false);
		Task task2 = new Task("Task 2", "Task 2 Description", true, false);
		Task task3 = new Task("Task 3", "Task 3 Description", true, true);
		Task task4 = new Task("Task 4", "Task 4 Description", true, false);
		Task task5 = new Task("Task 5", "Task 5 Description", false, true);

		list0.addTask(task1);
		list0.addTask(task2);
		list0.addTask(task3);
		list0.addTask(task4);
		list0.addTask(task5);

		assertEquals(5, list0.getTasksAsArray().length);
		task5.completeTask();
		task3.completeTask();
		assertEquals(4, list0.getTasksAsArray().length);
	}

	/**
	 * Tests the clone() method
	 */
	@Test
	public void testClone() {
		TaskList list = new TaskList("list", 0);

		Task task = new Task("CSC 126", "description", true, false);
		Task task0 = new Task("CSC126", "description", true, false);
		Task task1 = new Task("Task 1", "Task 1 Description", false, false);
		Task task2 = new Task("Task 2", "Task 2 Description", true, false);

		task1.addTaskList(list);
		task2.addTaskList(list);

		Task clone = null;
		try {
			clone = task.clone();
			assertTrue(task.getTaskName().equals(clone.getTaskName()));
			assertEquals("CSC 216", clone.getTaskName());
		} catch (CloneNotSupportedException c) {
			//
		}

		try {
			clone = task0.clone();
			assertTrue(task0.getTaskName().equals(clone.getTaskName()));
		} catch (CloneNotSupportedException c) {
			//
		}

		// cloning when we add a list to task
		try {
			clone = task1.clone();
			assertTrue(task1.getTaskName().equals(clone.getTaskName()));
		} catch (CloneNotSupportedException c) {
			//
		}

		// testing cloning when we add a list to
		try {
			clone = task2.clone();
			assertTrue(task2.getTaskName().equals(clone.getTaskName()));
		} catch (CloneNotSupportedException c) {
			//
		}
	}

	/**
	 * Tests the toString() method
	 */
	@Test
	public void testToString() {
		Task task1 = new Task("name", "description", false, false);
		assertEquals("* name\n" + "description", task1.toString());

		Task task2 = new Task("name", "description", true, false);
		assertEquals("* name,recurring\n" + "description", task2.toString());

		Task task3 = new Task("name", "description", false, true);
		assertEquals("* name,active\n" + "description", task3.toString());

		Task task4 = new Task("name", "description", true, true);
		assertEquals("* name,recurring,active\n" + "description", task4.toString());

	}

}
