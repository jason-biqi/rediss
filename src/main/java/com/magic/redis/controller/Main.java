package com.magic.redis.controller;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;


public class Main {


    public static void main(String[] args) throws Exception {



        URL url=Main.class.getClassLoader().getResource("com");

        ApplicationContext ac=new AnnotationConfigApplicationContext(JasonConfig.class);
        Environment environment = ac.getEnvironment();
        String property = environment.getProperty("os.name");

        Object letter = ac.getBean("letter");
        System.out.println(property);


    }




    public static void show() throws Exception{


    }

}

