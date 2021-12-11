package com.pinggai.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Projects
 * @description:  解决线程安全问题 方式三： Lock锁  ---JDK5.0 新增
 *                  synchronized 与 lock的异同？
 *                  相同：二者都可以解决线程安全问题
 *                  不同：sychronized机制在执行同步代码后 自动释放同步监视器，
 *                      lock 则需要手动启动同步 lock() ,同时结束同步也需要手动的实现 unlock（）
 * @author: pingGai
 * @create: 2021-11-30 14:42
 **/

class Window implements Runnable{

    private static int ticket = 100;
    //第一步 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            //第二步 调用锁定方法lock（）
            try {
                lock.lock();
                if (ticket > 0 ){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 售票" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally{
                //第三步 调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}



public class LockTest {

    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
