package com.gatchimath.totask;

interface Task {
	/**
	 * @return The name and main content of the task.
	 */
	String getName();
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	String getText();
	
	/**
	 * @return True if the task is done, false if not.
	 */
	boolean isChecked();
	
	/**
	 * @param name  The name and main content of this task.
	 */
	void setName(String name);
	
	/**
	 * @param text  Any additional details pertinent to the task.
	 */
	void setText(String text);
	
	/**
	 * @param value  True if the task has been finished, false if otherwise.
	 */
	void setChecked(boolean value);
}
