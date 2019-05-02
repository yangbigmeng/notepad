package com.notepad.thinkingnote.pack;

/**
 * Description: 自动拆箱和装箱
 * <p>
 * Create:      2018/9/16 17:29
 *
 * @author Marvin Yang
 */
public class PackDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }
}
