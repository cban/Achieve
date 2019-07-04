package com.example.cbanda.achieve.presentation.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.repository.GoalRepository
import com.example.cbanda.achieve.utilities.InjectorUtils

import java.util.Date


class AddGoalViewModel(application: Application) : AndroidViewModel(application) {

    private val goalRepository: GoalRepository = InjectorUtils.getInstance(application)
    var selectedStartDate: Date? = null
    var selectedEndDate: Date? = null
    var prioritySelected: String? = null
    var goalDescription: String? = null

    fun addGoal() {
        val goal = Goal()
        goal.priority = prioritySelected
        goal.description = goalDescription
        goal.startDate = selectedStartDate
        goal.endDate = selectedEndDate

        goalRepository.addGoal(goal)
    }
}