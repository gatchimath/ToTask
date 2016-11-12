package com.gatchimath.totask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Basic task class.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class Task {

	private String name;
	private String text;
	private boolean doneState;
	
	/**
	 * @param name  The name and main content of this task.
	 * @param text  Any additional details pertinent to the task.
	 */
	public Task(String name, String text) {
		this.name = name;
		this.text = text;
		this.doneState = false;
	}
	
	/**
	 * @return The name and main content of the task.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name  The name and main content of this task.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text  Any additional details pertinent to the task.
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * @return True if the task is done, false if not.
	 */
	public boolean isDone() {
		return doneState;
	}
	
	/**
	 * Mark the task as done.
	 */
	public void setDone() {
		setDoneState(true);
	}
	
	/**
	 * @param value  True if the task has been finished, false if otherwise
	 */
	public void setDoneState(boolean value) {
		doneState = value;
	}
	
	/**
	 * Toggles the done state of the task.
	 */
	public void toggleDoneState() {
		doneState = !doneState;
	}
	
	/**
	 * Produces a JSONObject representation of the task.
	 *
	 * @return json  JSON object representation of the task.
	 */
	public JSONObject getJSONObject() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("details", text);
		return json;
	}
}
