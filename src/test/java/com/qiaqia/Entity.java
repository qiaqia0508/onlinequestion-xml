package com.qiaqia;

import lombok.Data;

@Data
public class Entity {

    int id;

    String name;

    public Entity(){}
    public Entity(int id,String name){
        this.id = id;
        this.name = name;
    }
}
