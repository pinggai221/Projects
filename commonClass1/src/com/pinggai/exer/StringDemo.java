package com.pinggai.exer;

import org.junit.Test;

/**
 * @program: Projects
 * @description:
 * @author: pingGai
 * @create: 2021-12-07 16:46
 **/
public class StringDemo {

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

    方式一：转换为char[]
     */

    public String revrse(String str, int startIndex, int endIndex){

        if (str != null){

            char[] arr = str.toCharArray();
            for (int i = startIndex, j = endIndex; i < j ; i++, j--) {
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            return  new String(arr);
        }

        return null;
    }

    //方式二 使用拼接
    public String revrse1(String str, int startIndex, int endIndex){

        if (str != null){
            //第一部分
            String reverseStr = str.substring(0, startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i-- ){
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex + 1);

            return reverseStr;

        }
        return null;
    }


    //方式三 使用Stringbuffer/Builder替换String
    public String revrse2(String str, int startIndex,int endIndex){

        if (str != null){

            StringBuilder reverseStr = new StringBuilder(str.length());
            reverseStr.append(str.substring(0,startIndex));
            for (int i = endIndex; i >= startIndex; i--){
                reverseStr.append(str.charAt(i));
            }
            reverseStr.append(str.substring(endIndex + 1));
            return new String(reverseStr);
        }



        return null;
    }

    @Test
    public void test(){

        String str = "ajlkghlakdlf";
        System.out.println(revrse(str, 3, 6));
        System.out.println(revrse1(str, 3, 6));
        System.out.println(revrse2(str, 3, 11));
        System.out.println(str.substring(1));



    }
}
