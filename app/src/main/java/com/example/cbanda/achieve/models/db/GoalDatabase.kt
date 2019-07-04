package com.example.cbanda.achieve.models.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.TypeConverters
import com.example.cbanda.achieve.models.db.converters.DateConverter


@Database(entities = [Goal::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class GoalDatabase : RoomDatabase() {
    abstract val goalDao: GoalDao

    companion object {

        private var sInstance: GoalDatabase? = null

        fun getInstance(context: Context): GoalDatabase {
            if (sInstance == null) {
                synchronized(GoalDatabase::class.java) {
                    if (sInstance == null) {
                        sInstance = buildDatabase(context.applicationContext)
                    }
                }
            }
            return sInstance!!
        }

        private fun buildDatabase(appContext: Context): GoalDatabase {
            return Room.databaseBuilder(appContext, GoalDatabase::class.java, "goals_db").build()
        }
//        fun getDao():GoalDao{
//            return goalDao
//        }
//
    }
}


