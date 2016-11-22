package com.gatchimath.totask;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

public class TaskView extends CardView {
	public TaskView(Context context) {
		super(context);
		setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		LayoutInflater.from(context).inflate(R.layout.task, this);
	}
}
