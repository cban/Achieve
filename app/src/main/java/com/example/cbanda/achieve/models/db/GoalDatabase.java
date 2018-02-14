package com.example.cbanda.achieve.models.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Goal.class}, version = 1)
public abstract class GoalDatabase extends RoomDatabase {
    public abstract GoalDao getGoalDao();

    private static GoalDatabase sInstance;

    public static GoalDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (GoalDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static GoalDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, GoalDatabase.class, "goals_db").build();
    }
}


