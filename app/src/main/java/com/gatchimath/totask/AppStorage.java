package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * Interfaces between objects and app (local file) storage.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class AppStorage {
	
	private File file;
	
	/**
	 * @param context  Application context of the caller.
	 * @param filename Name of the file.
	 */
	public AppStorage(Context context, String filename) {
		file = new File(context.getFilesDir(), filename);
	}
	
	/**
	 * @return  A list of all the tasks kept in app storage.
	 */
	public List<Task> getTaskList() throws JsonSyntaxException {
		Gson gson = new Gson();
		String jsonString = getString("UTF-8");
		Type collectionType = new TypeToken<List<Task>>(){}.getType();
		List<Task> taskList = gson.fromJson(jsonString, collectionType);
		return taskList;
	}
	
	/**
	 * Creates a string representation of the file.
	 * Only works if the contents of the file are characters.
	 *
	 * @param encoding  The character encoding of the file (probably UTF-8)
	 * @return          A string representation of the file.
	 */
	public String getString(String encoding) {
		String fileString;
		try {
			InputStream in = new FileInputStream(file);
			fileString = Util.inputStreamToString(in, encoding);
			return fileString;
		}
		catch (FileNotFoundException e) {
			Log.e(Util.TAG, "Failure in FileStorage.getJSONObject():");
			Log.e(Util.TAG, "File not found.");
			Log.e(Util.TAG, "Message: " + e.getMessage());
			return null;
		}
		catch (UnsupportedEncodingException e) {
			Log.e(Util.TAG, "Failure in FileStorage.getJSONObject():");
			Log.e(Util.TAG, "Target is probably not text.");
			Log.e(Util.TAG, "Message: " + e.getMessage());
			return null;
		}
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
