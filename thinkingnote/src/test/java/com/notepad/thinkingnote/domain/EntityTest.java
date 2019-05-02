package com.notepad.thinkingnote.domain;

import com.notepad.util.JsonSerializer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description: 实体序列化和反序列化单测
 * <p>
 * Create:      2018/9/6 22:41
 *
 * @author Marvin Yang
 */
public class EntityTest {

    @Test
    public void testSerialize() throws Exception {
        Entity entity = new Entity("James", "James");
        System.out.println(JsonSerializer.serialize(entity));
    }


    @Test
    public void testDeserialize() throws Exception {
        String test = "{\"UID\":\"James\",\"name\":\"James\", \"type\":\"entity\"}";
        //String test = "{\"UID\":\"James\",\"name\":\"James\"}";
        Entity entity = JsonSerializer.deserialize(test, Entity.class);
        System.out.println(entity.getUid() + ":" + entity.getName());
    }
}