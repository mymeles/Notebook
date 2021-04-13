package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	 * A method that reads in a file of NoteBook.
	 * 
	 * @param file a string that holds a location of a txt file for notebook
	 * @return returns a Notebook
	 */
	public static Notebook readNodebookFile(File filename) {
		Notebook nb = null;
		TaskList list = null;
		try {
			//scan file
			Scanner scan = new Scanner(new FileInputStream(filename));
			//store contents into string, make a big string
			String contents = "";
			while (scan.hasNextLine()) {
				contents += scan.nextLine() + "\n";
			}
			
			if (contents.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");
			}
			//scan the big string
			Scanner scanBook = new Scanner(contents);
			//set the name of the notebook
			scanBook.useDelimiter("\\r?\\n?[!]");
			String bookName = scanBook.nextLine().substring(2);
			nb = new Notebook(bookName);
			
			//split string into task list tokens
			scanBook.useDelimiter("\\r?\\n?[#]");
			
			while (scanBook.hasNext()) {
				//process this group of task lists
				String line = scanBook.next().trim();
				list = processTaskList(line);
				if (list != null) {
					nb.addTaskList(list);
				}
			}
			scanBook.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found");
		}
		//if all is successful, return the lists
		return nb;
	}

	 
	/**
	 * a method that helps NoteBook method into creating TaskList
	 *                        
	 * @param taskList a string that holds that holds taskList
	 * @return a TaskList
	 */
	private static TaskList processTaskList(String taskList) {
		Task task = null;
		TaskList list = null;
		try {
			//scan the task list
			Scanner scanList = new Scanner(taskList);
			//get the name of the task list
			String listName = scanList.nextLine().trim();
			Scanner scnrName = new Scanner(listName);
			scnrName.useDelimiter(",");
			//split into task list name and completed count
			String name = scnrName.next().trim();
			int count = 0;
			if (scnrName.hasNextInt()) {
				count = scnrName.nextInt();
			} else {
				scnrName.close();
				scanList.close();
				return list;
			}
			scnrName.close();
			//construct a task list
			list = new TaskList(name, count);
			//get the task tokens
			scanList.useDelimiter("\\r?\\n?[*]");
			while (scanList.hasNext()) {
				String taskData = scanList.next().trim();
				task = processTask(list, taskData);
				if (task != null) {
					list.addTask(task);
				} else {
					scanList.close();
					return null;
				}
			}
			scanList.close();
		} catch (IllegalArgumentException e) {
			return null;
		}
		return list;
	}

	/**
	 * takes in a list of AbstractTaskList and and taskDiscription and returns a Task
	 * @param task a list of Abstract List     
	 * @param taskDiscription a string that holds a tasks discription
	 * @return returns a Task
	 */
	private static Task processTask(AbstractTaskList taskList, String taskData) {
		Task task = null;
		boolean recurring = false;
		boolean active = false;
		Scanner scan = new Scanner(taskData);
		//first line will be the task name and the states
		String taskDetails = scan.nextLine().trim();
		
		//get task name and status
		Scanner scanDetails = new Scanner(taskDetails);
		scanDetails.useDelimiter(",");
		String name = scanDetails.next().trim();
		if (name.equals("active") || name.equals("recurring")) {
			scanDetails.close();
			scan.close();
			return null;
		}
		String state = "";
		
		while (scanDetails.hasNext()) {
			state = state += " " + scanDetails.next();
		}
		scanDetails.close();
		
		if (state.contains("recurring")) {
			recurring = true;
		}
		if (state.contains("active")) {
			active = true;
		}
		
		String taskDescription = "";
		while (scan.hasNextLine()) {
			taskDescription += scan.nextLine() + "\n";
		}
		scan.close();
		
		task = new Task(name, taskDescription, recurring, active);
		
		return task;
	}
}