package com.example.cbanda.achieve;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.cbanda.achieve.models.db.Goal;
import com.example.cbanda.achieve.models.db.GoalDao;
import com.example.cbanda.achieve.models.db.GoalDatabase;
import com.example.cbanda.achieve.utilities.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class GoalDaoTest {

    private GoalDao goalDao;
    private GoalDatabase goalDatabase;


    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        goalDatabase = Room.inMemoryDatabaseBuilder(context, GoalDatabase.class).build();
        goalDao = goalDatabase.getGoalDao();
    }

    @After
    public void closeDb() throws IOException {
        goalDatabase.close();
    }


    @Test
    public void onFetchingFlights_shouldGetEmptyList_ifDatabase_isEmpty() throws InterruptedException {
        List<Goal> goalList = LiveDataTestUtil.getValue(goalDao.getListGoals());
        assertTrue(goalList.isEmpty());
    }

    @Test
    public void addAGoal() throws Exception {
        Date date = new Date();
        Goal goal = new Goal();
        goal.setId(1);
        goal.setPriority("high");
        goal.setDescription("Wake up");
        goal.setEndDate(date);
        goal.setStartDate(date);
        goalDao.addGoal(goal);
        // assertEquals()
        assertThat("high", equalTo(goal.getPriority()));
    }
}
