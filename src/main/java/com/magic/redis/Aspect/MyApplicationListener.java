package com.magic.redis.Aspect;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.apache.tomcat.jni.Multicast;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ApplicationEvent: " +event);
    }
}
