package com.example.eadassignment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatetimeUtil {
    static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    public static String convertLongToString(long timeInMLS) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMLS);
        return formatDate.format(calendar.getTime());
    }
    public static long convertStringToLong(String timeString) {
        try {
            return formatDate.parse(timeString).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long getCurrentTimeInMLS() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static long getTimeAfterDay(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return calendar.getTimeInMillis();
    }
}
