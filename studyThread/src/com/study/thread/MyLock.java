package com.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁解决线程安全问题
 * 
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-20 14:37
 */
abstract class MyLock implements Runnable {
    private int tickets = 100;
    //ReentrantLock重载构造器中的true参数，表示此时的进程按照栈的先进先出的方式顺序的控制进程执行，而不是被cpu随机分配控制权
    //1.实例化ReentrantLock构造器
    private ReentrantLock reentrantLock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true) {
            //2.创建lock同步锁
            reentrantLock.lock();
            //3.try...finally包裹操作线程共享的代码
            try {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " 售出车票：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
            finally {
                //4.释放lock同步锁
                reentrantLock.unlock();
            }

        }
    }
}
