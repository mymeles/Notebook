/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

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
	 * Constructs the Task with the given parameters. The taskLists field is
	 * constructed to an empty SwapList of AbstractTaskLists.
	 * 
	 * @param taskName        name of the task
	 * @param taskDescription description of task
	 * @param recurring       recurring state of task
	 * @param active          active state of class
	 * 
	 * @throws IllegalArgumentException with the message "Incomplete task
	 *                                  information." if either taskName or
	 *                                  TaskDiscription are null or empty.
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		setRecurring(recurring);
		setActive(active);
		taskLists = new SwapList<AbstractTaskList>();
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
	 * Checks for a valid task name and sets it to field Throws an IAE if null or
	 * empty string with message "Incomplete task information."
	 * 
	 * @param taskName name of task
	 * 
	 * @throws IllegalArgumentException if the taskName is null or empty
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || "".equals(taskName)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
	}

	/**
	 * Getter for task description
	 * 
	 * @return description of task
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Private helper method that checks for a valid task description. Throws an IAE
	 * if null with message "Incomplete task information."
	 * 
	 * @param taskDescription description of task
	 * 
	 * @throws IllegalArgumentException with the message "Incomplete task
	 *                                  information."
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = taskDescription;
	}

	/**
	 * Getter for the recurring status of task
	 * 
	 * @return true if recurring, else false
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Sets the recurring status for the task
	 * 
	 * @param recurring recurring state of task
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * Getter for the active status of task
	 * 
	 * @return active field that was set to true or false
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Setter for active status of task
	 * 
	 * @param active active state of task
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Retrieves the taskList name from the taskLists at index 0.
	 * 
	 * @return A string if a TaskList name
	 */
	public String getTaskListName() {
		if (taskLists == null || taskLists.size() == 0) {
			return "";
		} else {
			return taskLists.get(0).getTaskListName();
		}
	}

	/**
	 * Adds AbstractTaskLists to the classes taskLists.
	 * 
	 * @param list AbstractTaskList to be added to taskLists
	 * 
	 * @throws IllegalArgumentException with the message "Incomplete task
	 *                                  information.", if the list is null.
	 */
	public void addTaskList(AbstractTaskList list) {
		if (list == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		// check that the list exists within taskLists
		for (int i = 0; i < taskLists.size(); i++) {
			if (list.getTaskListName().equals(taskLists.get(i).getTaskListName())) {
				return; // throw an exception
			}
		}
		// if list doesn't exist in taskLists, add to taskLists
		taskLists.add(list);
	}

	/**
	 * A method that marks Tasks complete. If the task to be completed is recurring
	 * then the task is cloned and added to every taskLists elements. Also the Tasks
	 * are competed by calling the of the tasks from the method
	 * AbstractTaskList.completeTask().
	 * 
	 * @throws CloneNotSupportedException if clone cannot be created.
	 */
	public void completeTask() {
		Task clone = null;
		// check if task is recurring
		boolean isRecurring = false;
		if (this.isRecurring()) {
			isRecurring = true;
			try {
				clone = this.clone();
			} catch (CloneNotSupportedException e) {
				//
			}
		}

		for (int i = 0; i < taskLists.size(); i++) {
			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if (this == taskLists.get(i).getTask(j)) {
					taskLists.get(i).completeTask(this);
					if (isRecurring && clone != null) {
						taskLists.get(i).addTask(clone);
					}
					break;
				}
			}
		}
	}

	/**
	 * Returns a copy of the Task.
	 * 
	 * @return cloned object
	 * 
	 * @throws CloneNotSupportedException with the message "Cannot clone." if there
	 *                                    are no AbstractTaskLists registered with
	 *                                    the Task.
	 */
	public Task clone() throws CloneNotSupportedException {
		for (int i = 0; i < taskLists.size(); i++) {
			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if (taskLists.get(i).getTask(j).getTaskName().equals(taskName)) {
					// create new swapList
					ISwapList<AbstractTaskList> lists = new SwapList<AbstractTaskList>();
					// store the lists in a new swapList
					lists = taskLists;
					// create duplicate task from everything given
					Task clonedTask = new Task(taskName, taskDescription, recurring, active);
					// add each of the stored lists into the swaplist created in the new Task
					for (int k = 0; k < lists.size(); k++) {
						clonedTask.addTaskList(lists.get(i));
					}
					// return the cloned task
					return clonedTask;
				}
			}
		}
		throw new CloneNotSupportedException("Cannot clone.");
	}

	/**
	 * Returns a string representation of the Task for printing to a file.
	 * 
	 * @return A string of the classes representation.
	 */
	public String toString() {
		if (isActive() && !isRecurring()) {
			return "* " + getTaskName() + ",active\n" + getTaskDescription();
		} else if (isRecurring() && !isActive()) {
			return "* " + getTaskName() + ",recurring\n" + getTaskDescription();
		} else if (isRecurring() && isActive()) {
			return "* " + getTaskName() + ",recurring,active\n" + getTaskDescription();
		} else {
			return "* " + getTaskName() + "\n" + getTaskDescription();
		}
	}

}