package com.example.cbanda.achieve.models.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.cbanda.achieve.models.db.converters.DateConverter;

import java.util.Date;


@Entity(tableName = "goals")
public class Goal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private String priority;
    @TypeConverters(DateConverter.class)
    private Date startDate;
    @TypeConverters(DateConverter.class)
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
