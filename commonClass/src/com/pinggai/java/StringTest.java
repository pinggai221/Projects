package com.pinggai.java;

import org.junit.Test;

/**
 * @program: Projects
 * @description:
 * @author: pingGai
 * @create: 2021-12-05 14:17
 **/
public class StringTest {

    /*
    结论：
    1.常量与常量的拼接结果在常量池，且常量池中不会存在相同的常量
    2.只要其中有一个是变量，结果就在堆空间中
    3。如果拼接的结果调用了intern（）方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3); //false

        final String s4 = "javaEE";//s4常量
        String s5 = s4 + "hadoop";
        System.out.println(s5 == s1);//true 因为是常量所以常量与常量的拼接在常量池中 所以其地址值是一样的

        System.out.println(s1 == s3.intern());//返回值得到的s3使用的常量值中已经存在的“javaEEhadoop” 所以是一样的地址值
    }






    /*
    string的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new + 构造器的方式
    面试题： string s = new string("abc"); 方式创建对象，在内存中创建了几个对象？
            两个，一个时堆空间中new结构，一个是char[]对应的常量池中的数据：”abc"
     */

    @Test
    public void test2(){
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2 ); //true
        System.out.println(s1 == s3 ); //false
        System.out.println(s1 == s4 ); //false
        System.out.println(s3 == s4); //false

        System.out.println("**********************8");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name)); //true
        System.out.println(p1.name == p2.name); //因为用字面定义的方式赋值 所以该字符串是常量池中的地址值 所以是true

        p1.name = "Jerry";
        System.out.println(p2.name); //Tom


    }




    /*
    String:字符串，使用一对""来表示
    1.string声明为final的，不可被继承
    2 string实现了Serializable接口：表示字符串是支持序列化的
            实现了Comparable接口：表示string可以比较大小的
    3.String内部定义了final char[] value 用于存储字符串数据
    4.string：代表不可变的字符序列，简称 不可变性
        体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
             2。当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
             3.当调用string的replace（）方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
    5.通过字面量的方式，给一个字符串赋值，此时的字符串值声明在字符串常量池中
    6.字符串常量池中时不会存储相同内容的字符串
     */

    @Test
    public void test1(){
        String s1 = "abc"; //字面量的定义方式
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2); // 比较的是地址值

        System.out.println(s1); // hello
        System.out.println(s2); // abc

        System.out.println("**********************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);// abcdef
        System.out.println(s2);

        System.out.println("***************");

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc




    }


    static class Person{
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
