package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Class for the list of active tasks
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class ActiveTaskList extends AbstractTaskList {

	/** name of active task list */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Constructor for the active task list
	 * 
	 * @param taskListName   name of task list
	 * @param completedCount number of completed tasks
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);

	}

	/**
	 * Adds the given task to the active task list
	 * 
	 * @param task task to be added to list
	 * 
	 * @throws IllegalArgumentException if task is not active.
	 */
	@Override
	public void addTask(Task task) {
		if (!task.isActive()) {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
		super.addTask(task);

	}

	/**
	 * ?????????????????????????????????????????????????????? Sets the name of the
	 * active task list
	 */
	@Override
	public void setTaskListName(String taskListName) {
		if (taskListName == ACTIVE_TASKS_NAME) { 
			super.setTaskListName(taskListName);
		} else {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
	}

	/**
	 * Creates a 2D string array of tasks in the active task list
	 * 
	 * @return 2D array of tasks in list
	 */
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[super.getTasks().size()][2]; 
		for (int i = 0; i < super.getTasks().size(); i++) {
			taskArray[i][0] = super.getTasks().get(i).getTaskListName();
			taskArray[i][1] = super.getTasks().get(i).getTaskName();
		}
		return taskArray;
	}

	/**
	 * Clears the ActiveTaskList of all Tasks
	 */
	public void clearTasks() {
		//store the original size so that we can reach all tasks in listS
		int size = super.getTasks().size();
		for (int i = size - 1; i >= 0; i--) {
			super.getTasks().remove(i);
		}
	}
 
}
