package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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
    public LiveData<Goal> getGoalById(int id) {
        return goalDao.getGoalById(id);
    }


    @Override
    public void addGoal(Goal goal) {
        new insertAsyncTask(goalDao).execute(goal);
        // goalDao.addGoal(goal);
    }


    private static class insertAsyncTask extends AsyncTask<Goal, Void, Void> {
        private GoalDao mAsyncTaskDao;

        insertAsyncTask(GoalDao dao) {

            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Goal... params) {
            mAsyncTaskDao.addGoal(params[0]);
            return null;

        }
    }

}
