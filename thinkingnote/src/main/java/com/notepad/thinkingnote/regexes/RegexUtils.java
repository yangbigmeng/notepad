package com.notepad.thinkingnote.regexes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 正则表达式
 * <p>
 * Create:      2018/8/25 21:37
 *
 * @author Marvin Yang
 */
public class RegexUtils {



    /**
     *  获取content中全部的手机号码
     *
     * @param content 待匹配内容
     * @return 电话号码集合
     */
    public List<String> getPhoneNumber(String content) {
        List<String> phoneNumbers = new ArrayList<>();
        Matcher matcher = PHONE_PATTERN.matcher(content);
        while (matcher.find()) {
            phoneNumbers.add(matcher.group(2));
        }
        return phoneNumbers;
    }

    /**
     * 从Html中获取title
     *
     * @param content a html
     * @return the title of a html
     */
    public String getHtmlTitle(String content) {
        Matcher matcher = TITLE_PATTERN.matcher(content);
        return matcher.find()? matcher.group(1):null;
    }

    /** 手机号码 */
    private static final String PHONE_REGEX = "(^|\\D)(1\\d{10})($|\\D)";
    private static final Pattern PHONE_PATTERN;

    /** html 标题 */
    private static final String HTML_TITLE_REGEX = "<title>(.*?)</title>";
    private static final Pattern TITLE_PATTERN;

    static {
        PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
        TITLE_PATTERN = Pattern.compile(HTML_TITLE_REGEX, Pattern.CASE_INSENSITIVE);
    }
}
