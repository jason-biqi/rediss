package com.magic.redis.controller;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:BBB
 * @Description: TODO
 * @Date 16:27
 */
public class BBB extends AAA implements CCC {

    private static Object DispatcherServlet;

    @Override
    public  void aaa() {
        super.aaa();
        System.err.println("BBBBB");
    }


    public static void main(String[] args) {

       BBB bbb=null;
//       bbb.aaa();
        int i = new BBB().hashCode();
        CCC ccc=new BBB();
       AAA aaa=new BBB();

       System.err.println(i);
    }

    @Override
    public void ccc() {
        System.err.println("cccc");
    }
}
