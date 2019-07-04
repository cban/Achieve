package com.example.cbanda.achieve.models.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface GoalDao {

    @get:Query("SELECT * from goals")
    val listGoals: LiveData<List<Goal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGoal(goal: Goal)

    @Query("SELECT * FROM goals WHERE id =:id")
    fun getGoalById(id: Int): LiveData<Goal>
}
