package com.study.thread;

/**
 * 模拟线程死锁
 * 两个线程可能同时执行，一个线程先拿锁S1后拿S2，另一个线程先拿锁S2后拿S1。以上就容易发生死锁问题。sleep()阻塞线程，使之都进入阻塞状态，人为增加了两个线程死锁的几率
 *
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-20 13:27
 */
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                super.run();
                synchronized (s1) {
                    s1.append('a');
                    s2.append('1');
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2) {
                        s1.append('b');
                        s2.append('2');
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append('c');
                    s2.append('3');
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        s1.append('d');
                        s2.append('4');
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}