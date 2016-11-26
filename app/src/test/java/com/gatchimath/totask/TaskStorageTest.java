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
public class TaskStorageTest {
	
	private Activity activity;
	
	private TaskStorage storage;
	
	public TaskStorageTest() {
		activity = Robolectric.buildActivity(TaskActivity.class).create().get();
		storage = new TaskStorage(activity);
	}
	
	@Before
	public void init() {
		ShadowLog.stream = System.out;
	}
	
	@Test
	public void test() {
		storage = new TaskStorage(activity);
	}
	
	@Test
	public void testAddAndRemoveTask() {
		Task task1 = new Task("beep boop", "");
		Task task2 = new Task("yello", "barf");
		task1.setDone();
		storage.add(task1);
		storage.add(task2);
		
		if (storage.remove(task1)) ShadowLog.v("taskTest", "task1 removed");
		if (storage.remove(task2)) ShadowLog.v("taskTest", "task2 removed");
	}
}
