package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.gson.Gson;
import org.json.JSONObject;

/**
 * Interfaces between objects and app (local file) storage.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class FileStorage {
	
	private File file;
	private final String NAME_FIELD = "name";
	private final String TEXT_FIELD = "text";
	
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
		// @todo
	}
	
	/**
	 * @param json  JSONObject to write to file.
	 */
	public void storeJSONObject(JSONObject json) {
		storeString(json.toString());
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
		}
		catch (FileNotFoundException e) {
			Log.e(Util.TAG, "Failure in FileStorage.storeString():");
			Log.e(Util.TAG, "FileNotFound. Check filename?");
			Log.e(Util.TAG, e.getMessage());
		}
		catch (IOException e) {
			Log.wtf(Util.TAG, "Failure in FileStorage.storeString():");
			Log.e(Util.TAG, e.getMessage());
		}
	}
	
	public void close() {
		// @todo
	}
}