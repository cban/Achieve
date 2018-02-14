package com.example.cbanda.achieve.presentation.detail;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.cbanda.achieve.R;
import com.example.cbanda.achieve.models.db.Goal;

import org.joda.time.DateTime;

public class GoalDetailActivity extends AppCompatActivity {
    GoalDetailViewModel goalDetailViewModel;
    TextView textViewDetailDescription;
    TextView textViewDetailPriority;
    TextView textViewStartDate;
    TextView textViewEndDate;
    TextView textViewDaysLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeViews();
        int id = getIntent().getExtras().getInt("Goal");

        goalDetailViewModel = ViewModelProviders.of(this).get(GoalDetailViewModel.class);
        goalDetailViewModel.getGoalById(id).observe(this, new Observer<Goal>() {
            @Override
            public void onChanged(@Nullable Goal goal) {
                DateTime start_time = new DateTime(goal.getStartDate());
                DateTime end_time = new DateTime(goal.getEndDate());
                long diffInMillis = end_time.getMillis() - start_time.getMillis();
                long days = (diffInMillis / (60 * 60 * 24 * 1000));
                textViewDetailDescription.setText(goal.getDescription());
                textViewDetailPriority.setText(goal.getPriority());
                textViewStartDate.setText(start_time.dayOfMonth().getAsText() + " " + start_time.monthOfYear().getAsText() + " " + start_time.year().getAsText());
                textViewEndDate.setText(end_time.dayOfMonth().getAsText() + " " + end_time.monthOfYear().getAsText() + " " + end_time.year().getAsText());
                textViewDaysLeft.setText(String.valueOf(days) + " Days");

            }
        });
    }

    public void initializeViews() {
        textViewDetailDescription = findViewById(R.id.textview_detail_description);
        textViewDetailPriority = findViewById(R.id.textview_detail_priority);
        textViewStartDate = findViewById(R.id.textview_detail_startdate);
        textViewEndDate = findViewById(R.id.textview_detail_end_date);
        textViewDaysLeft = findViewById(R.id.textview_days_left);
    }

}
