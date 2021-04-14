package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActiveTaskListTest {
 
	@Test
	public void testActiveTaskList() {

		AbstractTaskList active1 = new ActiveTaskList();

		assertEquals("Active Tasks", active1.getTaskListName());
		assertEquals(0, active1.getCompletedCount());

	}

	@Test
	public void testSetTaskListName() {

		AbstractTaskList active1 = new ActiveTaskList();
		assertEquals("Active Tasks", active1.getTaskListName());
		try {
			active1.setTaskListName("name2");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The Active Tasks list may not be edited.", e.getMessage());
		}

		assertEquals(0, active1.getCompletedCount());

	}

	@Test
	public void testAddTask() {
		AbstractTaskList active1 = new ActiveTaskList();
		assertEquals("Active Tasks", active1.getTaskListName());
		assertEquals(0, active1.getCompletedCount());

		Task task1 = new Task("HomeWork", "Do it today", false, true);

		active1.addTask(task1);
		task1.addTaskList(active1);
		assertEquals(task1.getTaskName(), active1.getTask(0).getTaskName());

		
	}

	@Test
	public void testGetTasksAsArray() {
		AbstractTaskList active1 = new ActiveTaskList();
		assertEquals("Active Tasks", active1.getTaskListName());
		assertEquals(0, active1.getCompletedCount());

		
		Task task1 = new Task("HomeWork", "Do it today", false, true);
		Task task2 = new Task("HomeWork1", "Do it today", false, true);
		Task task3 = new Task("HomeWork2", "Do it today", false, true);
		Task task4 = new Task("HomeWork3", "Do it today", false, true);

		active1.addTask(task4);
		active1.addTask(task3);
		active1.addTask(task2);
		active1.addTask(task1);
		
		task1.addTaskList(active1);
		task2.addTaskList(active1);
		task3.addTaskList(active1);
		task4.addTaskList(active1);
		
		String [][] taskArray = active1.getTasksAsArray();
		
		assertEquals("Active Tasks", taskArray[0][0]);
		assertEquals("HomeWork3", taskArray[0][1]);
		assertEquals("HomeWork2", taskArray[1][1]);
		assertEquals("HomeWork1", taskArray[2][1]);
		
	}

	@Test
	public void testClearTasks() {
		ActiveTaskList active1 = new ActiveTaskList();
		assertEquals("Active Tasks", active1.getTaskListName());
		assertEquals(0, active1.getCompletedCount());

		
		Task task1 = new Task("HomeWork", "Do it today", false, true);
		Task task2 = new Task("HomeWork1", "Do it today", false, true);
		Task task3 = new Task("HomeWork2", "Do it today", false, true);
		Task task4 = new Task("HomeWork3", "Do it today", false, true);

		active1.addTask(task4);
		active1.addTask(task3);
		active1.addTask(task2);
		active1.addTask(task1);
		
		assertEquals(4, active1.getTasksAsArray().length);
		active1.clearTasks();
		assertEquals(0, active1.getTasksAsArray().length);
	}

}
