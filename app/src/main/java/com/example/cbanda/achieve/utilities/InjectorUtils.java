package com.example.cbanda.achieve.utilities;

import android.content.Context;

import com.example.cbanda.achieve.models.db.GoalDatabase;
import com.example.cbanda.achieve.models.repository.GoalRepository;
import com.example.cbanda.achieve.models.repository.GoalRepositoryImpl;
import com.example.cbanda.achieve.models.repository.QuoteRepository;
import com.example.cbanda.achieve.models.repository.QuoteRepositoryImpl;


public class InjectorUtils {

    private static GoalRepository goalRepository = null;
    private static QuoteRepository quoteRepository = null;

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

    public static QuoteRepository getInstance() {
        if (quoteRepository == null) {
            synchronized (GoalRepository.class) {
                if (quoteRepository == null) {
                    quoteRepository = new QuoteRepositoryImpl();
                }
            }
        }
        return quoteRepository;
    }


}
