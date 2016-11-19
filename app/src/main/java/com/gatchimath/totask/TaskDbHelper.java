package com.gatchimath.totask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper class for dealing with the task table.
 * Should only be used by {@link com.gatchimath.totask.SqlStorage}.
 */
public class TaskDbHelper extends SQLiteOpenHelper {
	private static final String TEXT_TYPE = " TEXT";
	private static final String BOOL_TYPE = " INTEGER";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ENTRIES =
		"CREATE TABLE " + TaskTableEntry.TABLE_NAME + " (" +
		TaskTableEntry._ID + " INTEGER PRIMARY KEY," +
		TaskTableEntry.COLUMN_NAME_1 + TEXT_TYPE + COMMA_SEP +
		TaskTableEntry.COLUMN_NAME_2 + TEXT_TYPE + COMMA_SEP +
		TaskTableEntry.COLUMN_NAME_3 + BOOL_TYPE + " )";
		
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ToTask.db";
	
	public TaskDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
