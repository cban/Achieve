package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

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
    public LiveData<Goal> getGoalById(int id) {
        return goalDao.getGoalById(id);
    }


    @Override
    public Completable addGoal(final Goal goal) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                goalDao.addGoal(goal);
            }
        });
    }


}
