package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Class for the list of active tasks
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public abstract class AbstractTaskList {

	/** name of task list */
	private String taskListName;
	/** number of completed tasks */
	private int completedCount;
	/** list of tasks */
	private ISwapList<Task> tasks;

	/**
	 * Sets the fields from the parameters and constructs a SwapList for the Tasks.
	 * An IAE is thrown with the message “Invalid name.” if the taskListName is null
	 * or empty string. An IAE is thrown with the message “Invalid completed count.”
	 * if the completedCount is less than zero.
	 * 
	 * @param taskListName   name of task list
	 * @param completedCount number of completed tasks in list
	 */
	public AbstractTaskList(String taskListName, int completedCount) {

	}

	/**
	 * Getter for the task list name
	 * 
	 * @return task list name
	 */
	public String getTaskListName() {
		return "";
	}

	/**
	 * Setter for the task list name
	 * 
	 * @param taskListName name of the task list
	 */
	public void setTaskListName(String taskListName) {

	}

	/**
	 * Returns the list of tasks at the given index
	 * 
	 * @return list of tasks
	 */
	public ISwapList<Task> getTasks() {
		return null;
	}

	/**
	 * Gets the amount of completed tasks in list
	 * 
	 * @return amount of completed tasks
	 */
	public int getCompletedCount() {
		return 0;
	}

	/**
	 * Adds the Task to the end of the list. The current instance of the TaskList
	 * adds itself to the Task (use the keyword this)
	 * 
	 * @param task task to add to list
	 */
	public void addTask(Task task) {

	}

	/**
	 * Removes the Task from the list of tasks and returns the removed task
	 * 
	 * @param index index of the task
	 * @return the removed task
	 */
	public Task removeTask(int index) {
		return null;
	}

	/**
	 * Returns the Task at the given index
	 * 
	 * @param index index of the task within the list
	 * @return task
	 */
	public Task getTask(int index) {
		return null;
	}

	/**
	 * Finds the given Task in the list and removes it. The completedCount is
	 * incremented.
	 * 
	 * @param task task that will be set as complete
	 */
	public void completeTask(Task task) {

	}

	/**
	 * An abstract method that returns a 2D String array
	 * 
	 * @return string 2D array of tasks in list
	 */
	public abstract String[][] getTasksAsArray();

}
