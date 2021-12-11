package com.pinggai.java;

/**
 * @program: Projects
 * @description:   使用同步代码块解决继承Thread类的方式的线程安全问题
 *                 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 * @author: pingGai
 * @create: 2021-11-03 10:45
 **/
class Window2 extends Thread{

    private  static int ticket = 100;

    public  Window2(String name){
        super(name);
    }

    private static synchronized void  mm(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "已售票号 " + ticket);
            ticket--;
        }
    }


    @Override
    public void run() {
        while (true){
//            synchronized (Window2.class) {   // Window2.class 类也是唯一的 也是对象
//                if (ticket > 0) {
//                    System.out.println(getName() + "已售票号 " + ticket);
//                    ticket--;
//                }else{
//                    break;
//                }
            mm();

        }
    }
}



public class WindowTest2{

    public static void main(String[] args) {
        Window2 w1 = new Window2("窗口一");
        Window2 w2 = new Window2("窗口二");
        Window2 w3 = new Window2("窗口三");

        w1.start();
        w2.start();
        w3.start();


    }

}


