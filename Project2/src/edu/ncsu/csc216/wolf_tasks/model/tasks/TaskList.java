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
	 * @param taskListName name of the task list
	 * @param completedCount number of completed tasks in list
	 */
	public TaskList(String taskListName, int completedCount) {
		super(taskListName, completedCount);
	}

	/**
	 * Returns a 2D String array where the first column is the priority of the Task,
	 * starting at 1, and the name of the Task.
	 * 
	 * @return string array of tasks
	 */
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[super.getTasks().size()][2];
		for (int i = 0; i < super.getTasks().size(); i++) {
			taskArray[i][0] = Integer.toString(i + 1);
			taskArray[i][1] = super.getTask(i).getTaskName();
		}
		return taskArray;
	}

	/**
	 * Compares the names of the TaskLists
	 * @param list list that is compared to other lists (names)
	 */
	@Override
	public int compareTo(TaskList list) {
		return this.getTaskListName().compareTo(list.getTaskListName());
	}
} 