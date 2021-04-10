package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActiveTaskListTest {

	@Test
	public void testSetTaskListName() {
		AbstractTaskList active = new TaskList("csc 126", 0);
		active.setTaskListName("hfhfhf");
		Task task1 = new Task("HomeWork", "Do it today", false, true);
		task1.addTaskList(active);
		active.addTask(task1);
		assertEquals("hfhfhf", task1.getTaskListName());
		assertEquals(task1.getTaskName(), active.getTask(0).getTaskName());
		
		
		System.out.println(task1.getTaskListName());
		System.out.println(active.getTask(0).getTaskName());
		
	}

	@Test
	public void testAddTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTasksAsArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testActiveTaskList() {
		fail("Not yet implemented");
	}

	@Test
	public void testClearTasks() {
		fail("Not yet implemented");
	}

}
