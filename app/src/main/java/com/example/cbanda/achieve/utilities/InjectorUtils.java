package com.example.cbanda.achieve.utilities;

import android.content.Context;

import com.example.cbanda.achieve.models.db.GoalDatabase;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.models.repository.GoalRepositoryImpl;


public class InjectorUtils {

    private static GoalRepository goalRepository = null;

    public static GoalRepository getInstance(final Context context) {
        if (goalRepository == null) {
            synchronized (GoalRepository.class) {
                if (goalRepository == null) {
                    goalRepository = new GoalRepositoryImpl(GoalDatabase.getInstance(context).getGoalDao());
                }
            }
        }
        return goalRepository;
    }
}
