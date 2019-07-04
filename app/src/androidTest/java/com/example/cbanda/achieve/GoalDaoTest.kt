package com.example.cbanda.achieve


import androidx.room.Room
import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

import com.example.cbanda.achieve.models.db.Goal
import com.example.cbanda.achieve.models.db.GoalDao
import com.example.cbanda.achieve.models.db.GoalDatabase
import com.example.cbanda.achieve.utilities.LiveDataTestUtil

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import java.io.IOException
import java.util.Date

import junit.framework.Assert.assertTrue
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat

@RunWith(AndroidJUnit4::class)
class GoalDaoTest {

    private var goalDao: GoalDao? = null
    private var goalDatabase: GoalDatabase? = null


    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        goalDatabase = Room.inMemoryDatabaseBuilder(context, GoalDatabase::class.java).build()
        goalDao = goalDatabase!!.goalDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        goalDatabase!!.close()
    }


    @Test
    @Throws(InterruptedException::class)
    fun onFetchingFlights_shouldGetEmptyList_ifDatabase_isEmpty() {
        val goalList = LiveDataTestUtil.getValue(goalDao!!.listGoals)
        assertTrue(goalList.isEmpty())
    }

    @Test
    @Throws(Exception::class)
    fun addAGoal() {
        val date = Date()
        val goal = Goal()
        goal.id = 1
        goal.priority = "high"
        goal.description = "Wake up"
        goal.endDate = date
        goal.startDate = date
        goalDao!!.addGoal(goal)
        // assertEquals()
        assertThat("high", equalTo<String>(goal.priority))
    }
}
