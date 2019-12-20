package com.study.thread;

/**
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-10 13:45
 * <p>
 * 子进程执行：遍历100以内的所有偶数
 */

//创建一个继承于Thread类的子类
public class MyThread extends Thread {
    //重写run()
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}


