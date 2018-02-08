package com.example.cbanda.achieve.Models.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by CBanda on 2018/02/07.
 */
@Dao
public interface GoalDao {

    @Query("SELECT * from goals")
    LiveData<List<Goal>> getListGoals();

    @Insert(onConflict = REPLACE)
    void addGoal(Goal goal);

}
