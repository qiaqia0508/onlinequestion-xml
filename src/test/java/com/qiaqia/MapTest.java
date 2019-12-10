package com.qiaqia;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapTest {
    public static void main(String[] args){
        Random random = new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0; i < 10000; i++){
            int  r = random.nextInt(20);
            Integer f = m.get(r);
            m.put(r,f==null?1:f+1);
        }
        System.out.println(m);
    }
}
