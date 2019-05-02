package com.notepad.springnote.inject;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * Description: 字符串转拼音
 * <p>
 * Create:      2018/6/24 11:44
 *
 * @author Marvin Yang
 */
public class EncodeUtils {

    /**
     * 字符串汉字转拼音
     *
     * @param content 字符串
     * @return 拼音
     * @throws Exception 转换异常
     */
    public String string2Pinyin(String content) throws Exception {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        return PinyinHelper.toHanYuPinyinString(content, format, separate, retain);
    }

    /** 拼音分隔符 */
    private String separate;

    /** 是否保留未能转换为拼音的字符 */
    private boolean retain;

    public String getSeparate() {
        return separate;
    }

    public void setSeparate(String separate) {
        this.separate = separate;
    }

    public void setRetain(boolean retain) {
        this.retain = retain;
    }
}
