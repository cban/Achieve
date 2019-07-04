package com.example.cbanda.achieve.presentation.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.repository.GoalRepository
import com.example.cbanda.achieve.utilities.InjectorUtils

class GoalListViewModel(application: Application) : AndroidViewModel(application) {



    private val goalRepository: GoalRepository = InjectorUtils.getInstance(application)

    private val goals: LiveData<List<Goal>> = goalRepository.listGoals

    fun getGoals(): LiveData<List<Goal>> {
        return goalRepository.listGoals
    }


}
