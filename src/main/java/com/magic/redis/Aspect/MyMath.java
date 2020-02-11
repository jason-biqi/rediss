package com.magic.redis.Aspect;


import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.event.EventListener;

public class MyMath {

    static {
        String name = Thread.currentThread().getName();
        System.out.println("static{}"+name);
//        SmartInitializingSingleton
    }
//    @EventListener
    public int div(int i,int j){

        System.out.println("++++div++++");
        return i/j;
    }



}
