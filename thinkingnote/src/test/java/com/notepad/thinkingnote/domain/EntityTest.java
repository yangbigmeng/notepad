package com.notepad.thinkingnote.domain;

import com.notepad.util.JsonUtils;
import org.junit.Test;

/**
 * Description: 实体序列化和反序列化单测
 * <p>
 * Create:      2018/9/6 22:41
 *
 * @author Marvin Yang
 */
public class EntityTest {

    @Test
    public void testSerialize() {
        Entity entity = new Entity("James", "James");
        System.out.println(JsonUtils.serialize(entity));
    }


    @Test
    public void testDeserialize() {
        String test = "{\"UID\":\"James\",\"name\":\"James\", \"type\":\"entity\"}";
        //String test = "{\"UID\":\"James\",\"name\":\"James\"}";
        Entity entity = JsonUtils.deserialize(test, Entity.class);
        System.out.println(entity.getUid() + ":" + entity.getName());
    }
}