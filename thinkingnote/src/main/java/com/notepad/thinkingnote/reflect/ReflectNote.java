package com.notepad.thinkingnote.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Java反射笔记
 * <p>
 * Create:      2018/8/12 20:25
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public class ReflectNote {

    public static List getMethods(String className) {
        try {
            Class<?> c = Class.forName(className);
            Method [] methods = c.getMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }
            return Arrays.asList(methods);
        } catch (ClassNotFoundException e) {
            LOG.warn("can not find class: {}", className);
            return null;
        }
    }

    public static List<String> getDeclaredMethodsName(String className) {
        try {
            List<String> methodNames = new ArrayList<>();
            Class<?> c = Class.forName(className);
            Method [] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                methodNames.add(m.getName());
            }
            return methodNames;
        } catch (ClassNotFoundException e) {
            LOG.warn("can not find class: {}", className);
            return null;
        }
    }

    /**
     * 根据类名和方法名获取对应的方法
     *
     * @param name 类名
     * @param method 方法名
     * @return a Method, null 找不到
     */
    public static Method getMethod(String name, String method) {
        try {
            Class<?> c = Class.forName(name);
            for (Method m : c.getDeclaredMethods()) {
                if (m.getName().equals(method)) {
                    return m;
                }
            }
            return null;
        } catch (ClassNotFoundException e) {
            LOG.warn("can not find class: {}", name);
            return null;
        }
    }

    /**
     * 根据类名和方法名获取对应的方法
     *
     * @param cls 类
     * @param method 方法名
     * @return a Method, null 找不到
     */
    public static Method getMethod(Class<?> cls, String method) {
        for (Method m : cls.getDeclaredMethods()) {
            if (m.getName().equals(method)) {
                return m;
            }
        }
        return null;
    }

    private static final Logger LOG = LoggerFactory.getLogger(ReflectNote.class);
}
