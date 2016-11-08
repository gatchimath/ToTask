package com.gatchimath.totask;

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
	
	Task(String name) {
		this.name = name;
		this.text = "";
		//@todo: Generate a unique ID here instead of setting to 0.
		this.id = 0;
		this.doneState = false;
	}
	
	Task(String name, String text) {
		this.name = name;
		this.text = text;
		//@todo  Generate a unique ID here instead of setting to 0.
		this.id = 0;
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
		//@todo
		return null;
	}
	
	/**
	 * @param name  The name and main content of this task.
	 */
	void setName(String name) {
		//@todo
	}
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	String getText() {
		//@todo
		return null;
	}
	
	/**
	 * @param text  Any additional details pertinent to the task.
	 */
	void setText(String text) {
		//@todo
	}
	
	/**
	 * @return True if the task is done, false if not.
	 */
	boolean isDone() {
		//@todo
		return false;
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
		//@todo
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
		//@todo
		return 9999;
	}
	
	/**
	 * @param  The unique ID of the task.
	 */
	void setId(int id) {
		//@todo
	}
}
