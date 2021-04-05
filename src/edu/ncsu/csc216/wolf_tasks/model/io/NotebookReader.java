package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * A class that reades a Notebook from a give file by enabling access to a
 * static method.
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class NotebookReader {

	/**
	 * default constructor for Notebook class
	 */
	public NotebookReader() {

	}

	/**
	 * A method that reads in a file of NoteBook 
	 * 
	 * @param file a string that holds a location of a txt file for notebook
	 * @return returns a Notebook
	 */
	public static Notebook readNodebookFile(File file) {
		return null;
		//TODO need to Implement Method

	}

	/**
	 * a method that helps NoteBook method into creating TaskList
	 *                        
	 * @param taskList a string that holds that holds taskList
	 * @return a TaskList
	 */
	private TaskList process(String taskList) {
		return null;
		//TODO need to Implement Method 
	}

	/**
	 * takes in a list of AbstractTaskList and and taskDiscription and returns a Task
	 * @param task a list of Abstract List     
	 * @param taskDiscription a string that holds a tasks discription
	 * @return returns a Task
	 */
	private Task processTask(AbstractTaskList task, String taskDiscription) {
		return null;
		//TODO need to Implement Method
	}
}
