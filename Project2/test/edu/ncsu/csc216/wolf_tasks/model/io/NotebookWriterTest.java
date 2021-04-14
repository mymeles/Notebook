package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Tests for NotebookWriter class
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class NotebookWriterTest {

	/**
	 * Tests the writeNotebookFile() method
	 */
	@Test
	public void testWriteNotebookFile() {
		//file to print to
		File actFile = new File("test-files/notebook9.txt");
		SortedList<TaskList> sl = new SortedList<TaskList>();
		TaskList list1 = new TaskList("ATaskList", 0);
		TaskList list2 = new TaskList("Tasks1", 0);
		TaskList list3 = new TaskList("Tasks2", 0);
		Task task1 = new Task("Task1", "Task1Description", true, false);
		Task task2 = new Task("Task2", "Task2Description", true, true);
		Task task3 = new Task("Task3", "Task3Description", false, false);
		Task task4 = new Task("Task4", "Task4Description", false, true);
		Task task5 = new Task("Task4", "Task5Description", true, false);
		list2.addTask(task1);
		list2.addTask(task2);
		list3.addTask(task3);
		list3.addTask(task4);
		list3.addTask(task5);
		
		sl.add(list1);
		sl.add(list2);
		sl.add(list3);

		assertEquals(0, list1.getTasks().size());
		assertEquals(2, list2.getTasks().size());
		assertEquals(3, list3.getTasks().size());
		assertEquals(3, sl.size());

		NotebookWriter.writeNotebookFile(actFile, "Notebook", sl);
		Notebook nb = NotebookReader.readNodebookFile(actFile);
		
		assertEquals(4, nb.getTaskListsNames().length);
		for (int i = 0; i < sl.size(); i++) {
			//check that the file contents are identical
			assertEquals(nb.getTaskListsNames()[i + 1], sl.get(i).getTaskListName());
		}
	}

}
