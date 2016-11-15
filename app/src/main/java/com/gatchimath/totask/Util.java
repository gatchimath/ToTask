package com.gatchimath.totask;

import android.util.Log;	
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Class for miscellaneous features.
 */
public class Util {

	/** Tag used for debugging. */
	public static final String TAG = "ToTask";
	
	static String inputStreamToString(InputStream in, String encoding) throws UnsupportedEncodingException {
		/**
		 * This method was made to easily create JSON objects from files using the
		 * JSON library included in the Android API, which unfortunately cannot create
		 * objects directly from files or strings, like other implementations of org.json do.
		 * And replacing Android's org.json with another org.json package proved to be a pain.
		 *
		 * Only use this method for streams of characters.
		 * 
		 * @param in        Stream of characters to be converted to a String.
		 * @param encoding  Encoding of the string.  Probably UTF-8.
		 *
		 * @return          A string, unless the input is bad. Then it returns an error.
		 */
		
		try {
			// Convert input stream to a string
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, encoding));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			
			while ((inputStr = streamReader.readLine()) != null) {
				responseStrBuilder.append(inputStr);
			}
			
			return responseStrBuilder.toString();
		}
		catch (IOException e) {
			Log.wtf(Util.TAG, "inputStreamToString encountered an IOException");
			Log.wtf(Util.TAG, e.getMessage());
			return "IOException";
		}
	}	
}