package com.gatchimath.totask;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gatchimath.totask.databinding.TaskBinding;

/**
 * View for a list of tasks. Each task is rendered as a CardView.
 */
public class TaskListView extends RecyclerView {
	public TaskListView(Context context) {
		super(context);
		init(context);
	}

	public TaskListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TaskListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		RecyclerView.LayoutManager taskListLayoutManager = new LinearLayoutManager(context);
		setLayoutManager(taskListLayoutManager);
		addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

		// TODO(mysterymath): Replace this with tasks from model
		mTasks = new Task[3];
		mTasks[0] = new Task("Task A", "Details A");
		mTasks[1] = new Task("Task B", "Details B");
		mTasks[2] = new Task("Task C", "Details C");

		setAdapter(new Adapter());
	}

	/**
	 * The tasks in the list.
	 */
	private Task[] mTasks;

	private class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
		public class ViewHolder extends RecyclerView.ViewHolder {
			public TaskBinding mBinding;

			public ViewHolder(TaskBinding binding) {
				super(binding.getRoot());
				mBinding = binding;
			}
		}

		@Override
		public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			TaskBinding binding =
							TaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
			ViewHolder vh = new ViewHolder(binding);
			return vh;
		}

		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {
			holder.mBinding.setTask(mTasks[position]);
		}

		@Override
		public int getItemCount() {
			return mTasks.length;
		}
	}
}
