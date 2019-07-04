package com.example.cbanda.achieve.models.repository

import androidx.lifecycle.LiveData

import com.example.cbanda.achieve.models.db.Goal


interface GoalRepository {

    val listGoals: LiveData<List<Goal>>

    fun getGoalById(id: Int): LiveData<Goal>

    fun addGoal(goal: Goal)

}
