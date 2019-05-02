package com.notepad.thinkingnote.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: 实体定义
 * <p>
 * Create:      2018/9/6 22:37
 *
 * @author Marvin Yang
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    public Entity() {}

    public Entity(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    /** 实体标识符 */
    @JsonProperty("UID")
    private String uid;

    @JsonProperty("name")
    private String name;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
