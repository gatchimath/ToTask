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
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class TaskStorageTest {
	
	private Activity activity;
	
	private TaskStorage storage;
	
	public TaskStorageTest() {
		activity = Robolectric.buildActivity(TaskActivity.class).create().get();
		try {
			storage = new TaskStorage(activity);
		}
		catch (TaskException e) {
			ShadowLog.e("tasktest", "Cant initialize TaskStorage.");
		}
	}
	
	@Before
	public void init() {
		ShadowLog.stream = System.out;
	}
	
	@Test
	public void test() {
		try {
			storage = new TaskStorage(activity);
		}
		catch (TaskException e) {
			ShadowLog.e("tasktest", "Cant initialize TaskStorage");
		}
	}
	
	@Test
	public void testAddAndRemoveTask() {
		Task task1 = new Task("beep boop", "");
		Task task2 = new Task("yello", "barf");
		task1.setDone();
		
		try {
			storage.add(task1);
			storage.add(task2);
		}
		catch (TaskException e) {
			ShadowLog.e("tasktest", "Cant add tasks");
		}
		
		try {
			storage.remove(task1);
			storage.remove(task2);
		}
		catch (TaskException e) {
			ShadowLog.e("tasktest", "Cant remove tasks");
		}
	}
	
	@Test
	public void testAddTasks() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList.add(new Task("beebeeb", "butt"));
		taskList.add(new Task("hahahahahhahhahahah", ""));
		try {
			storage.addTasks(taskList);
		}
		catch (TaskException e) {
			ShadowLog.e("tasktest", "Cant add task");
		}
		
		taskList = storage.getTasks();
		try {
			Task task1 = taskList.get(0);
			Task task2 = taskList.get(1);
			assertEquals("beebeeb", task1.getName());
			assertEquals("butt", task1.getDetails());
			assertEquals(false, task1.isDone());
			assertEquals("hahahahahhahhahahah", task2.getName());
			assertEquals("", task2.getDetails());
			assertEquals(false, task2.isDone());
		}
		catch (NullPointerException e) {
			ShadowLog.e("tasktest", "Tasks missing");
		}
	}
}
