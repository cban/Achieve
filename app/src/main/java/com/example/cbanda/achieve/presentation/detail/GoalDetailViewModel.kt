package com.example.cbanda.achieve.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.repository.GoalRepository
import com.example.cbanda.achieve.utilities.InjectorUtils


class GoalDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val goalRepository: GoalRepository = InjectorUtils.getInstance(application)

    fun getGoalById(id: Int): LiveData<Goal> {
        return goalRepository.getGoalById(id)
    }
}
