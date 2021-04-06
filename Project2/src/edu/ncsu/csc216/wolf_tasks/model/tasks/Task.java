/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Task class contains the information about each individual task including the
 * taskName, taskDescription, if the task is recurring, and if the task is
 * active. The Task additionally contains an ISwapList of AbstractTaskLists
 * called taskLists. The Task class implements the Cloneable interface.
 * 
 * @author Meles Meles
 * @author Helen Solomon
 *
 */
public class Task implements Cloneable {

	/** name of the task */
	private String taskName;
	/** description of task */
	private String taskDescription;
	/** recurring state of task */
	private boolean recurring;
	/** active state of class */
	private boolean active;
	/** list of task lists */
	private ISwapList<AbstractTaskList> taskLists;

	/**
	 * Constructor of task with all fields
	 * 
	 * @param taskName        name of the task
	 * @param taskDescription description of task
	 * @param recurring       recurring state of task
	 * @param active          active state of class
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {

	}

	/**
	 * Getter for task name
	 * 
	 * @return name of task
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Checks for a valid task name and sets it to field
	 * Throws an IAE if null or empty string with message "Incomplete task information."
	 * 
	 * @param taskName name of task
	 */
	public void setTaskName(String taskName) {
		
	}

	/**
	 * Getter for task description
	 * 
	 * @return description of task
	 */
	public String getTaskDescription() {
		return "";
	}

	/**
	 * Private helper method that checks for a valid task description.
	 * Throws an IAE if null with message "Incomplete task information."
	 * 
	 * @param taskDescription description of task
	 */
	public void setTaskDescription(String taskDescription) {

	}

	/**
	 * Getter for the recurring status of task
	 * 
	 * @return true if recurring, else false
	 */
	public boolean isRecurring() {
		return false;
	}

	/**
	 * Sets the recurring status for the task
	 * 
	 * @param recurring recurring state of task
	 */
	public void setRecurring(boolean recurring) {

	}

	/**
	 * Getter for the active status of task
	 * 
	 * @return active field that was set to true or false
	 */
	public boolean isActive() {
		return false;
	}

	/**
	 * Setter for active status of task
	 * 
	 * @param active active state of task
	 */
	public void setActive(boolean active) {

	}

	/**
	 * Gets the name of list task is in
	 * 
	 * @return task list name
	 */
	public String getTaskListName() {
		return "";
	}

	/**
	 * Adds task list to notebook
	 * 
	 * @param list list to be added to notebook
	 */
	public void addTaskList(AbstractTaskList list) {

	}
	
	/**
	 * Sets task as complete
	 */
	public void completeTask() {
		
	}
	
	/**
	 * Returns a copy of the Task.
	 * If there are no AbstractTaskLists registered with the Task then a CloneNotSupportedException is thrown with the message “Cannot clone.”. 
	 * @return cloned object
	 */
	public Object clone() {
		return null;
	}
	
	/**
	 * Returns a string representation of the Task for printing to a file.
	 * @return fields of task in string format
	 */
	public String toString() {
		return "";
	}
	
	

}
