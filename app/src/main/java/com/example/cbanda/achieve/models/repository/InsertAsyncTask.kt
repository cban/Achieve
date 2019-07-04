package com.example.cbanda.achieve.models.repository

import android.os.AsyncTask

import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.db.GoalDao


class InsertAsyncTask internal constructor(private val mAsyncTaskDao: GoalDao) : AsyncTask<Goal, Void, Void>() {

    override fun doInBackground(vararg params: Goal): Void? {
        mAsyncTaskDao.addGoal(params[0])
        return null

    }
}