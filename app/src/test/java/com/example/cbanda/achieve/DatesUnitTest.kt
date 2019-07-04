package com.example.cbanda.achieve

import com.example.cbanda.achieve.presentation.add.AddGoalActivity
import com.example.cbanda.achieve.presentation.detail.GoalDetailActivity

import junit.framework.Assert

import org.joda.time.DateTime
import org.junit.Test

import java.text.SimpleDateFormat
import java.util.Calendar

import org.junit.Assert.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class DatesUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }


    @Test
    fun formatterShouldReturnDateInCorrectFormat() {
        val addGoalActivity = AddGoalActivity()
        val calendar = Calendar.getInstance()
        calendar.set(2018, 1, 14)
        val format = SimpleDateFormat("yyyy-MM-dd")
        val expected = "2018-02-14"
        val actual = addGoalActivity.simpleDateFormat.format(calendar.time)

        assertEquals(expected, actual)
    }

    @Test
    fun shouldConvertStartAndEndTImeToDurationInDays() {
        val startTime = DateTime(2018, 3, 25, 12, 0, 0, 0)
        val endTime = DateTime(2018, 3, 27, 12, 0, 0, 0)
        val goalDetailActivity = GoalDetailActivity()
        Assert.assertTrue(goalDetailActivity.getDays(startTime, endTime) == 2L)
    }
}