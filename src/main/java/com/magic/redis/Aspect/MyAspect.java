package com.magic.redis.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class MyAspect {

    @Pointcut(value = "execution(public int com.magic.redis.Aspect.MyMath.*(..) )")
    protected void ppintCat(){

    }
    @Before("ppintCat()")
    public void logStart(JoinPoint joinPoint){

        System.err.println(""+joinPoint.getSignature().getName()+"before"+ Arrays.asList(joinPoint.getArgs()));
    }
    @After("ppintCat()")
    public void logEnd(JoinPoint joinPoint){
        System.err.println(""+joinPoint.getSignature().getName()+"After");
    }
    @AfterReturning(value = "ppintCat()",returning = "result")
    public void logReturn(int result){

        System.out.println("return"+result);
    }
    @AfterThrowing(value = "ppintCat()",throwing = "exception")
    private void logException(Exception exception){
        System.out.println(exception.getMessage());
    }
}
