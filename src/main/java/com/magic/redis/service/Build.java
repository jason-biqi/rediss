package com.magic.redis.service;

public abstract class Build {


     void buildBase(){
         System.out.println("Build++++buildBase");
     }

    abstract void buildWall();

    abstract void loof();

    void aaa(){

        buildBase();
        buildWall();
        loof();
    }

}
