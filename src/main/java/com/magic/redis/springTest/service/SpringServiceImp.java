package com.magic.redis.springTest.service;

import com.magic.redis.springTest.dao.SpringDao;
import com.magic.redis.springTest.dao.SpringDaoImp_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpringServiceImp implements SpringService {

//    @Qualifier("springDaoImp_1")
//    @Resource
    private SpringDao springDao;

    public SpringServiceImp(SpringDao springDao) {
        this.springDao = springDao;
    }

    public SpringDao getSpringDao() {
        return springDao;
    }

    public void setSpringDao(SpringDaoImp_1 springDao) {
        this.springDao = springDao;
    }
}
