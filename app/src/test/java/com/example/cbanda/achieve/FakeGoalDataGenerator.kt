package com.example.cbanda.achieve

import com.example.cbanda.achieve.models.db.Goal

import java.util.Date


object FakeGoalDataGenerator {

    val fakeGoal: Goal
        get() {
            val date = Date()
            val goal = Goal()
            goal.id = 1
            goal.priority = "high"
            goal.description = "Wake up"
            goal.endDate = date
            goal.startDate = date

            return goal
        }

}
