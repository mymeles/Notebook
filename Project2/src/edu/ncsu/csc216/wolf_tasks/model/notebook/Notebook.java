package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * A method that interacts with the GUI by offering operations on TaskLists and Tasks
 * 
 * @author Meles Meles
 * @author Helen Solomon
 *
 */
public class Notebook {

	/** A string representation of a Notebook name */
	private String notebookName;
	/** A boolean that keeps track if the notebook has been changhed */
	private boolean isChnaged;
	/** a sortedList of taskLists */
	private ISortedList<TaskList> taskLists;
	/** An ActiveTaskList called activeTaskList */
	private ActiveTaskList activeTaskList;
	/** An AbstractTaskList called currentTaskList */
	private AbstractTaskList currentTaskList;

	/**
	 * A constructor to create a notebook with a given notebook name
	 * 
	 * @param notebookname a string that holds notebook name
	 */
	public Notebook(String notebookname) {

	}

	/**
	 * A method then writes notebook to a give file location. Saves the current
	 * Notebook to the given file and the boolean isChanged is updated to false.
	 * 
	 * @param file a string that holds the location to save the notebook
	 */
	public void saveNotebook(File file) {

	}

	/**
	 * returns the name of the current notebook.
	 * 
	 * @return a string
	 */
	public String getNotebookName() {
		return notebookName;

	}

	/**
	 * a method the sets the notebook name to the given parameter.
	 * 
	 * @param notebookName is a string for notebook name
	 */
	private void setNotebookName(String notebookName) {

	}

	/**
	 * A method that sets the isChanged boolean to true.
	 * 
	 * @return a boolean
	 */
	public boolean isChanged() {
		return true;
	}

	/**
	 * A method that sets isChanged to either true or false depending on the give
	 * parameter value.
	 * 
	 * @param isChanged is a boolean
	 */
	public void setChanged(boolean isChanged) {

	}

	/**
	 * A method that adds task list to the task lists updates isChanged is to true.
	 * 
	 * @param taskList is a TaskList to be added to task lists
	 */
	public void addTaskList(TaskList taskList) {

	}

	/**
	 * A method that Returns a list of task list names where the Active Tasks is
	 * always listed first.
	 * 
	 * @return an array of strings
	 */
	public String[] getTaskListsNames() {
		return null;

	}


	/**
	 * a method that sets the currentTaskList to the AbstractTaskList with the given
	 * name. If a TaskList with that name is not found, then the currentTaskList is
	 * set to the activeTaskList
	 * 
	 * @param taskName a string that holds taskName
	 */
	public void setCurrentTaskList(String taskName) {

	}

	/**
	 * A method that returns an abstractTaskList from a given taskListName
	 * 
	 * @param taskListName a string value of a task lists name
	 * @return an AbstracttaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}

	/**
	 * A method that edits the currentTaskLists name.
	 * @param taskListName is a string value of a taskListName
	 */
	public void editTaskList(String taskListName) {

	}

	/**
	 * A method that removes the currentTask list and then sets to the
	 * activeTaskList and also the boolean isChaged is updated to true.
	 */
	public void removeTaskList() {

	}

	/**
	 * A method that adds a task to the taskList
	 * @param t is a Task
	 */
	public void addTask(Task t) {

	}

	/**
	 * A method that edits a given task in the currentTask list. 
	 * @param idx is an integer that represents the index of a task
	 * @param taskName is a string that represents the name of a task
	 * @param taskDescription is a string that represents the description of a task
	 * @param recurring is a boolean that indicates if the task is recurring or not 
	 * @param active is a boolean that indicates if the task is active or not
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {

	}

}