package com.qiaqia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisLocalService {

    @Autowired
    @Qualifier("stringRedisTemplate")
    RedisTemplate template;

    public void setString(String key,String value){
        template.opsForValue().set(key,value);
    }

    public String getString(String key){
        return (String)template.opsForValue().get(key);
    }

    public void addListItem(String listKey,String itemVlaue){
        template.opsForList().rightPush(listKey,itemVlaue);
    }

    public List<Object> getList(String key){
        return template.opsForList().range(key,0,-1);
    }

    public Object getItemByIndex(String key,long i){
        return template.opsForList().index(key,i);
    }

    public Object removeItem(String key){
        return template.opsForList().leftPop(key);
    }

    public Long addSet(String key, String value){
        return template.opsForSet().add(key,value);
    }

    public Set<Object> getAll(String key){
        return template.opsForSet().members(key);
    }

    public boolean isMember(String key ,String value){
        return template.opsForSet().isMember(key,value);
    }

    public void addHash(String hashKey, String key, String value){
        template.opsForHash().put(hashKey,key,value);
    }

    public Map<Object,Object> getAllHash(String key){
        return template.opsForHash().entries(key);
    }

    public Object getSingleHash(String hashKey, String key){
        return template.opsForHash().get(hashKey,key);
    }

    public long deleteKey(String hashKey, String key){
        return template.opsForHash().delete(hashKey,key);
    }

    public boolean addZset(String key, String value, double score){
        return template.opsForZSet().add(key,value,score);
    }

    public Set getItem(String key){
        return template.opsForZSet().range(key,0,-1);
    }

    public Set getItemByScore(String key,double s1, double s2){
        return template.opsForZSet().rangeByScore(key,s1,s2);
    }

}
