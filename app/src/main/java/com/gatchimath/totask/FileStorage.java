package com.gatchimath.totask;

import android.content.Context;
import java.io.File;

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
		
	}
	
	public void storeString(String string) {
		
	}
	
	public void close() {
		// @todo
	}
}