package com.magic.redis.springTest.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//@Repository
public class SpringDaoImp_1 implements SpringDao {

    @Value("${color.name}")
    private String lable;


    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String getLable() {
        return null;
    }
}
