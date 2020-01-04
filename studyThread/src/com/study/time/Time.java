package com.study.time;

/*
 * @author hubery
 * @created_at 2019-12-31 10:04
 *
 * JDK8以前的时间类有:java.util.Date和java.sql.Date
 * java.util.Date   两种构造器public Date(long date)和public Date()
 * java.sql.Date    一种构造器public Date(long date)
 * 格式化时间的类:SimpleDateFormat
 */
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void TestUtil() {
        Date dateUtil = new Date();
        System.out.println(dateUtil); //Tue Dec 31 10:49:56 CST 2019

        Date dateUtil2 = new Date(1577758495656L);
        System.out.println(dateUtil2); //Tue Dec 31 10:14:55 CST 2019
    }
    @Test
    public void TestSimpleDateFormat() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //格式化
        String format1 = sdf1.format(date);//2019-02-18 11:58:27
        System.out.println(format1);
        //解析成Date对象 解析可能会抛出解析异常，需要处理
        Date date2 = sdf1.parse(format1);
        //调用日期对象的getTime()方法获取时间戳
        System.out.println(date2.getTime());
    }

}
