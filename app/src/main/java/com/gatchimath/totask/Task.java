package com.gatchimath.totask;

interface Task {
	
	void setName(String name);		// Set the name (simple description)
	
	void setText(String text);		// Set details, if any
	
	void toggleChecked();			// Toggle done status
	
	void setChecked(boolean value);	// Set done status
	
	String getName();				// Return the name
	
	String getText();				// Return the details, if any
	
	boolean isChecked();			// Return "done" status
}