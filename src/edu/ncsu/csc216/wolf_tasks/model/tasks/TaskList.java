package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Contains methods that adds functionality for the task lists in the notebook
 * 
 * @author Helen Solomon
 * @author Meles Meles
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Constructor of a task list using
	 * 
	 * @param name name of the task list
	 * @param num  integer field (?)
	 */
	public TaskList(String name, int num) {
		super(name, num);
	}

	/**
	 * Returns a 2D String array where the first column is the priority of the Task,
	 * starting at 1, and the name of the Task.
	 * 
	 * @return string array of tasks
	 */
	public String[][] getTasksAsArray() {
		return null;
	}

	/**
	 * Compares the names of the TaskLists
	 */
	@Override
	public int compareTo(TaskList o) {
		return 0;
	}
}
