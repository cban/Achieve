package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;

import java.util.List;

public class GoalRepositoryImpl implements GoalRepository {

    private GoalDao goalDao;

    public GoalRepositoryImpl(GoalDao goalDao) {
        this.goalDao = goalDao;
    }

    @Override
    public LiveData<List<Goal>> getListGoals() {
        return goalDao.getListGoals();
    }

    @Override
    public void addGoal(Goal goal) {
        goalDao.addGoal(goal);
    }
}
