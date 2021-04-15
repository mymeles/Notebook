package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

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
	 * An IAE is thrown with the message �Invalid name.� if the taskListName is null
	 * or empty string. An IAE is thrown with the message �Invalid completed count.�
	 * if the completedCount is less than zero.
	 * 
	 * @param taskListName   name of task list
	 * @param completedCount number of completed tasks in list
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		super();
		setTaskListName(taskListName);
		setCompletedCount(completedCount);
		tasks = new SwapList<Task>();
	
	}

	/**
	 * Getter for the task list name
	 * 
	 * @return task list name
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Setter for the task list name
	 * 
	 * @param taskListName name of the task list
	 * 
	 * @throws IllegalArgumentException if the lists name is empty or null. 
	 */
	public void setTaskListName(String taskListName) {
		if(taskListName == null || "".equals(taskListName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		else {
			this.taskListName = taskListName;
		}
		
	}
	
	/**
	 * A method that sets the completed count.
	 * @param count is an integer that represents completed count;
	 * 
	 * @throws IllegalArgumentException if the the completed count is less than zero.
	 */
	private void setCompletedCount(int count) {
		if(count < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		} else{
			this.completedCount = count;
		}
	}

	/**
	 * Returns activetask lists list of tasks 
	 * 
	 * @return list of tasks
	 */
	public ISwapList<Task> getTasks() {
		return tasks;
	}

	/**
	 * Gets the amount of completed tasks in list
	 * 
	 * @return amount of completed tasks
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * Adds the Task to the end of the list. The current instance of the TaskList
	 * adds itself to the Task (use the keyword this).
	 * When a Task is added to a TaskList the TaskList will add itself to the Task via the addTaskList() method.

	 * 
	 * @param task task to add to list
	 * 
	 * 
	 */
	public void addTask(Task task) {
		tasks.add(task);
		//add list to task
		task.addTaskList(this);
	}

	/**
	 * Removes the Task from the list of tasks and returns the removed task
	 * 
	 * @param index index of the task
	 * @return the removed task
	 */
	public Task removeTask(int index) {
		return tasks.remove(index);
	}

	/**
	 * Returns the Task at the given index
	 * 
	 * @param index index of the task within the list
	 * @return task
	 */
	public Task getTask(int index) {
		return tasks.get(index);
	}

	/**
	 * Finds the given Task in the list and removes it. The completedCount is
	 * incremented.
	 * 
	 * @param task task that will be set as complete
	 */
	public void completeTask(Task task) {
		for(int i = 0; i < tasks.size(); i++) {
			if(task == tasks.get(i)) {
				this.tasks.remove(i);
				completedCount++; 
			}
		} 
	}

	/**
	 * An abstract method that returns a 2D String array
	 * 
	 * @return string 2D array of tasks in list
	 */
	public abstract String[][] getTasksAsArray();

}