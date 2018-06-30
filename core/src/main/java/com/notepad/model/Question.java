package com.notepad.model;

import com.notepad.util.StringUtil;

/**
 * Created by YM on 2017/6/11.
 */
public class Question {

    @Override
    public String toString() {
        return StringUtil.convertToString(this);
    }

    /** 名字 */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
