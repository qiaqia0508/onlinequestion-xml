package com.qiaqia;

import com.qiaqia.entity.Apple;
import org.junit.Test;

public class StaticTest {

    @Test
    public void test(){

        EntityStatic entityStatic = new EntityStatic();
        int x = entityStatic.nostaticid;

         entityStatic = new EntityStatic();
         x = entityStatic.nostaticid;

        System.out.println(EntityStatic.id);

        System.out.println(x);
    }

    @Test
    public void test3(){
        Apple apple = new Apple();
        System.out.println(apple.id());

        apple = new Apple();
        System.out.println(apple.id());

        apple = new Apple();
        System.out.println(apple.id());
    }
}
