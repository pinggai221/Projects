package com.pinggai.java;

/**
 * @program: Projects
 * @description:    使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author: pingGai
 * @create: 2021-11-03 11:35
 **/

class Window3  implements Runnable {
    private  int ticket = 100;
    @Override
    public void run() {
        while (ticket > 0) {
            show();
        }
    }

    public synchronized void show(){   //同步方法
        //同步监视器是this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "已售票号:" + ticket);
            ticket --;
        }

    }


}


public class WindowTest3 {
    public static void main(String[] args) throws InterruptedException {

        Window3 w = new Window3();

        Thread t1 = new Thread(w,"窗口一");
        Thread t2 = new Thread(w, "窗口二");
        Thread t3 = new Thread(w, "窗口三");
        t1.start();
        t2.start();
        t3.start();


        Thread.currentThread().join(15000);
        //Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println(t3.isAlive());





    }
}