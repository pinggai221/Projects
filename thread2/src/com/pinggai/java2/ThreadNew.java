package com.pinggai.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Projects
 * @description:
 *  创建线程的方式三; 实现Callable接口的方创  ---JDK 5.0 新增
 *
 *  如何理解实现Callable接口的方式创建多线程比Runnable接口创建多线程方式强大？
 *  1.call（）可以有返回值的。
 *  2.call（）可以抛出异常，被外面的操作捕获，获取异常信息
 *  3.Callable是支持泛型的
 *
 * @author: pingGai
 * @create: 2021-12-01 17:17
 **/
//1.创建Callable的实现类
class NumThread implements Callable<Integer> {
    //实现call方法，将此线程需要执行的的操作声明在call（）中
    @Override
    public Integer call() {
        int num = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                num += i;
            }
        }


        return num;
    }
}


public class ThreadNew {

    public static void main(String[] args) {
        //3.创建Callable接口的实现类对象
        NumThread numThread = new NumThread();
        //4.创建FutureTask的对象 将此Callable接口的实现类对象作为传递到FutureTask构造器中
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        //5.创建Thread对象，把FutureTask的对象作为参数传递到Thread的构造器中，调用Start（）
        Thread thread = new Thread(futureTask);

        thread.start();

        try {
            // 6.获取Callable中call方法返回值
            // get()返回值即FutureTask构造器参数Callable实现类重写的call（）的返回值
            Integer num = futureTask.get();
            System.out.println("总和为：" + num);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
