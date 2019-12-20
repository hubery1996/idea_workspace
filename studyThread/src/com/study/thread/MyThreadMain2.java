package com.study.thread;

/**
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-11 14:41
 */
//1.创建一个是实现了Runnable接口的类
class MyThread2 implements Runnable {
    //2.实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+ + i);
            }
        }
    }
}

public class MyThreadMain2{
    public static void main(String[] args) {
        //3.创建实现类的对象
        MyThread2 myThread2 = new MyThread2();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(myThread2);
        //5.通过Thread类的对象调用start()
        thread1.start();

        //再启动一个线程
        Thread thread2 = new Thread(myThread2);
        thread2.start();
    }
}

