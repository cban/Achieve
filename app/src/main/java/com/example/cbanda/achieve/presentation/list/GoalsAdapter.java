package com.example.cbanda.achieve.presentation.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalViewHolder> {

    private List<Goal> goals;


    public GoalsAdapter(List<Goal> goals) {
        this.goals = goals;

    }

    @Override
    public GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_goal, parent, false);
        return new GoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GoalViewHolder holder, int position) {
        if (goals != null) {


            Goal goal = goals.get(position);
            holder.GoalTextView.setText(goal.getDescription());
            holder.PriorityTextView.setText(goal.getPriority());
        } else {
            // Covers the case of data not being ready yet.
            holder.GoalTextView.setText("nothing");
            holder.PriorityTextView.setText("nothing");
        }

    }

    @Override
    public int getItemCount() {
        if (goals == null) {
            return 0;
        }
        return goals.size();

    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
        notifyDataSetChanged();
    }

    public class GoalViewHolder extends RecyclerView.ViewHolder {

        TextView GoalTextView;
        TextView PriorityTextView;

        public GoalViewHolder(View view) {
            super(view);
            GoalTextView = (TextView) view.findViewById(R.id.descriptionTextView);
            PriorityTextView = (TextView) view.findViewById(R.id.priorityTextView);
        }

    }
}
