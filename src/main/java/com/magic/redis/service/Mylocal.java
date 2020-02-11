package com.magic.redis.service;

public class Mylocal {

    private static Boolean flag;

    private  static String name;
//    static {
//        flag=1==1;
//        Mylocal mylocal= new Mylocal();
//        System.out.println(1/0);
//    }
{
    System.out.println("new ");
}

    public static Boolean getFlag() {
        return flag;
    }

    public static String getName() {
        return name;
    }

    private  String Newname;

    public String getNewname() {
        return Newname;
    }

    public void setNewname(String newname) {
        Newname = newname;
    }
}
