package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Tests the Notebook class
 * 
 * @author Helen Solomon
 * @author Meles Meles
 */
public class NotebookTest {

	/**
	 * Tests the constructor
	 */
	@Test
	public void testNotebook() {
		Notebook nb;
		try {
			nb = new Notebook("");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid notebook name.", e.getMessage());
		}
		nb = new Notebook("Notebook");
		assertEquals("Notebook", nb.getNotebookName());
		assertEquals("Active Tasks", nb.getCurrentTaskList().getTaskListName());
		assertTrue(nb.isChanged());
	}

	/**
	 * Tests the saveNotebook() method
	 */
	@Test
	public void testSaveNotebook() {
		Notebook nb = new Notebook("Notebook");
		File file = new File("test-files/notebook9.txt");
		assertEquals(1, nb.getTaskListsNames().length);
		assertEquals("Active Tasks", nb.getTaskListsNames()[0]);
		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getTaskListsNames()[1]);
		nb.saveNotebook(file);
		assertFalse(nb.isChanged());
	}

	/**
	 * Tests the addTaskList() method
	 */
	@Test
	public void testAddTaskList() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);
		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		TaskList list2 = new TaskList("Active Tasks", 5);
		// test adding list with name "Active Tasks"
		try {
			nb.addTaskList(list2);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		// test adding duplicate list
		try {
			nb.addTaskList(list);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
	}

	/**
	 * Tests the setCurrentTaskList() method
	 */
	@Test
	public void testSetCurrentTaskList() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);
		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getCurrentTaskList().getTaskListName());
		// try setting the current task list to list that is not added in notebook
		TaskList list2 = new TaskList("Active Tasks", 5);
		nb.setCurrentTaskList(list2.getTaskListName());
		assertEquals("Active Tasks", nb.getCurrentTaskList().getTaskListName());
	}

	/**
	 * Tests the editTaskList() method
	 */
	@Test
	public void testEditTaskList() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);
		// test editing active task list
		try {
			nb.editTaskList("Groceries");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}

		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getCurrentTaskList().getTaskListName());
		nb.editTaskList("CSC216");
		assertEquals("CSC216", nb.getCurrentTaskList().getTaskListName());
		assertTrue(nb.isChanged());
		// test editing with invalid name
		try {
			nb.editTaskList("");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			nb.editTaskList(null);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
	}

	/**
	 * Tests the removeTaskList() method
	 */
	@Test
	public void testRemoveTaskList() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);
		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getCurrentTaskList().getTaskListName());
		nb.removeTaskList();
		assertEquals("Active Tasks", nb.getCurrentTaskList().getTaskListName());
	}

	/**
	 * Tests the addTask() method
	 */
	@Test
	public void testAddTask() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);
		// test adding a task to no list (active task list)
		Task task1 = new Task("Homework", "Due today", true, false);
		nb.addTask(task1);
		assertEquals(0, nb.getCurrentTaskList().getTasks().size());
		assertTrue(nb.isChanged());

		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getCurrentTaskList().getTaskListName());

		TaskList list2 = new TaskList("School", 5);
		nb.addTaskList(list2);
		assertEquals(3, nb.getTaskListsNames().length);
		assertEquals("School", nb.getCurrentTaskList().getTaskListName());
		// add a task to School list
		Task task2 = new Task("Homework", "Due today", true, false);
		nb.addTask(task2);
		assertEquals("Homework", nb.getCurrentTaskList().getTasks().get(0).getTaskName());
		Task task3 = new Task("Tutor", "Lesson today", false, true);
		nb.addTask(task3);
		assertEquals("Tutor", nb.getCurrentTaskList().getTasks().get(1).getTaskName());
	}

	/**
	 * Tests the editTask() method
	 */
	@Test
	public void testEditTask() {
		Notebook nb = new Notebook("Notebook");
		assertEquals(1, nb.getTaskListsNames().length);

		TaskList list = new TaskList("CSC 216", 5);
		nb.addTaskList(list);
		assertEquals(2, nb.getTaskListsNames().length);
		assertEquals("CSC 216", nb.getCurrentTaskList().getTaskListName());

		TaskList list2 = new TaskList("School", 5);
		nb.addTaskList(list2);
		assertEquals(3, nb.getTaskListsNames().length);
		assertEquals("School", nb.getCurrentTaskList().getTaskListName());
		// add a task to School list
		Task task2 = new Task("Homework", "Due today", true, false);
		nb.addTask(task2);
		assertEquals("Homework", nb.getCurrentTaskList().getTasks().get(0).getTaskName());
		Task task3 = new Task("Tutor", "Lesson today", false, true);
		nb.addTask(task3);
		assertEquals("Tutor", nb.getCurrentTaskList().getTasks().get(1).getTaskName());
		// edit first task
		assertEquals("Homework", nb.getCurrentTaskList().getTask(0).getTaskName());
		nb.editTask(0, "Soccer", "On the field", true, false);
		assertEquals("Soccer", nb.getCurrentTaskList().getTask(0).getTaskName());
		assertEquals("On the field", nb.getCurrentTaskList().getTask(0).getTaskDescription());

	}

}
