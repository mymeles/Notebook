package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Class for the list of active tasks
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class ActiveTaskList extends AbstractTaskList {

	/** name of active task list */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
	
	/**
	 * Constructor for the active task list
	 * @param taskListName name of task list
	 * @param completedCount number of completed tasks
	 */
	public ActiveTaskList(String taskListName, int completedCount) {
		super(ACTIVE_TASKS_NAME, completedCount);
	}

	/**
	 * Adds the given task to the active task list
	 * @param task task to be added to list
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * Sets the name of the active task list
	 */
	public void setTaskListName() {
		
	}
	
	/**
	 *  Creates a 2D string array of tasks in the active task list
	 *  @return 2D array of tasks in list
	 */
	public String[][] getTasksAsArray() {
		return null;
	}
	
	/**
	 * Clears the ActiveTaskList of all Tasks
	 */
	public void clearTasks() {
		
	}
	
}
 