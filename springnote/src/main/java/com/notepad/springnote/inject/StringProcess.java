package com.notepad.springnote.inject;

import org.springframework.stereotype.Component;

/**
 * Description:  字符串处理函数
 * <p>
 * Create:       2018/6/17 18:55
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@Component
public class StringProcess {

    /**
     * 字符串的全角转半角
     *
     * @param content 字符串
     * @return 半角字符串
     */
    public String stringQ2B(String content) {
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
    public String stringB2Q(String content) {
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
