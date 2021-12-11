package com.pinggai.java;

/**
 * @program: Projects
 * @description: 使用同步方法解决继承Thread线程安全问题
 *
 *                  关于同步方法的总结：
 *               1、同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *               2、非静态的同步方法，同步监视器是：this
 *                  静态的同步方法，同步监视器是：当前类本身.class
 *
 * @author: pingGai
 * @create: 2021-11-03 23:34
 **/

class Window4 extends Thread{

    private  static int ticket = 100;

    public  Window4(String name){
        super(name);
    }


    @Override
    public void run() {
        while (ticket > 0){
            show();
        }
    }

    public static  synchronized void show(){  //同步监视器：Window4.class
        //public synchronized void show(){  //同步监视器：t1 t2 t3,此种解决方式是错误的 监视器不是唯一的
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "已售票号 " + ticket);
            ticket--;
        }

    }

}


public class WindowTest4{

    public static void main(String[] args) {
        Window4 w1 = new Window4("窗口一");
        Window4 w2 = new Window4("窗口二");
        Window4 w3 = new Window4("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }

}

// 单例模式 懒汉式
class A {
    private A(){}
    private static A instance = null;

    public static A getInstance(){
        if (instance  == null){
            instance = new A();
        }
        return instance ;

    }

}



// 饿汉式
class B{
    private B(){}
    private static B instance = new B(); /*或  private static B instance = null;
                                                static { instance = new B(); } */
    public static B getInstance(){
        return instance;
    }
}
