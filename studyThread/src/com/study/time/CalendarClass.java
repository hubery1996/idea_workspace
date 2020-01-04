package com.study.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
/*
 * @author hubery
 * @created_at 2019-12-31 16:58
 *
 * Calendar：日历类（抽象类）
 * 实例化Calendar类的两种方式：1.创建子类（GregorianCalendar）的对象。2.调用其静态方法getInstance()
 */

public class CalendarClass {

    @Test
    public void CalendarTest(){
        Calendar oCalendar = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = oCalendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(oCalendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        oCalendar.set(Calendar.DAY_OF_MONTH,22);
        days =oCalendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        oCalendar.add(Calendar.DAY_OF_MONTH,-3);
        days =oCalendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = oCalendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        oCalendar.setTime(date1);
        days =oCalendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
