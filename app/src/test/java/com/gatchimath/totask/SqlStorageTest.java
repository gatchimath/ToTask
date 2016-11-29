package com.gatchimath.totask;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.annotation.Config;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowLog;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SqlStorageTest {
	
	private Activity activity;
	private SQLiteDatabase db;
	private SqlStorage storage;
	
	public SqlStorageTest() {
		activity = Robolectric.buildActivity(TaskActivity.class).create().get();
		TaskDbHelper helper = new TaskDbHelper(activity);
		db = helper.getWritableDatabase();
		storage = new SqlStorage(activity, db);
	}
	
	@Before
	public void init() {
		ShadowLog.stream = System.out;
	}
	
	@Test
	public void testTaskWriteAndDelete() throws Exception {
		Task inputTask1 = new Task("yogababa", "beets");
		Task inputTask2 = new Task("store", "go to the motherfucking store");
		inputTask2.setDone();
		storage.writeTask(inputTask1);
		storage.writeTask(inputTask2);
		
		storage.deleteTask(inputTask1);
		storage.deleteTask(inputTask2);
		storage.deleteTask(new Task("uh oh", ""));
	}

	@Test
	public void testClearTable() throws Exception {
		Task task1 = new Task("ehe", "gross");
		task1.setDone();
		Task task2 = new Task("this is a task", "");
		storage.writeTask(task1);
		storage.writeTask(task2);
		int result = storage.clearTable();
		ShadowLog.v("test", "rows deleted: " + Integer.toString(result));
	}
	
	@Test
	public void testRetrieveAllTasks() throws Exception {
		Task inputTask1 = new Task("harry", "met sally");
		inputTask1.setDone();
		Task inputTask2 = new Task("butto", "");
		storage.writeTask(inputTask1);
		storage.writeTask(inputTask2);
		
		ArrayList<Task> taskList = storage.retrieveAllTasks();
		Task outputTask1 = taskList.get(0);
		assertEquals(inputTask1.getName(), outputTask1.getName());
		assertEquals(inputTask1.getDetails(), outputTask1.getDetails());
		assertEquals(inputTask1.isDone(), outputTask1.isDone());
		Task outputTask2 = taskList.get(1);
		assertEquals(inputTask2.getName(), outputTask2.getName());
		assertEquals(inputTask2.getDetails(), outputTask2.getDetails());
		assertEquals(inputTask2.isDone(), outputTask2.isDone());
	}
}
