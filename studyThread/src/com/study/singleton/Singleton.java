package com.study.singleton;

/**
 * @author hubery
 * @email hubery1996@gmail.com
 * @created_at 2019-12-18 17:23
 */
public class Singleton {

}
class Bank{
    private Bank(){};
    private static Bank instance = null;

    public static Bank getInstance() {
        if(instance == null){
            instance = new Bank();
        }
        return instance;
    }
}
