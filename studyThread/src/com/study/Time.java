package com.study;

/*
 * @author hubery
 * @created_at 2019-12-31 10:04
 *
 * JDK8以前的时间类有:java.util.Date和java.sql.Date
 */
import org.junit.Test;
import java.util.Date;

public class Time {
    //System.currentTimeMillis()
    @Test
    public void Test1(){
        System.out.println(System.currentTimeMillis()); //1577758495656 12位的时间戳
    }
    @Test
    //java.sql.Date一种构造器public Date(long date)
    public void TestSql(){
        Date sqlDate = new java.sql.Date(1577758495656L);
        System.out.println(sqlDate); //2019-12-31
    }
    @Test
    //java.util.Date两种构造器public Date(long date)和public Date()
    public void TestUtil(){
        Date dateUtil = new Date();
        System.out.println(dateUtil); //Tue Dec 31 10:49:56 CST 2019

        Date dateUtil2 = new Date(1577758495656L);
        System.out.println(dateUtil2); //Tue Dec 31 10:14:55 CST 2019
    }

}
