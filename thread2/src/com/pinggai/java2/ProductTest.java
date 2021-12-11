package com.pinggai.java2;

/**
 * @program: Projects
 * @description: 线程通信的应用：经典例题：生产者/消费者问题
 * 生产者将产品交给店员，而消费者从店员处取走产品，店员一次只能维持固定数量产品（比如20）
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产
 * 如果店里没有产品了 店员会通知消费者等一下，如果店里有了产品再通知消费者来取走产品。
 * 分析：
 * 1.是否是多线程？是 生产者、消费者
 * 2.是否存在共享数据？是 店员或产品
 * 3.是否存在线程安全问题？是
 * 4.如何解决线程安全问题？同步机制 有三种方式
 * 5.是否涉及线程通信？是
 * @author: pingGai
 * @create: 2021-12-01 13:02
 **/

class Clerk {

    private int commodityNumber = 0;

    //生产产品
    public synchronized void production() {
        if (commodityNumber < 20) {
            commodityNumber++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + commodityNumber + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //消费产品
    public synchronized void consumption() {
        if (commodityNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + commodityNumber + "个产品");
            commodityNumber--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Productor extends Thread {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":生产者开始生产产品....");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.production();
        }
    }
}


class Customer extends Thread {

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":消费者开始消费产品....");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumption();
        }

    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);
        productor.setName("生产者1");
        customer.setName("消费者1");

        Customer customer1 = new Customer(clerk);
        customer1.setName("消费者2");

        productor.start();
        customer.start();
        customer1.start();
    }
}
