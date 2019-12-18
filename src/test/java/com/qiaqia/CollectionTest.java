package com.qiaqia;

import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Integer> a = new ArrayList<Integer>();
        List<Integer> age = new ArrayList<Integer>();
        if (!age.contains(1)) {
            age.add(1);
        }
        System.out.println("age:" + age);
        Collection<Integer> b = new HashSet<Integer>();
        if (!b.contains(1)) {
            b.add(1);
        }
        System.out.println("b:" + b);


        Set aha = new HashSet();
        aha.add("12");
        aha.add("12");
        aha.add("44");
        aha.add("aa");
        for (Object j : aha) {
            System.out.print(j);
        }
    }

    @Test
    public void testArray() {
        Integer[] aa = new Integer[4];
        aa[0] = 1;
        aa[1] = 2;
        aa[2] = 3;
        aa[3] = 4;
        Collection<Integer> c = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        c.addAll(Arrays.asList(aa));
        System.out.println(c);

        Collections.addAll(c,11,22,33);
    }


}
