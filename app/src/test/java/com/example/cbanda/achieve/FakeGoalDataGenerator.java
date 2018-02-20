package com.example.cbanda.achieve;

import com.example.cbanda.achieve.models.db.Goal;

import java.util.Date;


public class FakeGoalDataGenerator {

    public static Goal getFakeGoal() {
        Date date = new Date();
        Goal goal = new Goal();
        goal.setId(1);
        goal.setPriority("high");
        goal.setDescription("Wake up");
        goal.setEndDate(date);
        goal.setStartDate(date);

        return goal;
    }

}
