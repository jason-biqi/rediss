package com.magic.redis.controller;


import com.magic.redis.entity.Letter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasonConfig {

    @Bean
    public Letter letter(){

        return new Letter("1,","2","3");
    }

}
