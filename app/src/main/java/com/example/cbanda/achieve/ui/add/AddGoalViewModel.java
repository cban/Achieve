package com.example.cbanda.achieve.ui.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.utilities.InjectorUtils;

import java.util.Date;


public class AddGoalViewModel extends AndroidViewModel {

    private GoalRepository goalRepository;

    private Date selectedDate;//look into joda time

    public AddGoalViewModel(@NonNull Application application) {
        super(application);
        goalRepository = InjectorUtils.getInstance(application);
    }

    public void addGoal(String priority, String description, Date startDate, Date endDate) {
        Goal goal = new Goal();
        goal.setPriority(priority);
        goal.setDescription(description);
        goal.setStartDate(startDate);
        goal.setEndDate(endDate);

        goalRepository.addGoal(goal);
    }

}
