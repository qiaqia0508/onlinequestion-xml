package com.qiaqia;

import com.qiaqia.entity.Cat;
import com.qiaqia.entity.Dog;
import com.qiaqia.entity.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetMap {
    public static void main(String[] args){
        Map<String,Pet> map = new HashMap<String,Pet>();
        map.put("My cat",new Cat("niky"));
        map.put("My dog",new Dog("tady"));
        System.out.println(map);
        Pet dog = map.get("My dog");
        System.out.println(dog);
        System.out.println(map.containsKey("My dog"));
        System.out.println(map.containsValue(dog));


    }
}
