package org.ababup1192.util;

import java.time.*;
import java.util.Date;

public class DateUtil {
    public static Date toDate(long milliSeconds){
        return Date.from(Instant.ofEpochMilli(milliSeconds).atZone(ZoneId.of("Asia/Tokyo")).toInstant());
    }

    public static boolean isEqual(Date date1, Date date2){
        return Math.abs(date1.getTime() - date2.getTime()) <= 1000;
    }
}
