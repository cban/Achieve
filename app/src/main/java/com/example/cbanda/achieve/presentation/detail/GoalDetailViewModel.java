package com.example.cbanda.achieve.presentation.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.utilities.InjectorUtils;


public class GoalDetailViewModel extends AndroidViewModel {
    GoalRepository goalRepository;

    public GoalDetailViewModel(@NonNull Application application) {
        super(application);
        goalRepository = InjectorUtils.getInstance(application);
    }

    LiveData<Goal> getGoalById(int id) {
        return goalRepository.getGoalById(id);
    }
}
