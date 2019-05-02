package com.notepad.thinkingnote.exception;

/**
 * Description: 错误信息
 * <p>
 * Create:      2018/6/30 23:04
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public enum ErrorMsgEnum {

    TEST("test error message enum");

    private ErrorMsgEnum(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
