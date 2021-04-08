package edu.ncsu.csc216.wolf_tasks.model.io;


import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * A class that writes NoteBook and its task lists into a txt file to a given location
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class NotebookWriter {
	
	/**
	 * A default constructor for NoteBookWriter
	 */
	public NotebookWriter() {
		
	}
	
	/**
	 * A method that write Task List under a given Notebook to a give file name location.
	 * @param file location to write the NootBook
	 * @param notebook A string that holds Notebook name 
	 * @param taskList a list of task that are under Notebook
	 */
	public static void writeNotebookFile(File file, String notebook, ISortedList<TaskList> taskList) {
		//TODO need to implement method
	}

}