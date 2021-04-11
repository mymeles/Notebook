package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaskName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTaskName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaskDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTaskDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsRecurring() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRecurring() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsActive() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetActive() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaskListName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTaskList() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompleteTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		Task task = new Task("name", "description", true, false);
		TaskList list = new TaskList("list", 0);
		//???????
		list.addTask(task);
		task.addTaskList(list);
		assertEquals(1, list.getTasks().size());
		//???????
		task.completeTask();
		assertEquals(1, list.getCompletedCount());
		assertEquals(1, list.getTasks().size()); //size should still be 1 because task is recurring
	}

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
