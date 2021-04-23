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
 * A method that interacts with the GUI by offering operations on TaskLists and
 * Tasks
 * 
 * @author Meles Meles
 * @author Helen Solomon
 *
 */
public class Notebook {

	/** A string representation of the Notebook's name */
	private String notebookName;
	/** A boolean that keeps track if the notebook has been changed */
	private boolean isChanged;
	/** a sortedList of taskLists that are contained within the notebook */
	private ISortedList<TaskList> taskLists;
	/**
	 * An ActiveTaskList called "Active Tasks" that holds the active tasks in
	 * notebook
	 */
	private ActiveTaskList activeTaskList;
	/** An AbstractTaskList called currentTaskList */
	private AbstractTaskList currentTaskList;

	/**
	 * A Notebook constructor that allows user to set it's name. With a new
	 * notebook, an empty SortedList of taskLists and activeTaskList is constructed.
	 * The current task list is set to activeTaskList. The isChanged status is set
	 * to true.
	 * 
	 * @param notebookname a string that holds the notebook's name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		setChanged(true);
	}

	/**
	 * A method that writes the edited notebook to a given file location. Saves the
	 * current task lists to the given file and the boolean isChanged is updated to
	 * false.
	 * 
	 * @param file a string that holds the location to save the notebook
	 */
	public void saveNotebook(File file) {
		NotebookWriter.writeNotebookFile(file, notebookName, taskLists);
		setChanged(false);
	}

	/**
	 * Returns the name of the current notebook
	 * 
	 * @return a string that represents the notebook's name
	 */
	public String getNotebookName() {
		return notebookName;

	}

	/**
	 * A method that sets the notebook name to the given parameter.
	 * 
	 * @param name string that represents the notebook's potential name
	 * @throws IllegalArgumentException with the message "Invalid name." if the name
	 *                                  given is null, empty, or equals "Active
	 *                                  Tasks"
	 */
	private void setNotebookName(String name) {
		if (name == null || "".equals(name) || name.compareToIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME) == 0) {
			throw new IllegalArgumentException("Invalid name.");
		} else {
			this.notebookName = name;
		}
	}

	/**
	 * A method that returns the value of the isChanged boolean for the Notebook. If
	 * the notebook has been changed, isChanged boolean returns true. Else, returns
	 * false.
	 * 
	 * @return true or false
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * A method that monitors the status of the isChanged boolean for the Notebook.
	 * If the notebook has been changed, isChanged boolean is set to true. Else, is
	 * set to false.
	 * 
	 * @param isChanged is a boolean
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	/**
	 * A method that adds the given task list to taskLists and updates isChanged to
	 * true. Also checks that the name of the given taskList is not a duplicate.
	 * Once added into taskLists, the list is set as the currentTaskList.
	 * 
	 * @param taskList list of type TaskList that will be added to task lists
	 * @throws IllegalArgumentException with message "Invalid name." if the given
	 *                                  taskList name equals "Active Tasks"
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
	 * 
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
		String[] lists = new String[taskLists.size() + 1];
		if (taskLists.size() == 0) {
			lists = new String[1];
			lists[0] = activeTaskList.getTaskListName();
			return lists;
		} else {
			for (int i = 0; i < taskLists.size(); i++) {
				lists[0] = activeTaskList.getTaskListName();
				lists[i + 1] = taskLists.get(i).getTaskListName();
			}
		}

		return lists;
	}

	/**
	 * Maintains the active task list so that it always have active tasks
	 */
	private void getActiveTaskList() {
		// clear the active task list
		activeTaskList.clearTasks();
		// go through each task list and each active task back into activeTaskList
		for (int i = 0; i < taskLists.size(); i++) {
			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if (taskLists.get(i).getTask(j).isActive()) {
					activeTaskList.addTask(taskLists.get(i).getTask(j));
				}
			}
		}
	}

	/**
	 * A method that sets the currentTaskList to the AbstractTaskList with the given
	 * name. If a TaskList with that name is not found, then the currentTaskList is
	 * set to the activeTaskList
	 * 
	 * @param listName a string that holds taskName
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
	 * @return an AbstracttaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}

	/**
	 * A method that edits the currentTaskLists name.
	 * 
	 * @param taskListName is a string value of a taskListName
	 */
	public void editTaskList(String taskListName) {
		if (taskListName == null || "".equals(taskListName)
				|| taskListName.compareToIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME) == 0) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (currentTaskList.getTaskListName().compareToIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME) == 0) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		isDuplicate(taskListName);

		// store value of the current task list
		TaskList temp = (TaskList) currentTaskList;
		// remove list from notebook
		this.removeTaskList();
		// set the name to the one given
		temp.setTaskListName(taskListName);
		// add back into notebook so that it is kept in sorted order
		this.addTaskList(temp);
		setChanged(true);
	}

	/**
	 * A method that removes the currentTask list and then sets to the
	 * activeTaskList and also the boolean isChaged is updated to true.
	 */
	public void removeTaskList() {
		if (currentTaskList.getTaskListName().compareToIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME) == 0) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}

		for (int i = 0; i < taskLists.size(); i++) {
			if (currentTaskList.getTaskListName().equals(taskLists.get(i).getTaskListName())) {
				taskLists.remove(i);
			}
		}
		setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		setChanged(true);
	}

	/**
	 * A method that adds a task to the taskList
	 * 
	 * @param t is a Task
	 */
	public void addTask(Task t) {
		if (!(currentTaskList instanceof TaskList)) {
			return;
		} else {
			currentTaskList.addTask(t);
			if (t.isActive()) {
				activeTaskList.addTask(t);
			}
		}
		// make sure active task list is maintained
		getActiveTaskList();

		setChanged(true);
	}

	/**
	 * A method that edits a given task in the currentTask list.
	 * 
	 * @param idx             is an integer that represents the index of a task
	 * @param taskName        is a string that represents the name of a task
	 * @param taskDescription is a string that represents the description of a task
	 * @param recurring       is a boolean that indicates if the task is recurring
	 *                        or not
	 * @param active          is a boolean that indicates if the task is active or
	 *                        not
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		if (!(currentTaskList instanceof TaskList)) {
			return;
		}
		// record active state before being edited to prevent being added again
		boolean wasActive = false;
		if (currentTaskList.getTask(idx).isActive()) {
			wasActive = true;
		}

		currentTaskList.getTask(idx).setTaskName(taskName);
		currentTaskList.getTask(idx).setTaskDescription(taskDescription);
		currentTaskList.getTask(idx).setRecurring(recurring);
		currentTaskList.getTask(idx).setActive(active);

		if (!wasActive && currentTaskList.getTask(idx).isActive()) {
			activeTaskList.addTask(currentTaskList.getTask(idx));
		}

		// make sure active task list is maintained
		getActiveTaskList();

		setChanged(true);
	}

}