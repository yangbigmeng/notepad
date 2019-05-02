package com.notepad.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:  时间测试
 * <p>
 * Create:       2018/6/17 15:32
 *
 * @author Marvin Yang
 */
public class TimeUtilsTest {

    @Test
    public void time2timestamp() throws Exception {
        String timeStr = "20180617 00:00:00";
        System.out.println(TimeUtils.time2timestamp(timeStr, "yyyyMMdd HH:mm:ss"));

        timeStr = "2018-06-17 00:00:00";
        System.out.println(TimeUtils.time2timestamp(timeStr));
        Assert.assertEquals(1529164800000L, TimeUtils.time2timestamp(timeStr));
    }

    @Test
    public void timestamp2time() throws Exception {
        long timestamp = 1529164800000L;
        System.out.println(TimeUtils.timestamp2time(timestamp));
        Assert.assertEquals("2018-06-17 00:00:00", TimeUtils.timestamp2time(timestamp));

        System.out.println(TimeUtils.timestamp2time(timestamp, "yyyyMMdd HH:mm:ss"));
        System.out.println(TimeUtils.timestamp2time(System.currentTimeMillis(), "yyyyMMDD HH:mm:ss"));
    }
}