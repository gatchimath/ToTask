package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	 * Convert task to JSON/gson, then to string for easy
	 * writing.
	 *
	 * @param task  Task to write to file.
	 */
	public void storeTask(Task task) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(task);
		storeString(jsonString);
	}
}