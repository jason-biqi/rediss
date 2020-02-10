package com.magic.redis.springTest;

import com.magic.redis.entity.Letter;
import org.springframework.beans.factory.Aware;
import org.springframework.context.annotation.*;

@PropertySource(value = {"classpath:/bean.properties"})
@Configuration
@ComponentScan("com.magic.redis.springTest")
@Import(Letter.class)
public class BeanConfig {


    @Conditional({WindowsCondition.class})
    @Bean
    public Person bill(){
        Person person=new Person();
        person.setName("bill");
        person.setAge(60);
        return person;
    }
    @Conditional({LinuxCondition.class})
    @Bean
    public Person linus(){
        Person person=new Person();
        person.setName("linus");
        person.setAge(50);
        return person;
    }
    @Bean
    public Color color(){
        return new Color();
    }
    @Scope("prototype")
    @Bean(initMethod ="init",destroyMethod = "destroy")
    public SpringBeanLifeCycle springBeanLifeCycle(){
        return new SpringBeanLifeCycle();
    }
}
