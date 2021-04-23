package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * A class that writes NoteBook and its task lists into a txt file to a given
 * location
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class NotebookWriter {

	/**
	 * A method that write Task List under a given Notebook to a give file name
	 * location.
	 * 
	 * @param file     location to write the NootBook
	 * @param name     A string that holds Notebook name
	 * @param taskList a list of task that are under Notebook
	 */
	public static void writeNotebookFile(File file, String name, ISortedList<TaskList> taskList) {
		try {
			PrintStream fileWriter = new PrintStream(file);
			fileWriter.print("! " + name);
			// print out information of activetasklist
			for (int i = 0; i < taskList.size(); i++) {
				// first print the name of the task list
				// start a for loop that prints all the tasklists and their tasks
				fileWriter
						.print("\n# " + taskList.get(i).getTaskListName() + "," + taskList.get(i).getCompletedCount());
				for (int j = 0; j < taskList.get(i).getTasks().size(); j++) {
					fileWriter.print("\n" + taskList.get(i).getTasks().get(j).toString().trim());
				}
			}
			fileWriter.close();
		} catch (FileNotFoundException | NullPointerException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}

	}

}