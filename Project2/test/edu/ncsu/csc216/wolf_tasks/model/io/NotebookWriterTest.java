package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

public class NotebookWriterTest {

	@Test
	public void testWriteNotebookFile() {
		//File exp_file = new File("test-files/notebook1.txt");
		File act_file = new File("test-files/notebook9.txt");
		SortedList<TaskList> sl = new SortedList<TaskList>();
		
		NotebookWriter.writeNotebookFile(act_file, "Notebook", sl);
		
		assertEquals(0, NotebookReader.readNodebookFile(act_file).getTaskListsNames().length);

		//???????????
	}

}
