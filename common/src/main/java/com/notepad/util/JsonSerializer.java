package com.notepad.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YM on 2017/6/11.
 */
public class JsonSerializer {

    /**
     * JSON序列化
     *
     * @param object 对象
     * @return JSON字符串
     */
    public static String serialize(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * JSON字符串反序列化
     *
     * @param jsonStr JSON字符串
     * @return a Map
     */
    public static Map deserialize(String jsonStr) {
        try {
            return deserialize(jsonStr, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    public static <T> T deserialize(String jsonStr, Class<T> classType) throws Exception {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonStr, classType);
    }
}
