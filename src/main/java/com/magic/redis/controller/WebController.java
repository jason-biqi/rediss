package com.magic.redis.controller;

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
    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request){

        Map<String, String[]> parameterMap = request.getParameterMap();



        if (list.size()==0){
            list.add("1");
        }else {
            list.add(list.get(0)+"1");
            System.err.println(list.get(0));
        }
        return "index";
    }

}
