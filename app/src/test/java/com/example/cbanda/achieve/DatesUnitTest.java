package com.example.cbanda.achieve;

import com.example.cbanda.achieve.presentation.add.AddGoalActivity;
import com.example.cbanda.achieve.presentation.detail.GoalDetailActivity;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatesUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void formatterShouldReturnDateInCorrectFormat() {
        AddGoalActivity addGoalActivity = new AddGoalActivity();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 01, 14);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String expected = "2018-02-14";
        String actual = addGoalActivity.getSimpleDateFormat().format(calendar.getTime());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertStartAndEndTImeToDurationInDays()

    {
        DateTime startTime = new DateTime(2018, 3, 25, 12, 0, 0, 0);
        DateTime endTime = new DateTime(2018, 3, 27, 12, 0, 0, 0);
        GoalDetailActivity goalDetailActivity = new GoalDetailActivity();
        Assert.assertTrue(goalDetailActivity.getDays(startTime, endTime) == 2);
    }
}