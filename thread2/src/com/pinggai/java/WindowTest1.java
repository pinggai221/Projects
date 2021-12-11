package com.pinggai.java;

/**
 * @program: Projects
 * @description:  创建三个窗口线程卖票  总票数100 用Runnable接口方式
 *                1、问题：买票过程中 出现重票、错票 --> 存在线程安全问题
 *                2、问题出现的原因：当某个线程操作车票的过程中 尚未操作完成时，其他线程参与进来也操作车票
 *                3、如何解决：当一个线程A在操作ticket的时候，其他线程不能参与进来。直到线程A操作完成ticket后， 其他线程才可以开始操作ticket
 *                这种情况即使线程A出现了阻塞，也不能被改变
 *
 *              在Java中 我们用同步机制来解决线程安全问题。
 *
 *                方式一：同步代码块
 *                   synchronized(同步监视器) {  //不能包含的代码多了 也不能少了
 *                       //需要同步的代码
 *                   }
 *                 说明：1、操作共享数据的代码，即为需要被同步的代码
 *                      2、共享数据：多个线程共同操作的变量，比如ticket就是共享数据。
 *                      3、同步监视器 俗称： 锁。任何一个类的对象 都可以充当锁，但多个线程必须共用一把锁。
 *                 补充： 在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 *
 *                方式二：同步方法
 *                      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *
 *
 *
 *                5、同步的方式解决了线程安全问题 ---好处
 *                  操作同步代码时，只有一个线程参与 其他线程等待 相当于单线程 效率低 ---局限性
 *
 * @author: pingGai
 * @create: 2021-11-01 15:13
 **/

class Window1  implements Runnable {
    private  int ticket = 100;
   // private Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (this){   // 或 synchronized（Window1.class） /sybchronized (object)

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "已售票号:" + ticket);
                    ticket --;
                }else{
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {

        Window1 w = new Window1();

        Thread t1 = new Thread(w,"窗口一");
        Thread t2 = new Thread(w, "窗口二");
        Thread t3 = new Thread(w, "窗口三");
        t1.start();
        t2.start();
        t3.start();





    }
}
