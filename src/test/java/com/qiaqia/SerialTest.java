package com.qiaqia;



import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class SerialTest {

    @Test
    public void test() throws UnsupportedEncodingException {

        String a = new String("abc国");

        byte[] abts = a.getBytes("utf-8");

        String b = new String("abc国");

        byte[] bbts = b.getBytes("gbk");

        System.out.println(abts+"\t"+bbts);
    }
}
