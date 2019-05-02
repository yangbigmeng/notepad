package com.notepad.springnote.integration;

import com.notepad.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: chunk常用工具
 * <p>
 * Create:      2018/8/25 0:38
 *
 * @author Marvin Yang
 */
@Component
public class ChunkUtils {

    /**
     * 计算chunk的长度
     *
     * @param chunk a chunk of query
     * @return the length of chunk
     */
    public String count(String chunk) {
        if (StringUtil.isValid(chunk)) {
            return String.valueOf(chunk.length());
        }
        return "0";
    }

    /**
     * chunk转换为大写
     *
     * @param chunk 待处理chunk
     * @return 大写chunk
     */
    public String upper(String chunk) {
        if (StringUtil.isValid(chunk)) {
            return chunk.toUpperCase();
        }
        return "";
    }

}
