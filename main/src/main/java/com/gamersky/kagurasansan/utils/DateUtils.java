package com.gamersky.kagurasansan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther kagurasansan
 * @time 2019/3/29.5:27 PM
 * @des ${TODO}
 */
public class DateUtils {
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        return sd.format(date);
    }
}
