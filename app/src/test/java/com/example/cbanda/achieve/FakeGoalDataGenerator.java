package com.example.cbanda.achieve;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Goal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FakeGoalDataGenerator {


    @NonNull
    private static Goal getFakeGoalInitialized() {
        Date date = new Date();
        Goal goal = new Goal();
        goal.setId(1);
        goal.setPriority("low");
        goal.setDescription("Sleep for 24 hours");
        goal.setEndDate(date);
        goal.setStartDate(date);
        return goal;
    }

    public static Goal getFakeGoal() {
        Goal goal = getFakeGoalInitialized();
        return goal;
    }

    @NonNull
    public static MutableLiveData<List<Goal>> getGoalListMutableData() {
        List<Goal> goals = new ArrayList<>();
        Goal goal = getFakeGoalInitialized();
        goals.add(goal);
        MutableLiveData<List<Goal>> fakeGoals = new MutableLiveData<>();
        fakeGoals.setValue(goals);
        return fakeGoals;
    }

}
