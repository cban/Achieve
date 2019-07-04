package com.example.cbanda.achieve.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.example.cbanda.achieve.models.db.converters.DateConverter

import java.util.Date


@Entity(tableName = "goals")
class Goal {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var description: String? = null
    var priority: String? = null
    @TypeConverters(DateConverter::class)
    var startDate: Date? = null
    @TypeConverters(DateConverter::class)
    var endDate: Date? = null
}
