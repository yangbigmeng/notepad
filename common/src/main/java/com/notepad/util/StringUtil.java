package com.notepad.util;

import java.lang.reflect.Field;

/**
 * Created by YM on 2017/6/11.
 */
public class StringUtil {

    /**
     * 判断字符串是否有效: 非空指针且非空
     *
     * @param string 待判断的字符串
     * @return true/false
     */
    public static boolean isValid(String string) {
        return (string != null) && (!string.equals(""));
    }

    /**
     * 将对象转化为字符串
     * @param object 待转化的对象
     * @return string
     */
    public static String convertToString(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getSimpleName());
        stringBuilder.append(" { ");
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                String fieldName = field.getName();
                boolean orgAccessTag = field.isAccessible();
                if (!orgAccessTag) {
                    field.setAccessible(true);
                }
                String value = field.get(object).toString();
                field.setAccessible(orgAccessTag);
                stringBuilder.append(fieldName).append(":= ").append(value).append(", ");
            } catch (IllegalAccessException ignored) {
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /**
     * 字符串的全角转半角
     *
     * @param content 字符串
     * @return 半角字符串
     */
    public static String stringQ2B(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            int asciiCode = (int) content.charAt(i);
            if (asciiCode >= Q_START && asciiCode <= Q_END) {
                asciiCode -= Q_B_INTERVAL;
            } else if (asciiCode == Q_BLANK) {
                asciiCode = B_BLANK;
            }
            stringBuilder.append((char) asciiCode);
        }
        return stringBuilder.toString();
    }

    /**
     * 字符串半角转全角
     *
     * @param content 字符串
     * @return 全角字符串
     */
    public static String stringB2Q(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            int asciiCode = (int) content.charAt(i);
            if (asciiCode >= B_START && asciiCode <= B_END) {
                asciiCode += Q_B_INTERVAL;
            } else if (asciiCode == B_BLANK) {
                asciiCode = Q_BLANK;
            }
            stringBuilder.append((char) asciiCode);
        }
        return stringBuilder.toString();
    }

    /** 全角字符起点和终点 */
    private static final int Q_START = 65281;
    private static final int Q_END = 65374;
    private static final int Q_BLANK = 12288;

    /** 半角字符起点和终点 */
    private static final int B_START = 33;
    private static final int B_END = 126;
    private static final int B_BLANK = 32;

    /** 全角和半角间隔 */
    private static final int Q_B_INTERVAL = 65248;
}
