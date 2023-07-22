package com.notepad.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notepad.model.Question;
import com.notepad.util.StringUtil;
/**
 * Created by YM on 2017/6/11.
 */
public class Query {

    /**
     * 转化为内部数据结构Question
     * @return @see Question
     */
    public Question convertToQuery() {
        Question question = new Question();
        question.setName(name);
        return question;
    }

    @Override
    public String toString() {
        return StringUtil.convertToString(this);
    }

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
