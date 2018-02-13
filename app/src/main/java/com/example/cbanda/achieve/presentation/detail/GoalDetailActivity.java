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

public class GoalDetailActivity extends AppCompatActivity {
    GoalDetailViewModel goalDetailViewModel;
    TextView textViewDetailDescription;
    TextView textViewDetailPriority;
    TextView textViewStartDate;
    TextView textViewEndDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewDetailDescription = findViewById(R.id.textview_detail_description);
        textViewDetailPriority = findViewById(R.id.textview_detail_priority);
        textViewStartDate = findViewById(R.id.textview_detail_startdate);
        textViewEndDate = findViewById(R.id.textview_detail_end_date);

        int id = getIntent().getExtras().getInt("Goal");

        goalDetailViewModel = ViewModelProviders.of(this).get(GoalDetailViewModel.class);
        goalDetailViewModel.getGoalById(id).observe(this, new Observer<Goal>() {
            @Override
            public void onChanged(@Nullable Goal goal) {
                textViewDetailDescription.setText(goal.getDescription());
                textViewDetailPriority.setText(goal.getPriority());
                textViewStartDate.setText(goal.getStartDate().toString());
                textViewEndDate.setText(goal.getEndDate().toString());

            }
        });
    }

}
