package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;

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
	public void testNotebookReader() {
		Notebook nb1;
		try {
			nb1 = NotebookReader.readNodebookFile(INVALID6);
		} catch (IllegalArgumentException e) {
			assertEquals("File not found.", e.getMessage());
		}
		
		nb1 = NotebookReader.readNodebookFile(VALID1);
		assertEquals(3, nb1.getTaskListsNames().length);
		assertEquals("CSC 216", nb1.getTaskListsNames()[0]);
		assertEquals("CSC 226", nb1.getTaskListsNames()[1]);
		assertEquals("Habits", nb1.getTaskListsNames()[2]);
		
		assertEquals("", nb1.getCurrentTaskList());
		assertEquals("School", nb1.getNotebookName());
		
		Notebook nb2 = NotebookReader.readNodebookFile(VALID2);
		assertEquals(0, nb2.getTaskListsNames().length);
		assertNull(nb2.getTaskListsNames()[0]);
		
		assertEquals("", nb2.getCurrentTaskList());
		assertEquals("Summer Plans", nb2.getNotebookName());
		
		Notebook nb3 = NotebookReader.readNodebookFile(VALID3);
		assertEquals(3, nb3.getTaskListsNames().length);
		assertEquals("CSC 216", nb3.getTaskListsNames()[0]);
		assertEquals("CSC 226", nb3.getTaskListsNames()[1]);
		assertEquals("Habits", nb3.getTaskListsNames()[2]);
		
		assertEquals("", nb3.getCurrentTaskList());
		assertEquals("School", nb3.getNotebookName());
		
		Notebook nb4 = NotebookReader.readNodebookFile(INVALID1);
		assertEquals(0, nb4.getTaskListsNames().length);
		assertEquals(null, nb4.getTaskListsNames()[0]);
		
		assertNull(nb3.getCurrentTaskList());
		assertNull(nb3.getNotebookName());
		
		Notebook nb5 = NotebookReader.readNodebookFile(INVALID2);
		assertEquals(0, nb5.getTaskListsNames().length);
		assertNull(nb5.getTaskListsNames()[0]);
		
		assertNull(nb5.getCurrentTaskList());
		assertNull(nb5.getNotebookName());

		Notebook nb6 = NotebookReader.readNodebookFile(INVALID3);
		assertEquals(0, nb6.getTaskListsNames().length);
		assertNull(nb6.getTaskListsNames()[0]);
		
		assertNull(nb6.getCurrentTaskList());
		assertNull(nb6.getNotebookName());
		
		Notebook nb7 = NotebookReader.readNodebookFile(INVALID4);
		assertEquals(0, nb7.getTaskListsNames().length);
		assertNull(nb7.getTaskListsNames()[0]);
		
		assertNull(nb7.getCurrentTaskList());
		assertNull(nb7.getNotebookName());
		
		Notebook nb8 = NotebookReader.readNodebookFile(INVALID5);
		assertEquals(0, nb8.getTaskListsNames().length);
		assertNull(nb8.getTaskListsNames()[0]);
		
		assertNull(nb8.getCurrentTaskList());
		assertNull(nb8.getNotebookName());
	}

	@Test
	public void testReadNodebookFile() {
		fail("Not yet implemented");
	}

}
