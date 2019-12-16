package com.magic.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/get")
public class WebController {


    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request){

        Map<String, String[]> parameterMap = request.getParameterMap();

        System.err.println(parameterMap.get("loginName"));
        return "index";
    }

}
