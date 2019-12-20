package com.study.thread;

/**
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-10 14:07
 */
public class MyThreadMain {
    public static void main(String[] args) {
        //main线程创建子类对象
        MyThread myThread = new MyThread();
        //调用父类的start()方法启动子线程，线程只能执行一次，多次启动会报错，可以新建一个对象实例来启动一个新的线程
        myThread.start();
        //main线程执行和子线程相同代码，此时就能看到多个线程同时运行了
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //Thread.currentThread().getName() 获取线程名
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
