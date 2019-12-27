package com.magic.redis.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.magic.redis.entity.AboutCompany;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {


    public static void main(String[] args) throws Exception {


        URL file =new URL("http://127.0.0.1:8765/test/redis");
        URLConnection connection = file.openConnection();
//        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
        int contentLength = connection.getContentLength();
        InputStream fis=  connection.getInputStream();
        DataInputStream data=new DataInputStream(fis);
        ByteArrayOutputStream byteInput=new ByteArrayOutputStream();
        FileOutputStream fos=new FileOutputStream("C:\\data\\show.png");


        byte[] bytes=new byte[1024];
        int i;

        while ((i=data.read(bytes))!=-1){
            byteInput.write(bytes,0,bytes.length);
        }
        byte[] bytes1 = byteInput.toByteArray();

        String s=new String(bytes1);
        JSONObject jsonObject = JSON.parseObject(s);
        AboutCompany aboutCompany = JSON.parseObject(s, AboutCompany.class);

        System.err.println(aboutCompany.getContent());
        fis.close();
        fos.close();

//        ApacheFileUtil2.zip("C:\\demo\\src\\main","C:\\demo\\src\\dc.zip");
//        boolean empty = StringUtils.isEmpty("");
//        System.err.println(empty);

    }




    public static void show() throws Exception{


    }

}

