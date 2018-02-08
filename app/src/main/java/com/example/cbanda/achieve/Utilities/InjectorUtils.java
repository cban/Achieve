package com.example.cbanda.achieve.Utilities;

import android.content.Context;

import com.example.cbanda.achieve.Models.Repository.GoalRepository;
import com.example.cbanda.achieve.Models.Repository.GoalRepositoryImpl;
import com.example.cbanda.achieve.Models.db.GoalDatabase;

/**
 * Created by CBanda on 2018/02/08.
 */

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
