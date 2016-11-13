package com.gatchimath.totask;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private String[] mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TaskView taskView;

		// each data item is just a string in this case
		public ViewHolder(TaskView v) {
			super(v);
			taskView = v;
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(String[] myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		TaskView v = new TaskView(parent.getContext());
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.taskView.setText(mDataset[position]);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.length;
	}
}
