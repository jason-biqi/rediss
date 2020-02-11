package com.magic.redis.Aspect;

import com.magic.redis.springTest.BeanConfig;
import com.sun.scenario.effect.Merge;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListenerMethodProcessor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public class AspectText {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        AnnotationConfigApplicationContext configContext=new AnnotationConfigApplicationContext(AspectCongfig.class);

        configContext.publishEvent(new ApplicationEvent(new String("jasonEvent")) {
        });
        MyMath bean = configContext.getBean(MyMath.class);
//        EventListenerMethodProcessor
        int div = bean.div(1, 1);
        Wheel bean1 = configContext.getBean(Wheel.class);
//        System.out.println(bean);

        
        configContext.close();
//        System.out.println(div);

    }
}
