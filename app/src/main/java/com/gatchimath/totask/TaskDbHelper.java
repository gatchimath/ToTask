package com.gatchimath.totask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDbHelper extends SQLiteOpenHelper {
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ENTRIES =
		"CREATE TABLE " + TaskSqlContract.TaskEntry.TABLE_NAME + " (" +
		TaskSqlContract.TaskEntry._ID + " INTEGER PRIMARY KEY," +
		TaskSqlContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
		TaskSqlContract.TaskEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE + " )";
		
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
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//@todo
	}
}
