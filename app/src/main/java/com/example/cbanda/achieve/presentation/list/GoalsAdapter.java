package com.example.cbanda.achieve.presentation.list;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;

import static android.content.ContentValues.TAG;


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalViewHolder> {

    private List<Goal> goals;
    com.example.cbanda.achieve.presentation.list.customItemClickListener customItemClickListener;
    public static final String MEDIUM = "Medium";
    public static final String HIGH = "High";
    public static final String LOW = "Low";


    public GoalsAdapter(List<Goal> goals, com.example.cbanda.achieve.presentation.list.customItemClickListener listener) {
        this.goals = goals;
        customItemClickListener = listener;

    }

    @Override
    public GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_goal, parent, false);
        final GoalViewHolder goalViewHolder = new GoalViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customItemClickListener.onItemClick(v, goalViewHolder.getPosition());
            }
        });
        return goalViewHolder;
    }

    @Override
    public void onBindViewHolder(final GoalViewHolder holder, int position) {
        if (goals != null) {
            LayerDrawable layerDrawable = (LayerDrawable) holder.itemView.getContext().getResources()
                    .getDrawable(R.drawable.rectangle_stroke);
            GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable
                    .findDrawableByLayerId(R.id.gradientDrawable);

            Goal goal = goals.get(position);
            if (goal.getPriority().equalsIgnoreCase(HIGH) == true) {

                gradientDrawable.setColor(Color.GREEN);
            } else if (goal.getPriority().equalsIgnoreCase(MEDIUM) == true) {
                gradientDrawable.setColor(Color.RED);
            } else if (goal.getPriority().equalsIgnoreCase(LOW) == true) {
                gradientDrawable.setColor(Color.YELLOW);
            }
            holder.itemView.setTag(goal);
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

    public class GoalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView GoalTextView;
        TextView PriorityTextView;

        public GoalViewHolder(View view) {
            super(view);
            GoalTextView = (TextView) view.findViewById(R.id.descriptionTextView);
            PriorityTextView = (TextView) view.findViewById(R.id.priorityTextView);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick " + getItemId());

        }

    }
}
