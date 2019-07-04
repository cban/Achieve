package com.example.cbanda.achieve.utilities

import android.content.Context

import com.example.cbanda.achieve.models.db.GoalDatabase
import com.example.cbanda.achieve.models.repository.GoalRepository
import com.example.cbanda.achieve.models.repository.GoalRepositoryImpl
import com.example.cbanda.achieve.models.repository.QuoteRepository
import com.example.cbanda.achieve.models.repository.QuoteRepositoryImpl


object InjectorUtils {

    private var goalRepository: GoalRepository? = null
    private var quoteRepository: QuoteRepository? = null

    val instance: QuoteRepository
        get() {
            if (quoteRepository == null) {
                synchronized(GoalRepository::class.java) {
                    if (quoteRepository == null) {
                        quoteRepository = QuoteRepositoryImpl()
                    }
                }
            }
            return quoteRepository!!
        }

    fun getInstance(context: Context): GoalRepository {
        if (goalRepository == null) {
            synchronized(GoalRepository::class.java) {
                if (goalRepository == null) {
                    goalRepository = GoalRepositoryImpl(GoalDatabase.getInstance(context).goalDao)
                }
            }
        }
        return goalRepository!!
    }


}
