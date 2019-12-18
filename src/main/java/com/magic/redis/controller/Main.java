package com.magic.redis.controller;


import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;

public class Main {


    public static void main(String[] args) throws Exception {

        ApacheFileUtil2.zip("C:\\demo\\src\\main","C:\\demo\\src\\dc.zip");
        boolean empty = StringUtils.isEmpty("");
        System.err.println(empty);

    }




    public static void show() throws Exception{


    }

}

