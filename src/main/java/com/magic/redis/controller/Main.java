package com.magic.redis.controller;


import cn.mp.ms.common.constant.EinkConstants;
import cn.mp.ms.common.util.BeanUtil;
import cn.mp.ms.common.util.FileUtil;
import cn.mp.ms.common.util.PathUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Sets;
import com.magic.redis.entity.NotebookBo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class Main {


    public static void main(String[] args) throws Exception {


        URL url=Main.class.getClassLoader().getResource("com");

        System.err.println(url);

    }




    public static void show() throws Exception{


    }

}

