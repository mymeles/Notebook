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
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTaskName() method
	 */
	@Test
	public void testGetTaskName() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the setTaskName() method
	 */
	@Test
	public void testSetTaskName() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTaskDescription() method
	 */
	@Test
	public void testGetTaskDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the setTaskDescription() method
	 */
	@Test
	public void testSetTaskDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the isRecurring() method
	 */
	@Test
	public void testIsRecurring() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the setRecurring() method
	 */
	@Test
	public void testSetRecurring() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the isActive() method
	 */
	@Test
	public void testIsActive() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the setActive() method
	 */
	@Test
	public void testSetActive() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the getTaskListName() method
	 */
	@Test
	public void testGetTaskListName() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the addTaskList() name
	 */
	@Test
	public void testAddTaskList() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the completeTask() method
	 */
	@Test
	public void testCompleteTask() {
		fail("Not yet implemented");
	}

	/**
	 * Tests the clone() method
	 */
	@Test
	public void testClone() {
		Task task = new Task("CSC 126", "description", true, false);
		TaskList list = new TaskList("list", 0);
		
		Task task0 = new Task("CSC126", "description", true, false);
		
		//???????
		list.addTask(task);
		list.addTask(task0);
		task.addTaskList(list);
		task0.addTaskList(list);
		assertEquals(2, list.getTasks().size());
		//???????
		task.completeTask();
		task0.completeTask();
		assertEquals(2, list.getCompletedCount());
		assertEquals(2, list.getTasks().size()); //size should still be 1 because task is recurring
		
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
