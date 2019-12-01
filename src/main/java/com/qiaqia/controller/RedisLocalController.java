package com.qiaqia.controller;

import com.qiaqia.service.RedisLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/redis")
public class RedisLocalController {

    @Autowired
    RedisLocalService redisLocalService;

    @ResponseBody
    @RequestMapping(value = "/string/set",method = RequestMethod.GET)
    public void setString(@RequestParam("key") String key,@RequestParam("value") String value){

         redisLocalService.setString(key,value);
    }

    @ResponseBody
    @RequestMapping(value = "/string/get",method = RequestMethod.GET)
    public String getString(String key){

       return redisLocalService.getString(key);
    }

    @ResponseBody
    @RequestMapping(value = "/list/add" ,method = RequestMethod.GET)
    public void addList(@RequestParam("key") String key ,@RequestParam("value") String value){
        redisLocalService.addListItem(key,value);
    }

    @ResponseBody
    @RequestMapping(value = "/list/get",method = RequestMethod.GET)
    public List<Object> getList(String key){
        return redisLocalService.getList(key);
    }

    @ResponseBody
    @RequestMapping(value = "/list/getByIndex",method = RequestMethod.GET)
    public Object getByIndex(String key,long i){
        return redisLocalService.getItemByIndex(key,i);
    }

    @ResponseBody
    @RequestMapping(value = "/list/remove",method = RequestMethod.GET)
    public Object removeItem(String key){
        return redisLocalService.removeItem(key);
    }

    //Set集合：添加元素
    @ResponseBody
    @RequestMapping(value = "/set/add",method = RequestMethod.GET)
    public Long addItem(@RequestParam("key") String key,@RequestParam("value") String value){
        return redisLocalService.addSet(key,value);
    }

    //Set集合：获取全部元素
    @ResponseBody
    @RequestMapping(value = "/set/getAll",method = RequestMethod.GET)
    public Set<Object> addItem(String key){
        return redisLocalService.getAll(key);
    }

    //Set集合：判断元素是否在集合中
    @ResponseBody
    @RequestMapping(value = "/set/ismember",method = RequestMethod.GET)
    public boolean isMember(String key, String value){
        return redisLocalService.isMember(key,value);
    }

    //hash：添加元素
    @ResponseBody
    @RequestMapping(value = "/hash/addHash",method = RequestMethod.GET)
    public void addHash(@RequestParam("hashKey") String hashKey,@RequestParam("key") String key,@RequestParam("value") String value){
        redisLocalService.addHash(hashKey,key,value);
    }

    //hash：获取元素，键值对
    @ResponseBody
    @RequestMapping(value = "/hash/getAll",method = RequestMethod.GET)
    public Map<Object, Object> addHash(String key){
        return redisLocalService.getAllHash(key);
    }

    //hash：获取单个元素，键值对
    @ResponseBody
    @RequestMapping(value = "/hash/getSingleHash",method = RequestMethod.GET)
    public Object getSingleHash(String hashKey, String key){
        return redisLocalService.getSingleHash(hashKey,key);
    }

    //hash：删除元素
    @ResponseBody
    @RequestMapping(value = "/hash/delete",method = RequestMethod.GET)
    public long deleteKey(String hashKey, String key){
        return redisLocalService.deleteKey(hashKey,key);
    }

    //zset：添加元素
    @ResponseBody
    @RequestMapping(value = "/zset/add",method = RequestMethod.GET)
    public boolean addZset(@RequestParam("key") String key,@RequestParam("value")  String value,@RequestParam("score") double score){
        return redisLocalService.addZset(key,value,score);
    }

    //zset：获取元素
    @ResponseBody
    @RequestMapping(value = "/zset/get",method = RequestMethod.GET)
    public Set getItem(String key){
        return redisLocalService.getItem(key);
    }

    //zset：根据分数区间获取元素
    @ResponseBody
    @RequestMapping(value = "/zset/getByScore",method = RequestMethod.GET)
    public Set getByScore(String key,double s1,double s2){
        return redisLocalService.getItemByScore(key,s1,s2);
    }


}
