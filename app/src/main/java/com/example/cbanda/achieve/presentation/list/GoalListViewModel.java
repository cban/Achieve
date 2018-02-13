package com.example.cbanda.achieve.presentation.list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.utilities.InjectorUtils;

import java.util.List;

public class GoalListViewModel extends AndroidViewModel {

    private GoalRepository goalRepository;

    public GoalListViewModel(@NonNull Application application) {
        super(application);
        goalRepository = InjectorUtils.getInstance(application);
    }

    LiveData<List<Goal>> getGoals() {
        return goalRepository.getListGoals();
    }

}
