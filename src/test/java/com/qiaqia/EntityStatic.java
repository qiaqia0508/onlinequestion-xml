package com.qiaqia;

public class EntityStatic {

    static int id = 1;

    static int idPlus = 0;

    int nostaticid = idPlus++;

    public EntityStatic(){
        System.out.println(idPlus);
    }

    public void test1(){

        System.out.println(EntityStatic.idPlus);
        System.out.println(this.nostaticid);
    }

    public static void test2(){

        System.out.println(idPlus);
        //System.out.println(nostaticid);
    }
}
