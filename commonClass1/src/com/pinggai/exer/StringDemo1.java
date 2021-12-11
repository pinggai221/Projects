package com.pinggai.exer;

import org.junit.Test;

/**
 * @program: Projects
 * @description:
 * @author: pingGai
 * @create: 2021-12-07 20:50
 **/
public class StringDemo1 {

    /*
    获取一个字符串在另一个字符串中出现的次数。
      比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数

     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength){
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else {
            return 0;
        }
    }

    @Test
    public void test(){
        String mainStr = "abkkcadkabkebfkaabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

}
