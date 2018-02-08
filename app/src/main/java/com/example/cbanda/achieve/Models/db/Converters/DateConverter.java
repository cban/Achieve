package com.example.cbanda.achieve.Models.db.Converters;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by CBanda on 2018/02/08.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
