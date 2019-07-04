package com.example.cbanda.achieve.models.repository

import androidx.lifecycle.LiveData

import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.db.GoalDao

class GoalRepositoryImpl(private val goalDao: GoalDao) : GoalRepository {

    override val listGoals: LiveData<List<Goal>>
        get() = goalDao.listGoals

    override fun getGoalById(id: Int): LiveData<Goal> {
        return goalDao.getGoalById(id)
    }


    override fun addGoal(goal: Goal) {
        InsertAsyncTask(goalDao).execute(goal)
    }

}
