package com.manveerbasra.ontime.db;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to handle conversions between String[] and String
 *
 * Used in Alarm.java as a @TypeConverter
 */
public class StringArrayConverter {
    @TypeConverter
    public String[] fromString(String value) {
        List<String> list = new ArrayList<>(Arrays.asList(value.split(",")));
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    @TypeConverter
    public String arrayToString(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (String item: arr) {
            builder.append(item + ",");
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }
}