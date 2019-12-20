package com.study.thread;

/**
 * 创建三个售票窗口，总票数为100张。
 *
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-11 15:28
 */
public class WindowsTest2 {
    public static void main(String[] args) {
        //创建实现类的对象
        window2 window2 = new window2();
        //创建三个售票窗口，三个进程，实现类的对象传递给Thread的构造器.体现多态性
        Thread w1 = new Thread(window2);
        Thread w2 = new Thread(window2);
        Thread w3 = new Thread(window2);
        //三个售票重命名
        w1.setName("售票窗口：1");
        w2.setName("售票窗口：2");
        w3.setName("售票窗口：3");
        //启动线程
        w1.start();
        w2.start();
        w3.start();
    }
}

//window类实现Runnable接口
/*class window2 implements Runnable {
    //这里属性不是静态的，因为在实例化Thread需要的实现类对象都是同一个。指针指向了对应的Thread实例，所以tickets是共享的，因此不需要静态化
    private int tickets = 100;
    //重写Runnable接口的run()方法
    @Override
    public void run() {
        while (true) {
            //线程锁，锁为this，此时的this指的是调用当前类的对象
            synchronized (this){
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " 售出车票：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }

        }
    }
}*/
//线程锁:同步方法形式,
class window2 implements Runnable {
    //这里属性不是静态的，因为在实例化Thread需要的实现类对象都是同一个。指针指向了对应的Thread实例，所以tickets是共享的，因此不需要静态化
    private int tickets = 100;
    //重写Runnable接口的run()方法
    @Override
    public void run() {
        while (true) {
            //调用同步线程
            method();
        }
    }
    //实现Runnable类的线程的同步方法中的锁为this,即为调用该方法的对象
    public synchronized void method(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 售出车票：" + tickets);
            tickets--;
        }
    }
}