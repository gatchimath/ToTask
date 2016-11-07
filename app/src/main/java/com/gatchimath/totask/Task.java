package com.gatchimath.totask;

interface Task {
	/**
	 * @return The name and main content of the task.
	 */
	String getName();
	
	/**
	 * @param name  The name and main content of this task.
	 */
	void setName(String name);
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	String getText();
	
	/**
	 * @param text  Any additional details pertinent to the task.
	 */
	void setText(String text);
	
	/**
	 * @return True if the task is done, false if not.
	 */
	boolean isChecked();
	
	/**
	 * @param value  True if the task has been finished, false if otherwise
	 */
	void setChecked(boolean value);
}
