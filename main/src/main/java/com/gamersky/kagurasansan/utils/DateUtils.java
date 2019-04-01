package com.gamersky.kagurasansan.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @auther kagurasansan
 * @time 2019/3/29.5:27 PM
 * @des ${TODO}
 */
public class DateUtils {
    public static String longToDate(long lo){
        SimpleDateFormat restlt = new SimpleDateFormat("HH:mm");
        restlt.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return restlt.format(lo);
    }
}
