package com.notepad.springnote.nosql.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Description: 实体定义
 * <p>
 * Create:      2018/12/2 14:45
 *
 * @author Marvin Yang
 */
@Document(collection = "entity")
public class Entity {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
