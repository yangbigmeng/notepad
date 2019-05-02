package com.notepad.thinkingnote.regexes;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description: 正则表达式单测
 * <p>
 * Create:      2018/8/25 21:45
 *
 * @author Marvin Yang
 */
public class RegexUtilsTest {

    private RegexUtils regexUtils = new RegexUtils();

    @Test
    public void getPhoneNumber() {
        // test 1: 有电话号码
        String content = "紧急情况请拨打13845697569";
        List<String> phoneNumbers = regexUtils.getPhoneNumber(content);
        System.out.println(String.format("[%s] has phone number : [%s]", content, phoneNumbers));

        // test 2: 数字12位
        content = "紧急情况请拨打138456975690";
        phoneNumbers = regexUtils.getPhoneNumber(content);
        System.out.println(String.format("[%s] has phone number : [%s]", content, phoneNumbers));

        // test 3: 开头不是1
        content = "紧急情况请拨打23845697569";
        phoneNumbers = regexUtils.getPhoneNumber(content);
        System.out.println(String.format("[%s] has phone number : [%s]", content, phoneNumbers));

        // test 4: 数字在开头
        content = "13845697569紧急情况请拨打";
        phoneNumbers = regexUtils.getPhoneNumber(content);
        System.out.println(String.format("[%s] has phone number : [%s]", content, phoneNumbers));
    }

    @Test
    public void getHtmlTitle() throws Exception {
        // test 1: 正常情况
        String content = "<title>学而不厌 诲人不倦 - 第 1 页 - CSDN博客</title>";
        String title = regexUtils.getHtmlTitle(content);
        System.out.println(String.format("get title [%s] from content: [%s]", title, content));


        // test 1: 不区分大小写
        content = "<TITLE>学而不厌 诲人不倦 - 第 1 页 - CSDN博客</TITLE>";
        title = regexUtils.getHtmlTitle(content);
        System.out.println(String.format("get title [%s] from content: [%s]", title, content));
    }

    /**
     * String中正则表达式的测试
     *
     * @throws Exception 异常情况
     */
    @Test
    public void testStringRegex() throws Exception {

        // split
        String query = "some examples of regex test";
        String[] parts = query.split(" ");
        System.out.println(Arrays.toString(parts));

        // matches
        String regex = "regex";
        boolean isMatched = query.matches(regex);
        System.out.println(isMatched);

        // replaceAll
        String replaceQuery = " <REGEX> ";
        String newQuery = query.replaceAll(" ", replaceQuery);
        System.out.println(newQuery);
    }
}