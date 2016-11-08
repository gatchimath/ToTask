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
class TaskStorage {
	
	private ArrayList<Task> taskList;
	
	TaskStorage() {
		taskList = new ArrayList(5);
	}

	/**
	 * Adds the task to this storage object.
	 *
	 * @param task  The task to pass into this storage.
	 */
	void addTask(Task task) {
		taskList.add(task);
	}
	
	/**
	 * Adds a set of tasks to this storage object.
	 *
	 * @param taskList  List of tasks to add.
	 */
	void addTasks(List<Task> taskList) {
		this.taskList.addAll(taskList);
	}

	/**
	 * For retrieving a specific task using it's 	unique ID.
	 * Great for listeners (since they supply a viewId).
	 *
	 * @param id  The task's unique integer ID.
	 * @return    The task requested.
	 */
	Task getTask(int id) {
		//@TODO
		return null;
	}
	
	/**
	 * Returns all the tasks currently stored in the TaskStorage object.
	 * Does not guarantee synchronousness between all storage locations.
	 *
	 * @return  A list of all tasks stored in this task storage.
	 */
	List<Task> getTasks() {
		return taskList;
	}
	
	/**
	 * Removes a task from this storage.
	 *
	 * @param id  Unque ID of the task to remove.
	 */
	void removeTask(int id) {
		//@TODO
	}
}
