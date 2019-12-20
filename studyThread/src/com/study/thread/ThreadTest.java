package com.study.thread;

/**
 * 创建两个线程，分别输出100以内的奇数和偶数
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-10 14:53
 */
//方式一
/*public class ThreadTest {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
}
class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class ThreadB extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}*/

//方式二 创建Thread类匿名子类的对象
public class ThreadTest{
    public static void main(String[]args){
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
