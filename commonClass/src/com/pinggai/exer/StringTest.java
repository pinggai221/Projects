package com.pinggai.exer;

/**
 * @program: Projects
 * @description:
 * @author: pingGai
 * @create: 2021-12-05 16:18
 **/
public class StringTest {

    String str = new String("good"); //这new的在堆空间
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str,char ch[]){  //此时的str是常量,赋值的也是常量并不是属性str的地址值
        str = "test ok";
        ch[0] = 'b';
        System.out.println(str);
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str,stringTest.ch);
        System.out.println(stringTest.str);//good
        System.out.println(stringTest.ch);//best
//解析
        String s2 = new String("hhh");
        String s3 = s2; //这时拿到的是值，不是地址值
        System.out.println(s3 == s2); //验证 false
        s3 = "jjj";
        System.out.println(s2+" " + s3);

    }
}
