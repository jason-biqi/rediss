package com.magic.redis.controller;

public class Test {


    private static  Test test=new Test();

    private Test() {
    }

    private static Test getInstance(){

        return test;
    }
}

class Test1{

    private static Test1 test1;

    private Test1(){}

    private static Test1 getInstance(){

        if (test1==null){
            test1=new Test1();
            return test1;
        }
        return null;
    }


        }
class Test2{

    private static Test2 test2;

    private Test2(){}

    private static synchronized  Test2 getInstance(){
        if (test2==null){
            test2=new Test2();
            return test2;
        }
        return null;
    }
}

class Test3{

    private static Test3 test3;

    private Test3(){}

    private static Test3 getInstance(){
        if (test3==null){

            synchronized (Test3.class){
                test3=new Test3();
            }
            return test3;
        }
        return test3;
    }


}