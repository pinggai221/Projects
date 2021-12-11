package com.pinggai.java2;

import java.util.concurrent.*;

/**
 * @program: Projects
 * @description:
 * 使用线程池
 * * 好处：
 * * 1.提高响应速度（减少了创建新线程的时间）
 * * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * * 3.便于线程管理
 * *      corePoolSize：核心池的大小
 * *      maximumPoolSize：最大线程数
 * *      keepAliveTime：线程没任务时最多保持多长时间后会终止
 * @author: pingGai
 * @create: 2021-12-04 17:12
 **/

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

class NumberThread1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <=100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
        return 0 ;
    }
}


public class ThreadPool {

    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(10,null);


        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口的实现类的对象
        service.execute(numberThread); //适合用于Runnable
        service.submit(new NumberThread1()); //适合用于Callable

        //关闭连接池
        service.shutdown();


        //练习Callable线程的方式
        NumberThread1 numberThread1 = new NumberThread1();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numberThread1);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Integer o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
