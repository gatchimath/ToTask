package com.gatchimath.totask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SqlStorageTest {
	
	@Mock private Context context;
	@Mock private SQLiteDatabase db;
	
	private SqlStorage storage;
	
	public SqlStorageTest() {
		storage = new SqlStorage(context, db);
	}
	
	@Test
	public void testTaskWrite() throws Exception {
		Task task = new Task("", "");
		storage.writeTask(task);
	}
}