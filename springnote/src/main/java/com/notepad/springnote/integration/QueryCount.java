package com.notepad.springnote.integration;

import java.util.List;

/**
 * Description: query chunk个数
 * <p>
 * Create:      2018/8/25 0:20
 *
 * @author Marvin Yang
 */
public interface QueryCount {

    /**
     * query切chunk
     *
     * @param query a string query
     * @return chunks
     */
    List<String> count(String query);
}
