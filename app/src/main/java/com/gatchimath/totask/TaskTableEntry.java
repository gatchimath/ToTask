package com.gatchimath.totask;

import android.provider.BaseColumns;

/**
 * Contract class for the task SQLite database.
 * Used by {@link com.gatchimath.totask.TaskDbHelper} and
 * {@link com.gatchimath.totask.SqlStorage}.
 */
public class TaskTableEntry implements BaseColumns {
	public static final String TABLE_NAME = "tasks";
	public static final String COLUMN_NAME_NAME = "name";
	public static final String COLUMN_NAME_DET = "details";
	public static final String COLUMN_NAME_DONE = "done";
}
