package com.qiaqia;

import com.qiaqia.entity.Apple;
import org.junit.Test;

import java.util.ArrayList;

public class ShuzhuTest {

    @Test
    public void test(){

        int[] intarray = new int[10];
        intarray[0]=1;
        System.out.println(intarray[0]);
        int[] intempty = {};
        //intempty[0] = 2;
        int[] intnum = {1,2};
        System.out.println(intnum[0]);
    }



    @Test
    public void test01(){
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int j = 0;j < 3;j++)
            apples.add(new Apple());

        for(int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }

        apples.add(3,new Apple());
        System.out.println(apples.isEmpty());
        apples.remove(1);
        System.out.println("array:"+apples.toArray());

        for(Apple a : apples)
            System.out.println(a.id());
    }




}
