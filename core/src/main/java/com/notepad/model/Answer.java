package com.notepad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notepad.util.StringUtil;

/**
 * Created by YM on 2017/6/11.
 */
public class Answer {

    @Override
    public String toString() {
        return StringUtil.convertToString(this);
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private String age;


    @JsonProperty("address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
