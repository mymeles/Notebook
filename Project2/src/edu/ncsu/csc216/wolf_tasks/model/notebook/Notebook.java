package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

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
	private boolean isChanged;
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
		setNotebookName(notebookname);
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		setChanged(true);
	}

	/**
	 * A method then writes notebook to a give file location. Saves the current
	 * Notebook to the given file and the boolean isChanged is updated to false.
	 * 
	 * @param file a string that holds the location to save the notebook
	 */
	public void saveNotebook(File file) {
		NotebookWriter.writeNotebookFile(file, notebookName, taskLists);
		setChanged(false);
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
	private void setNotebookName(String name) {
		if (name == null || name.equals("") || name.toLowerCase().equals(ActiveTaskList.ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid notebook name.");
		} else {
			this.notebookName = name;
		}
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
		this.isChanged = isChanged;
	}

	/**
	 * A method that adds task list to the task lists updates isChanged is to true.
	 * 
	 * @param taskList is a TaskList to be added to task lists
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().toLowerCase().equals(ActiveTaskList.ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		isDuplicate(taskList.getTaskListName());
		
		taskLists.add(taskList);
		setCurrentTaskList(taskList.getTaskListName());
		setChanged(true);
	}

	/**
	 * Private helper method to check duplicity
	 * @param name name of task list
	 */
	private void isDuplicate(String name) {
		for (int i = 0; i < taskLists.size(); i++) {
			if (name.equals(taskLists.get(i).getTaskListName())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
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
	 * 
	 */
	private void getActiveTaskList() {
		
	}
	
	/**
	 * a method that sets the currentTaskList to the AbstractTaskList with the given
	 * name. If a TaskList with that name is not found, then the currentTaskList is
	 * set to the activeTaskList
	 * 
	 * @param taskName a string that holds taskName
	 */
	public void setCurrentTaskList(String listName) {
		for (int i = 0; i < taskLists.size(); i++) {
			if (listName.equals(taskLists.get(i).getTaskListName())) {
				currentTaskList = taskLists.get(i);
				return;
			}
		}
		currentTaskList = activeTaskList;
	}

	/**
	 * A method that returns an abstractTaskList which is the current task list
	 * 
	 * @param taskListName a string value of a task lists name
	 * @return an AbstracttaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}

	/**
	 * A method that edits the currentTaskLists name.
	 * @param taskListName is a string value of a taskListName
	 */
	public void editTaskList(String taskListName) {
		if (taskListName == null || taskListName.equals("") || taskListName.toLowerCase().equals(ActiveTaskList.ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (currentTaskList.getTaskListName().toLowerCase().equals(ActiveTaskList.ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		isDuplicate(taskListName);
		currentTaskList.setTaskListName(taskListName);
		setChanged(true);
	}

	/**
	 * A method that removes the currentTask list and then sets to the
	 * activeTaskList and also the boolean isChaged is updated to true.
	 */
	public void removeTaskList() {
		if (currentTaskList.getTaskListName().toLowerCase().equals(ActiveTaskList.ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		//?????????
		for (int i = 0; i < taskLists.size(); i++) {
			if (currentTaskList.getTaskListName().equals(taskLists.get(i).getTaskListName())) {
				currentTaskList = taskLists.remove(i);
			}
		}
		
		setChanged(true);
	}

	/**
	 * A method that adds a task to the taskList
	 * @param t is a Task
	 */
	public void addTask(Task t) {
		//?????? where do we use getActiveTaskList() here ???????
		if (!(currentTaskList instanceof TaskList)) {
			return;
		} else {
			currentTaskList.addTask(t);
			if (t.isActive()) {
				activeTaskList.addTask(t);
			}
		}
		setChanged(true);
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
		//?????? where do we use getActiveTaskList() here ???????
		if (!(currentTaskList instanceof TaskList)) {
			return;
		} else {
			currentTaskList.getTask(idx).setTaskName(taskName);
			currentTaskList.getTask(idx).setTaskDescription(taskDescription);
			currentTaskList.getTask(idx).setRecurring(recurring);
			currentTaskList.getTask(idx).setActive(active);
			
			if (currentTaskList.getTask(idx).isActive()) {
				activeTaskList.addTask(currentTaskList.getTask(idx));
			}
		}
		//call getActiveTaskList()
		setChanged(true);
	}

}