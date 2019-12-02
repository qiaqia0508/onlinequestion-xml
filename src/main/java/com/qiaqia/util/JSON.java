package com.qiaqia.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSON {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static<T> T parse(String jsonStr,Class<T> tClass){

        try {
            return objectMapper.readValue(jsonStr,tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String serialize(Object obj){

        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
