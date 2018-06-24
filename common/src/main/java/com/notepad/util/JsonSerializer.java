package com.notepad.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YM on 2017/6/11.
 */
public class JsonSerializer {

    public static String serialize(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map deserialize(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap();
        }
    }
}
