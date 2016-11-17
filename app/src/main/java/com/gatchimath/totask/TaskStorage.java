package com.gatchimath.totask;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents task-related storage in the app.
 * It's purpose is to broker between other classes and
 * storage classes, like app storage or cloud storage.
 * The rest of the app does not see and should not care
 * where data goes and comes from, it should only see and
 * care about TaskStorage.  Likewise, only TaskStorage gets to
 * care where things go and come from.
 *
 * However, because Tasks [will soon be] Observables, TaskStorages should
 * get very little interaction outside of its world.  It's mainly
 * for adding and removing tasks from storage.
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
	
	/**
	 * Removed the task from storage.
	 * Returns a true if succesfull.
	 *
	 * @return  True if remove is successful.
	 */
	public boolean removeTask(Task task) {
		return taskList.remove(task);
	}
}
