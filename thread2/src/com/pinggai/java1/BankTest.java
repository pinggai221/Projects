package com.pinggai.java1;

/**
 * @program: Projects
 * @description: 使用同步机制将单例模式懒汉式修改为线程安全
 * @author: pingGai
 * @create: 2021-11-04 12:21
 **/

class Bank{
    private static Bank instance = null;

    private Bank(){}

    public static Bank getInstance(){
        if (instance == null) {
            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

//        synchronized(bank.class){    方式二 ： 效率略低
//        if (instance == null){
//            instance = new Bank();
//        }
//        return instance
//    }
}


public class BankTest {
}
