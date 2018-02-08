package com.example.cbanda.achieve.Models.Repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.Models.db.GoalDao;
import com.example.cbanda.achieve.Models.db.Goal;

import java.util.List;

/**
 * Created by CBanda on 2018/02/07.
 */

public class GoalRepositoryImpl implements GoalRepository  {

private GoalDao goalDao;

public GoalRepositoryImpl(GoalDao goalDao)
{
    this.goalDao=goalDao;
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
