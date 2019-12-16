package com.magic.redis.service;

import com.magic.redis.dao.AboutCompanyMapper;
import com.magic.redis.entity.AboutCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AboutCompanyService {


    @Autowired
    private AboutCompanyMapper aboutCompanyMapper;

    public AboutCompany findOne(){


        return  aboutCompanyMapper.findById(1);
    }
    public List<Map<String, String>> findMap(){

        List<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        return  aboutCompanyMapper.findTileAndCount(list);
    }

    @Async
    public void myAsync(){

        while (true){

            System.err.println(Thread.currentThread().getName());

        }


    }

}
