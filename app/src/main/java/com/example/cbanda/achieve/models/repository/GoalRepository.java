package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;


public interface GoalRepository {

    LiveData<List<Goal>> getListGoals();

    LiveData<Goal> getGoalById(int id);

    void addGoal(Goal goal);

}
