package com.magic.redis.springTest;

import org.springframework.beans.factory.annotation.Value;


public class Color {

    @Value("1")
    private Integer UUID1;
    @Value("${color.name}")
    private String name1;

    @Override
    public String toString() {
        return "Color{" +
                "UUID1=" + UUID1 +
                ", name1='" + name1 + '\'' +
                '}';
    }
}
