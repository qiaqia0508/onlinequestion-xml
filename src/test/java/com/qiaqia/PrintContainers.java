package com.qiaqia;

import org.junit.Test;

import java.util.*;

public class PrintContainers {
    static Collection fill(Collection<String> collection){
        collection.add("tom");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String,String> map){
        map.put("tom","qiaqia");
        map.put("cat","judy");
        map.put("dog","haha");
        map.put("dog","nini");
        return map;
    }

    public static void main(String[] args){
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new HashMap<String,String>()));
        System.out.println(fill(new TreeMap<String,String>()));
        System.out.println(fill(new LinkedHashMap<String,String>()));

    }


    @Test
    public void get(){
        List<String> name = new ArrayList<String>();
        name.add("nana");
        name.add("haha");
        name.add("qiaqia");
        System.out.println(name.iterator());

        Iterator<String> n = name.iterator();
        while(n.hasNext()){
            String m = n.next();
            System.out.println("m:"+m);
        }

        n = name.iterator();
        for(int i=0;i<2;i++){
            n.next();
            n.remove();
        }
        System.out.println(name);
    }
}
