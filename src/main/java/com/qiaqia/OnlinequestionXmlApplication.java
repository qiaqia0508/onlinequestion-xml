package com.qiaqia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

//exclude = RedisAutoConfiguration.class
@SpringBootApplication()
public class OnlinequestionXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinequestionXmlApplication.class, args);
    }

}
