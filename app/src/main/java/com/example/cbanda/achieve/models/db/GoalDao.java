package com.example.cbanda.achieve.models.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface GoalDao {

    @Query("SELECT * from goals")
    LiveData<List<Goal>> getListGoals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addGoal(Goal goal);

    @Query("SELECT * FROM goals WHERE id =:id")
    LiveData<Goal> getGoalById(int id);
}
