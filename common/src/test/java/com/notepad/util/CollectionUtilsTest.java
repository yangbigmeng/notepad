package com.notepad.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Description:  字符串转换测试
 * <p>
 * Create:       2018/6/17 17:07
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public class CollectionUtilsTest {

    @Test
    public void string2array() {
        String content = "2018 端午节 快乐";
        String[] stringArray = CollectionUtils.string2Array(content);
        Assert.assertEquals(3, stringArray.length);
        System.out.println(stringArray.length);
        System.out.println(Arrays.toString(stringArray));
    }

    @Test
    public void array2string() {
        String [] con = {"2018", "俄罗斯", "世界杯"};
        System.out.println(CollectionUtils.array2String(con));
        Assert.assertEquals("2018 俄罗斯 世界杯", CollectionUtils.array2String(con));
    }

    @Test
    public void array2List() {
        String [] con = {"2018", "俄罗斯", "世界杯"};
        List<String> stringList = CollectionUtils.array2List(con);
        Assert.assertEquals(3, stringList.size());
        System.out.println(stringList);
    }

    @Test
    public void list2Array() {
        List<String> stringList = new ArrayList<>();
        stringList.add("2018");
        stringList.add("葡萄牙");
        stringList.add("3:0");
        stringList.add("西班牙");
        String [] strings = CollectionUtils.list2Array(stringList);
        Assert.assertEquals(4, strings.length);
        Assert.assertEquals("西班牙", strings[3]);
    }

    @Test
    public void list2Set() {
        List<String> stringList = new ArrayList<>();
        stringList.add("吃");
        stringList.add("葡萄");
        stringList.add("不吐");
        stringList.add("葡萄");
        Set<String> stringSet = CollectionUtils.list2Set(stringList);
        Assert.assertNotEquals(4, stringSet.size());
    }

    @Test
    public void set2List() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("吃");
        stringSet.add("葡萄");
        stringSet.add("不吐");
        stringSet.add("葡萄");
        List<String> stringList = CollectionUtils.set2List(stringSet);
        Assert.assertEquals(3, stringList.size());
    }
}