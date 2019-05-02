package com.notepad.thinkingnote.exception;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * <p>
 * Create:      2018/6/30 23:58
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public class ErrorMsgEnumTest {

    @Test
    public void testEnum() throws Exception {
        System.out.println(ErrorMsgEnum.TEST.getMessage());
    }
}