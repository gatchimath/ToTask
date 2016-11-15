package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

/**
 * Interfaces between objects and app (local file) storage.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class FileStorage {
	
	private File file;
	
	/**
	 * @param context  Application context of the caller.
	 * @param filename Name of the file.
	 */
	public FileStorage(Context context, String filename) {
		file = new File(context.getFilesDir(), filename);
	}	
	
	/**
	 * Convert object to JSON/gson, then to string for easy
	 * writing.
	 *
	 * @param obj  Object to write to file.
	 */
	public void storeObject(Object obj) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(obj);
		storeString(jsonString);
	}
	
	/**
	 * Store list of tasks to file storage.
	 *
	 * @param taskList  List of tasks to store.
	 */
	public void storeTaskList(List<Task> taskList) {
		storeObject(taskList);
	}
	
	/**
	 * Easy simple way of storing objects that can be
	 * converted to strings.  Or for saving strings directly.
	 *
	 * @param string  String to write to file.
	 */
	public void storeString(String string) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(string.getBytes());
			try {
				fos.close();
			}
			catch (IOException e) {
				Log.wtf(Util.TAG, "Failure in FileStorage.close():");
				Log.wtf(Util.TAG, "Not sure what happened. Did file disappear?");
				Log.wtf(Util.TAG, "Message: " + e.getMessage());
			}
		}
		catch (FileNotFoundException e) {
			Log.e(Util.TAG, "Failure in FileStorage.storeString():");
			Log.e(Util.TAG, "FileNotFound. Check filename?");
			Log.e(Util.TAG, "Message: " + e.getMessage());
		}
		catch (IOException e) {
			Log.wtf(Util.TAG, "Failure in FileStorage.storeString():");
			Log.e(Util.TAG, "Message: " + e.getMessage());
		}
	}
}
