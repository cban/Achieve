package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;

/**
 * Created by CBanda on 2018/02/07.
 */

public interface GoalRepository {

    LiveData<List<Goal>> getListGoals();

    void addGoal(Goal goal);
}
