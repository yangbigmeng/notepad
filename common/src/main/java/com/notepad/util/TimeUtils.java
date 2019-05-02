package com.notepad.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:  时间处理函数
 * <p>
 * <p>
 *     y:  year
 *     M:  month in year
 *     w:  week in year
 *     W:  week in month
 *     D:  day in year
 *     d:  day in month
 *     F:  Day of week in month
 *     E:  Day name in week
 *     H:  Hour in day (0-23)
 *     k:  Hour in day (1-24)
 *     K:  Hour in am/pm (0-11)
 *     h:  Hour in am/pm (1-12)
 *     m:  Minute in hour
 *     s:  Second in minute
 * </p>
 * Create:       2018/6/16 15:29
 *
 * @author Marvin Yang
 */
public class TimeUtils {

    /**
     * 时间字符串格式转换为时间戳
     *
     * @param timeStr 时间字符串格式, eg. 2018-06-17 00:00:00
     * @return 时间戳
     * @throws Exception 时间格式解析错误
     */
    public static long time2timestamp(String timeStr) throws Exception {
        return time2timestamp(timeStr, DEFAULT_FORMAT);
    }

    /**
     * 时间字符串格式转换为时间戳
     *
     * @param timeStr 时间字符串格式, eg. 2018-06-17 00:00:00
     * @param timeFormat  时间格式
     * @return 时间戳
     * @throws Exception 时间格式解析错误
     */
    public static long time2timestamp(String timeStr, String timeFormat) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.parse(timeStr).getTime();
    }

    /**
     * 时间戳转换为时间字符串
     *
     * @param timestamp 时间戳, eg. 1513440360000L
     * @return 时间字符串格式
     */
    public static String timestamp2time(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        return format.format(new Date(timestamp));
    }

    /**
     * 时间戳转换为时间字符串
     *
     * @param timestamp 时间戳, eg. 1513440360000L
     * @param timeFormat 时间格式
     * @return 时间字符串格式
     */
    public static String timestamp2time(long timestamp, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(new Date(timestamp));
    }

    /** 默认时间格式: 2018-06-17 16:28:00 */
    private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
