package com.pinggai;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Projects
 * @description:     银行有一个账户 有两个储户分别向同一个账号存3000元 存三次，每次存1000元
 *                  分析：
 *                  1.是否是多线程问题？ 是，两个储户线程
 *                  2.是否有共享数据？ 有 ，账户余额
 *                  3.是否有线程安全问题？ 有
 *                  4、需要考虑如何解决线程安全问题，同步机制：有三种方式
 * @author: pingGai
 * @create: 2021-11-30 16:30
 **/

class Account {

    public static double  balance;

//    public synchronized void deposit(double atm){
//        balance += atm;
//        System.out.println(Thread.currentThread().getName() +"存钱1000余额为：" + balance);
//    }

}


class User extends Thread{

    private Account account;
    private static ReentrantLock lock = new ReentrantLock();

    public User(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            lock.lock();

            account.balance += 1000;
            System.out.println(Thread.currentThread().getName() +"存钱1000余额为：" + account.balance);
            lock.unlock();
            //account.deposit(1000);
        }
    }
}

public class Exercise {
    public static void main(String [] args){
        Account account = new Account();
        User u1 = new User(account);
        User u2 = new User(account);
        u1.setName("甲");
        u2.setName("乙");
        u1.start();
        u2.start();
    }
}
