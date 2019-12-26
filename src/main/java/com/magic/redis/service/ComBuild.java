package com.magic.redis.service;

public class ComBuild extends Build {
    @Override
    void buildBase() {
        System.out.println("buildBase");
    }

    @Override
    void buildWall() {
        System.out.println("buildWall");
    }

    @Override
    void loof() {
        System.out.println("loof");
    }

    @Override
    void aaa() {
        super.buildBase();
        super.aaa();
    }
}
