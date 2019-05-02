package com.notepad.thinkingnote.reflect;

/**
 * Description: 四则运算实现
 * <p>
 * Create:      2018/8/12 20:39
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public class CalculateNode {

    public static int add(int v1, int v2) {
        return v1 + v2;
    }

    public static int minus(int v1, int v2) {
        return v1 - v2;
    }

    public static int multiply(int v1, int v2) {
        return v1 * v2;
    }

    public static double divide(int v1, int v2) {
        if (v2 == 0) {
            return 0;
        }
        return v1 / v2;
    }
}
