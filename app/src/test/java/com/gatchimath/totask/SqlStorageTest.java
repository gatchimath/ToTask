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
	public void testTaskWrite() throws Exception {
		Task inputTask1 = new Task("butts", "buttssssssssssssssss");
		Task inputTask2 = new Task(":P", "");
		inputTask2.setDone();
		storage.writeTask(inputTask1);
		storage.writeTask(inputTask2);
	}

	@Test
	public void testClearTable() throws Exception {
		storage.clearTable();
	}
	
	@Test
	public void testRetrieveAllTasks() throws Exception {
		Task inputTask = new Task("harry", "met sally");
		inputTask.setDone();
		storage.writeTask(inputTask);
		ArrayList<Task> taskList = storage.retrieveAllTasks();
		Task outputTask = taskList.get(0);
		assertEquals(inputTask.getName(), outputTask.getName());
		assertEquals(inputTask.getDetails(), outputTask.getDetails());
		assertEquals(inputTask.isDone(), outputTask.isDone());
	}
}
