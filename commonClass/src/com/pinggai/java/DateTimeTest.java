package com.pinggai.java;

import org.junit.Test;

import java.util.Date;

/**
 * @program: Projects
 * @description:
 * @author: pingGai
 * @create: 2021-12-07 16:00
 **/
public class DateTimeTest {

    /*
    java.util.Date类
           |---java.sql.Date类

    1.两个构造器的使用
        >构造器一：Date()：创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象
    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
     */

    @Test
    public void test(){
        //构造器一  Date（）：创建一个当前时间的date对象
        Date date = new Date();
        System.out.println(date.getTime() +"   " + date.toString());

        //构造器二  Date(Long long) 创建指定毫秒数的Date对象
        Date date1 = new Date(9382749837L);
        System.out.println(date1);

        //创建java.sql.Date对象
        java.sql.Date date2 = new java.sql.Date(79837928592l);
        System.out.println(date2);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date4 = new Date();
        java.sql.Date date3 = new java.sql.Date(date4.getTime());
    }

    @Test
    public void test2(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
    }

}
