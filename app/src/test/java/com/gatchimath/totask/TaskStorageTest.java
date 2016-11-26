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
	}
	
	@Before
	public void init() {
		ShadowLog.stream = System.out;
	}
	
	@Test
	public void test() {
		TaskStorage storage = new TaskStorage(activity);
	}
}
