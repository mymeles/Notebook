package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;

public class NotebookReaderTest {

	/**
	 * valid test file
	 */
	public static final File VALID1 = new File("test-files/notebook1.txt");
	/**
	 * valid test file
	 */
	public static final File VALID2 = new File("test-files/notebook0.txt");
	/**
	 * valid test file
	 */
	public static final File VALID3 = new File("test-files/notebook2.txt");
	/**
	 * invalid test file
	 */
	public static final File INVALID1 = new File("test-files/notebook3.txt");
	/**
	 * invalid test file
	 */
	public static final File INVALID2 = new File("test-files/notebook4.txt");
	/**
	 * invalid test file
	 */
	public static final File INVALID3 = new File("test-files/notebook5.txt");
	/**
	 * invalid test file
	 */
	public static final File INVALID4 = new File("test-files/notebook6.txt");
	/**
	 * invalid test file
	 */
	public static final File INVALID5 = new File("test-files/notebook7.txt");
	/**
	 * invalid test file (non existent)
	 */
	public static final File INVALID6 = new File("test-files/notebook8.txt");
	
	@Test
	public void testReadNodebookFile() {
		Notebook nb1;
		//test a file that doesn't exist
		try {
			nb1 = NotebookReader.readNodebookFile(INVALID6);
		} catch (IllegalArgumentException e) {
			assertEquals("File not found", e.getMessage());
		}
		
		//test a valid file with 3 lists
		nb1 = NotebookReader.readNodebookFile(VALID1);
		assertEquals(3, nb1.getTaskListsNames().length);
		assertEquals("CSC 216", nb1.getTaskListsNames()[0]);
		assertEquals("CSC 226", nb1.getTaskListsNames()[1]);
		assertEquals("Habits", nb1.getTaskListsNames()[2]);
		
		assertEquals("Habits", nb1.getCurrentTaskList().getTaskListName());
		assertEquals("School", nb1.getNotebookName());
		
		//test a valid file with no task lists
		Notebook nb2 = NotebookReader.readNodebookFile(VALID2);
		assertEquals(0, nb2.getTaskListsNames().length);
		
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, nb2.getCurrentTaskList().getTaskListName());
		assertEquals("Summer Plans", nb2.getNotebookName());
		
		//test a valid file with 3 lists but with some elements missing (tasks)
		Notebook nb3 = NotebookReader.readNodebookFile(VALID3);
		assertEquals(3, nb3.getTaskListsNames().length);
		assertEquals("CSC 216", nb3.getTaskListsNames()[0]);
		assertEquals("CSC 226", nb3.getTaskListsNames()[1]);
		assertEquals("Habits", nb3.getTaskListsNames()[2]);
		
		assertEquals("Habits", nb3.getCurrentTaskList().getTaskListName());
		assertEquals("School", nb3.getNotebookName());
		
		Notebook nb5;
		//test an invalid file, no ! at start
		try {
			nb5 = NotebookReader.readNodebookFile(INVALID1);
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		//test an invalid file, task list has no completed count
		nb5 = NotebookReader.readNodebookFile(INVALID2);
		assertEquals(0, nb5.getTaskListsNames().length);

		//test an invalid file, task list is missing name
		Notebook nb6 = NotebookReader.readNodebookFile(INVALID3);
		assertEquals(0, nb6.getTaskListsNames().length);
		
		//test an invalid file, task list has negative completed tasks
		Notebook nb7 = NotebookReader.readNodebookFile(INVALID4);
		assertEquals(0, nb7.getTaskListsNames().length);
		
		//test an invalid file, task has no name
		Notebook nb8 = NotebookReader.readNodebookFile(INVALID5);
		assertEquals(0, nb8.getTaskListsNames().length);

	}
}
