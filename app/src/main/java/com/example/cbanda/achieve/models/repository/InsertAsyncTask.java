package com.example.cbanda.achieve.models.repository;

import android.os.AsyncTask;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;


public class InsertAsyncTask extends AsyncTask<Goal, Void, Void> {
    private GoalDao mAsyncTaskDao;

    InsertAsyncTask(GoalDao dao) {

        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Goal... params) {
        mAsyncTaskDao.addGoal(params[0]);
        return null;

    }
}