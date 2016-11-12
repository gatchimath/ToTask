package com.gatchimath.totask;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
	
	public void storeTask(Task task) {
		// @todo
	}
	
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