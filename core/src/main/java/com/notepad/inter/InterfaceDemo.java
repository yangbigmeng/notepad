package com.notepad.inter;

/**
 * Description: Interface也可以定义static
 *
 *      (1) static方法需要实现
 *
 * <p>
 * Create:      2018/8/19 17:44
 *
 * @author Marvin Yang
 */
public interface InterfaceDemo {

    /**
     * 方法也可以是static, 但是要有方法体
     *
     */
    static void process() {
        System.out.println("hello interface.");
    }

    /**
     * 泛型方法定义
     *
     * @param t  参数
     */
    static <T> void process(T t) {
        System.out.println("get class: " + t.getClass());
    }
}
