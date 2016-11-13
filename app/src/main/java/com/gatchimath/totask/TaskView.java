package com.gatchimath.totask;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.widget.TextView;

public class TaskView extends CardView {
	public TaskView(Context context) {
		super(context);
		setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		LayoutInflater.from(context).inflate(R.layout.task, this);
	}

	public void setText(String text) {
		((TextView)findViewById(R.id.taskTitle)).setText(text);
	}
}
