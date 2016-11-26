package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.lang.IllegalArgumentException;
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
 * However, because Tasks are Observables, TaskStorage should
 * get very little interaction outside of its world.  It's mainly
 * for adding and removing tasks from storage.
 *
 * Since TaskStorage represents all task related storage, there
 * should never be more than one instance of it at a time.
 * Multiple instances can cause silent sync issues.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class TaskStorage {
	
	private ArrayList<Task> taskList;
	private SqlStorage sqlStorage;
	
	public TaskStorage(Context context) {
		taskList = new ArrayList();
		TaskDbHelper dbHelper = new TaskDbHelper(context);
		sqlStorage = new SqlStorage(context, dbHelper.getWritableDatabase());
		try {
			taskList = sqlStorage.retrieveAllTasks();
		}
		catch (IllegalArgumentException e) {
			Log.e(Util.TAG, "Failure in TaskStorage initialization");
			Log.e(Util.TAG, "Could not retrieve tasks from database");
			Log.e(Util.TAG, e.getMessage());
		}
	}

	/**
	 * Adds the task to this store.
	 *
	 * @param task  The task to pass into storage.
	 */
	public void add(Task task) {
		taskList.add(task);
	}
	
	/**
	 * Adds a list of tasks to this store.
	 *
	 * @param taskList  List of tasks to add.
	 */
	public void addTasks(List<Task> taskList) {
		this.taskList.addAll(taskList);
	}
	
	/**
	 * Returns all the tasks currently stored in this store.
	 *
	 * @return  A list of all tasks in this store.
	 */
	public ArrayList<Task> getTasks() {
		return taskList;
	}
	
	/**
	 * Removes the task from this store.
	 * Returns a false if task isn't in here.
	 *
	 * @return  False if task isn't in this store.
	 */
	public boolean remove(Task task) {
		boolean success = taskList.remove(task);
		try {
			sqlStorage.deleteTask(task);
		}
		catch (NullPointerException e) {
			Log.e(Util.TAG, "Task delete from database failed:");
			Log.e(Util.TAG, "No task to delete");
			Log.e(Util.TAG, e.getMessage());
		}
		return success;
	}
}
