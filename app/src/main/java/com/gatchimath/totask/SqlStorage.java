package com.gatchimath.totask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

/**
 * Represents all task-related SQL storage.
 * <p>
 * Most of the methods here are basically just SQLite commands.
 * This class should only be instantiated in a
 * {@link com.gatchimath.totask.TaskStorage}.
 *
 * @see com.gatchimath.totask.TaskTableEntry,
 *      com.gatchimath.totask.TaskDbHelper
 */
public class SqlStorage {
	
	private TaskDbHelper dbHelper;
	
	public SqlStorage(Context context) {
		dbHelper = new TaskDbHelper(context);
	}
	
	/**
	 * Writes the task to the task table.
	 * More info relating to the task table can be found in the
	 * {@link com.gatchimath.totask.TaskTableEntry} and
	 * {@link com.gatchimath.totask.TaskDbHelper} classes.
	 *
	 * @param task  Task to write to the table.
	 */
	public void writeTask(Task task) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put(TaskTableEntry.COLUMN_NAME_NAME, task.getName());
		values.put(TaskTableEntry.COLUMN_NAME_DET, task.getDetails());
		values.put(TaskTableEntry.COLUMN_NAME_DONE, task.isDone() ? 1 : 0);
		db.insert(TaskTableEntry.TABLE_NAME, null, values);
	}
	
	/**
	 * Returns a list of all the tasks in the table.
	 * @return  ArrayList of Tasks in the table.
	 */
	public ArrayList<Task> retrieveAllTasks() throws IllegalArgumentException {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(
			TaskTableEntry.TABLE_NAME,
			null, null,	null, null,	null, null
		);
		
		// Now exract the info from the cursor
		cursor.moveToFirst();
		ArrayList<Task> taskList = new ArrayList<Task>(cursor.getCount());
		Task task;
		
		int nameColumnIndex = cursor.getColumnIndexOrThrow(TaskTableEntry.COLUMN_NAME_NAME);
		int detailsColumnIndex = cursor.getColumnIndexOrThrow(TaskTableEntry.COLUMN_NAME_DET);
		int doneColumnIndex = cursor.getColumnIndexOrThrow(TaskTableEntry.COLUMN_NAME_DONE);
		
		while (!cursor.isAfterLast()) {
			task = new Task("", "");
			
			task.setName(cursor.getString(nameColumnIndex));	
			task.setDetails(cursor.getString(detailsColumnIndex));
			int taskDoneState = cursor.getInt(doneColumnIndex);
			if (taskDoneState != 0) task.setDoneState(false);
			else task.setDoneState(true);
			
			taskList.add(task);
			cursor.moveToNext();
		}
		return taskList;
	}
	
	/**
	 * Deletes all the rows in the table.
	 */
	public void clearTable() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete(TaskTableEntry.TABLE_NAME, null, null);
	}
}
