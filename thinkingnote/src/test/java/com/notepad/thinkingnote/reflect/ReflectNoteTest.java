package com.notepad.thinkingnote.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Create:      2018/8/12 20:33
 *
 * @author Marvin Yang
 */
public class ReflectNoteTest {

    @Test
    public void testGetMethods() throws Exception {
        String name = "com.notepad.thinkingnote.reflect.CalculateNode";
        System.out.println(ReflectNote.getMethods(name));
    }

    @Test
    public void testGetDeclaredMethod() throws Exception {
        String name = "com.notepad.thinkingnote.reflect.CalculateNode";
        System.out.println(ReflectNote.getDeclaredMethodsName(name));
    }

    /**
     * 字符串转换为函数并执行
     *
     * @throws Exception 处理异常
     */
    @Test
    public void testReflect() throws Exception {
        String name = "com.notepad.thinkingnote.reflect.CalculateNode";
        String v1 = "20";
        String v2 = "10";

        // add
        String methodName = "add";
        Method m = ReflectNote.getMethod(name, methodName);
        assert m != null;
        Assert.assertEquals(m.getName(), methodName);
        System.out.println(m);
        int v = (int)m.invoke(CalculateNode.class, Integer.valueOf(v1), Integer.valueOf(v2));
        System.out.println(String.format("%s %s %s = %s", v1, methodName, v2, v));

        // 直接获取方法
        Method method = CalculateNode.class.getDeclaredMethod(methodName, int.class, int.class);
        assert method != null;
        int value = (int)method.invoke(CalculateNode.class, Integer.valueOf(v1), Integer.valueOf(v2));
        System.out.println(String.format("direct %s %s %s = %s", v1, methodName, v2, value));

        // minus
        methodName = "minus";
        Method m2 = ReflectNote.getMethod(CalculateNode.class, methodName);
        int minusValue = (int) m2.invoke(CalculateNode.class, Integer.valueOf(v1), Integer.valueOf(v2));
        System.out.println(String.format("%s %s %s = %s", v1, methodName, v2, minusValue));
    }

}