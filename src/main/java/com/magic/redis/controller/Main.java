package com.magic.redis.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Sets;
import com.magic.redis.entity.NotebookBo;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {


        File file1=new File("C:/data/bookfm/doc/ta_zues/upload/file/73d/17/37/952f29d01401000/temp");
        System.err.println(file1.getAbsolutePath().substring(8));


    }




    public static void show() throws Exception{

        BufferedImage read = ImageIO.read(new URL("https://axure-file.lanhuapp.com/21bc31db-5a9f-4228-a37a-75741cfccf20__a1fc3e3ffbe3e7fa4ae266fccae78327.png"));
        BufferedImage tmpImg = new BufferedImage(250, 369, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        Graphics2D g2d = tmpImg.createGraphics();
//        g2d.setBackground(Color.WHITE);
//        g2d.drawLine(0,0,500,500);
//        g2d.setFont(new Font("楷体",Font.PLAIN,50));
//        g2d.drawString("✌",500,500);
        Graphics2D graphics = read.createGraphics();
        g2d.drawImage(read,1,1,250,369,null);
//        g2d.drawImage(read,1,1,500,480,null);


        ImageIO.write(tmpImg,"jpg",new File("cc.png"));


    }

}

