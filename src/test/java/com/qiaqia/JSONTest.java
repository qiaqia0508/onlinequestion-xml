package com.qiaqia;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JSONTest {

    @Test
    public void testWrite() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Entity enity = new Entity(1, "renault");
        String jsonStr = objectMapper.writeValueAsString(enity);
        System.out.println(jsonStr);
    }

    @Test
    public void testRead() throws IOException {

        String jsonStr = "{\"id\":1,\"name\":\"myname\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        Entity entity = objectMapper.readValue(jsonStr,Entity.class);

        System.out.println(entity.id+"\t"+entity.name);

        Assert.assertEquals(1,entity.id);
    }
}
