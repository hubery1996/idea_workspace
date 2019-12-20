package com.study.singleton;

/**
 * 同步解决懒汉式线程不安全的方式
 *
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-18 17:23
 */
public class Singleton {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    //方式一：效率低
   /* public static synchronized Bank getInstance() {
        if(instance == null){
            instance = new Bank();
        }
        return instance;
    }*/
    //方式二：效率低
    /* public static Bank getInstance() {
        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
        }
        return instance;
    }*/
    //方式三：效率高
    public static Bank getInstance() {
        //这里当两个线程到到达时，同步执行后，instance此时被赋值，其余的进程再执行到这里就不需要拿线程锁了。
        //比上面两种方式效率高
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        //直接return数据不属于操作数据
        return instance;
    }
}
