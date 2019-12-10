package com.qiaqia;

import com.qiaqia.entity.Cat;
import com.qiaqia.entity.Dog;
import com.qiaqia.entity.Person;
import com.qiaqia.entity.Pet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {
    public static Map<Person,List<? extends Pet>> person = new HashMap<Person,List<? extends Pet>>();
    static{
        person.put(new Person("qiaqia"), Arrays.asList(new Dog("tady"),new Dog("niki")));
        person.put(new Person("ping"), Arrays.asList(new Cat("miao"),new Dog("coco")));
    }

    public static void main(String[] args){
        System.out.println("person:"+person.keySet());
        System.out.println("Pet:"+person.values());
        for(Person p : person.keySet()){
            System.out.println("Person "+ p.getName() + " has :");
            for(Pet pet : person.get(p)){
                System.out.println(pet.getName());
            }
        }

    }
}
