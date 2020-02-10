package com.magic.redis.Aspect;

import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class,MyImportSelector.class})
public class AspectCongfig {

    @Bean
    public MyMath myMath(){
        return new MyMath();
    }
    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }
//    @Bean
//    public MyApplicationListener myApplicationListener(){
//        return new MyApplicationListener();
//    }
}
