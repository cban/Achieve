package com.example.cbanda.achieve.models.repository;

import android.arch.lifecycle.LiveData;

import com.example.cbanda.achieve.models.db.Goal;

import java.util.List;

import io.reactivex.Completable;


public interface GoalRepository {

    LiveData<List<Goal>> getListGoals();

    LiveData<Goal> getGoalById(int id);

    Completable addGoal(Goal goal);

}
