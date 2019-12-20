package com.study.thread;

/**
 * 创建三个售票窗口，总票数为100张。
 *
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-11 15:53
 */
public class WindowsTest {
    public static void main(String[] args) {
        //创建三个线程
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();
        //重命名线程名
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        //启动线程
        w1.start();
        w2.start();
        w3.start();
    }
}

class window extends Thread {
    //此属性变量如果没有静态化，在创建线程时将会开辟将创建多个
    private static int tickets = 100;

    @Override
    public void run() {
        super.run();
            while (true) {
              method();
            }

    }
    //线程锁:同步方法实现,由于此线程是继承的方式,所以同步方法需要为静态的,默认的同步控制器则变为当前类的对象(window.class)
    //同步方法为synchronized修饰的方法
    private static synchronized void method(){
        if (tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 售出车票：" + tickets);
            tickets--;
        }
    }
}
/*
class window extends Thread {
    //此属性变量如果没有静态化，在创建线程时将会开辟将创建多个
    private static int tickets = 100;

    @Override
    public void run() {
        super.run();
        //线程锁:代码块的方式,此时的锁是当前类的对象，类只加载一次，所以它的class对象也就是唯一的。
        synchronized(window.class){
            while (true) {
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
