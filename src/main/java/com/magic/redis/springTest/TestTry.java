package com.magic.redis.springTest;

import com.magic.redis.springTest.service.SpringServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTry {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configContext=new AnnotationConfigApplicationContext(BeanConfig.class);
        SpringServiceImp s2 = (SpringServiceImp) configContext.getBean("springServiceImp");
        Object springServiceImp = configContext.getBean("springDaoImp_2");
        System.err.println(springServiceImp);
        System.err.println(s2.getSpringDao());
        MyComponent bean = configContext.getBean(MyComponent.class);
        System.err.println(bean);
        configContext.close();
    }


}
