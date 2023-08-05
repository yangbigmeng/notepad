package com.notepad.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类，基于Jackson实现
 *
 * @author yangmeng
 * Created by YM on 2017/6/11.
 */
public class JsonUtils {
    private static final String SERIALIZE_ERROR = "序列化失败";

    private static final String DESERIALIZE_ERROR = "反序列化失败";

    /**
     * can use static singleton, inject: just make sure to reuse!
     */
    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * JSON序列化
     *
     * @param object 对象
     * @return JSON字符串
     */
    public static String serialize(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(SERIALIZE_ERROR, e);
        }
    }

    /**
     * JSON字符串反序列化
     *
     * @param jsonStr   待反序列化的字符串
     * @param classType 期望类型
     * @param <T>       类型
     * @return obj
     */
    public static <T> T deserialize(String jsonStr, Class<T> classType) {
        try {
            return MAPPER.readValue(jsonStr, classType);
        } catch (Exception e) {
            throw new RuntimeException(DESERIALIZE_ERROR, e);
        }
    }
}
