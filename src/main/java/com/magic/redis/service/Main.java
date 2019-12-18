package com.magic.redis.service;


import java.util.concurrent.*;
import java.util.function.LongToIntFunction;


public class Main {


    public static void main(String[] args) throws Exception {

        Future submit = null;
        long start = System.currentTimeMillis();
        ThreadPoolExecutor pool=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,  new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<15;i++) {
//            Task task=new Task(i);
            Integer finalI = i;
            Callable callable=new Callable() {
                @Override
                public Object call() throws Exception {
                    System.err.println(Thread.currentThread().getName());
                    Thread.sleep(15-finalI);

                    if (finalI==5){
                        return 1;
                    }
                    return "callable";
                }
            };
             submit = pool.submit(callable);
            System.out.println("线程池中线程数目："+pool.getPoolSize()+"，队列中等待执行的任务数目："+
                    pool.getQueue().size()+"，已执行玩别的任务数目："+pool.getCompletedTaskCount());
        }
        pool.shutdown();

        Object o = submit.get();
        System.err.println(o);
        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }


}
