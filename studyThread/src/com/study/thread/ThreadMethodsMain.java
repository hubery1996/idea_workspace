package com.study.thread;

/**
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-10 15:07
 */
public class ThreadMethodsMain extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //Thread.currentThread().getName() 获取线程名
                System.out.println(Thread.currentThread().getName()+i);
            }
            if(i == 80) {
                try {
                    //sleep() 睡眠方法默认会抛出InterruptedException异常
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
