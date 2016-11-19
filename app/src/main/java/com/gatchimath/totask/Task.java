package com.gatchimath.totask;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Basic task class.
 *
 * @author  gatchi (github.com/gatchi)
 */
public class Task extends BaseObservable {

	private String name;
	private String details;
	private boolean doneState;
	
	/**
	 * @param name  The name and main content of this task.
	 * @param details  Any additional details pertinent to the task.
	 */
	public Task(String name, String details) {
		this.name = name;
		this.details = details;
		this.doneState = false;
	}
	
	/**
	 * @return The name and main content of the task.
	 */
	@Bindable
	public String getName() {
		return name;
	}
	
	/**
	 * @return Any additional details pertinent to the task.
	 */
	@Bindable
	public String getDetails() {
		return details;
	}
	
	/**
	 * @return True if the task is done, false if not.
	 */
	@Bindable
	public boolean isDone() {
		return doneState;
	}
	
	/**
	 * @param name  The name and main content of this task.
	 */
	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}	
	
	/**
	 * @param details  Any additional details pertinent to the task.
	 */
	public void setDetails(String details) {
		this.details = details;
		notifyPropertyChanged(BR.details);
	}
	
	/**
	 * Mark the task as done.
	 */
	public void setDone() {
		setDoneState(true);
		notifyPropertyChanged(BR.done);
	}
	
	/**
	 * @param value  True if the task has been finished, false if otherwise
	 */
	public void setDoneState(boolean value) {
		doneState = value;
		notifyPropertyChanged(BR.done);
	}
	
	/**
	 * Toggles the done state of the task.
	 */
	public void toggleDoneState() {
		doneState = !doneState;
		notifyPropertyChanged(BR.done);
	}
}
