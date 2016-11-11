package com.gatchimath.totask;

import java.util.ArrayList;
import java.util.List;

/**
 * When you make a task, you add it to this.
 * When you need an already made task, you get it from this.
 *
 * When tasks are added or removed from this storage object,
 * it does not guarantee synchronousness with other storage
 * sources.  It's just an object.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class TaskStorage {
	
	private ArrayList<Task> taskList;
	
	public TaskStorage() {
		taskList = new ArrayList();
	}

	/**
	 * Adds the task to this storage object.
	 *
	 * @param task  The task to pass into this storage.
	 */
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	/**
	 * Adds a set of tasks to this storage object.
	 *
	 * @param taskList  List of tasks to add.
	 */
	public void addTasks(List<Task> taskList) {
		this.taskList.addAll(taskList);
	}
	
	/**
	 * Returns all the tasks currently stored in the TaskStorage object.
	 * Does not guarantee synchronousness between all storage locations.
	 *
	 * @return  A list of all tasks stored in this task storage.
	 */
	public ArrayList<Task> getTasks() {
		return taskList;
	}
}
