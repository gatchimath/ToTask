package com.gatchimath.totask;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Basic task class.
 *
 * @author  gatchi (github.com/gatchi)
 */
class Task {
	
	private String name;
	private String text;
	private int id;
	private boolean doneState;
	private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);
	
	Task() {
		this("");
	}
	
	Task(String name) {
		this(name, "");
	}
	
	Task(String name, String text) {
		this.name = name;
		this.text = text;
		this.id = generateId();
		this.doneState = false;
	}
	
	Task(String name, String text, int id) {
		this.name = name;
		this.text = text;
		this.id = id;
		this.doneState = false;
	}
	
	/**
	 * @return The name and main content of the task.
	 */
	String getName() {
		return name;
	}
	
	/**
	 * @param name  The name and main content of this task.
	 */
	void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	String getText() {
		return text;
	}
	
	/**
	 * @param text  Any additional details pertinent to the task.
	 */
	void setText(String text) {
		this.text = text;
	}
	
	/**
	 * @return True if the task is done, false if not.
	 */
	boolean isDone() {
		return doneState;
	}
	
	/**
	 * Mark the task as done.
	 */
	void setDone() {
		doneState = true;
	}
	
	/**
	 * @param value  True if the task has been finished, false if otherwise
	 */
	void setDoneState(boolean value) {
		doneState = value;
	}
	
	/**
	 * Toggles the done state of the task.
	 */
	void toggleDoneState() {
		doneState = !doneState;
	}
	
	/**
	 * @return  The unique ID of the task.
	 */
	int getId() {
		return id;
	}
	
	/**
	 * @param  The unique ID of the task.
	 */
	void setId(int id) {
		this.id = id;
	}
}
