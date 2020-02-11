package com.magic.redis.springTest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBeanLifeCycle {
    private static int init=1;

    private int UUID;
    private String name;

    public void init(){

        UUID=init++;
        System.err.println("init=====");
    }

    public void destroy(){
        System.err.println("destroy");
    }



}
