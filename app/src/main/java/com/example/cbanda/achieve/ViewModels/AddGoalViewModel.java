package com.example.cbanda.achieve.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.Models.Repository.GoalRepository;
import com.example.cbanda.achieve.Models.db.Goal;
import com.example.cbanda.achieve.Utilities.InjectorUtils;

import java.util.Date;

/**
 * Created by CBanda on 2018/02/08.
 */

public class AddGoalViewModel extends AndroidViewModel {

    private GoalRepository goalRepository;

    public AddGoalViewModel(@NonNull Application application) {
        super(application);
        goalRepository = InjectorUtils.getInstance(application);
    }

    public void addGoal( String description,String priority,Date startDate,Date endDate) {
        Goal goal = new Goal();
        goal.setDescription(description);
        goal.setPriority(priority);
        goal.setStartDate(startDate);
        goal.setEndDate(endDate);

        goalRepository.addGoal(goal);
    }

}
