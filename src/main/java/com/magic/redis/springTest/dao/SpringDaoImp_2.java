package com.magic.redis.springTest.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDaoImp_2 implements SpringDao {

    @Value("${color.id}")
    private String lable;
    @Override
    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
