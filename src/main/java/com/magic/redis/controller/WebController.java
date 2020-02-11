package com.magic.redis.controller;

import com.magic.redis.Aspect.MyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class WebController {

    private static List<String> list=new ArrayList<>();


    @Autowired
    MyMath myMath;

    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request){

     myMath.div(11,11);

        return "index";
    }

}
