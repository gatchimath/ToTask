package com.gatchimath.totask;

import android.provider.BaseColumns;

public final class TaskSqlContract {
	private TaskSqlContract() {}
	
	public static class TaskEntry implements BaseColumns {
		public static final String TABLE_NAME = "tasks";
		public static final String COLUMN_NAME_TITLE = "title";
		public static final String COLUMN_NAME_SUBTITLE = "subtitle";
	}
}
