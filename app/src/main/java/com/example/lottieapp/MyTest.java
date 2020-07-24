package com.example.lottieapp;

import android.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import kotlin.text.Regex;

public class MyTest {

    public static void main(String[] args) {
//        System.out.println(toInt(new byte[]{-1, 36}));
//        Boolean a = true;
//        String b = "true";
//        String c = "false";
//        Integer d = 3;
//
//        MyCollections.getArrayListInstance();
//        MyCollections.getLinkedListInstance();
////        System.out.println(MyCollections.getArrayListInstance());
////        System.out.println(MyCollections.getLinkedListInstance());
//        System.out.println(Apple.FUJI.weight());
//
//
//        List<String> strList = new ArrayList<String>();
//        strList.add("ad");
//        strList.add("ad24");
//        strList.add("add");
//        strList.add("ad321");
//        strList.add("ad1222");
//
//        Collections.sort(strList, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
//        for (String str : strList) {
//            System.out.println(str);
//        }

//        plusOne(new int[]{1,2,3});
//        System.out.println(0 %10);
        System.out.println(Arrays.toString(reverseStr(new char[]{'H','e','l','H', 'l', 'o'})));
    }

    public static char[] reverseStr(char[] s) {
        int left =0;
        int right = s.length -1;

        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;

        }
        return s;
    }


    public static int[] plusOne(int[] digits) {
//        int num = 0;
//        int expectLength = digits.length;
//
//        for (int i = 0; i < digits.length; i++) {
//            num += Math.pow(10, digits.length - i - 1) * digits[i];
//            System.out.println(num );
//        }
//        num += 1;
//
//        if (digits[0] / 9 == 1 && digits[digits.length - 1] / 9 == 1) {
//            expectLength++;
//        }
//        int[] outArr = new int[expectLength];
//
//        for (int i = 0; i < expectLength; i++) {
//            outArr[i] = (int)(num / (Math.pow(10, expectLength - i - 1)));
//            num -= (int) (Math.pow(10, expectLength - i - 1) * outArr[i]);
//        }
//
//        System.out.println("输出数组：" + Arrays.toString(outArr));
//
//        return outArr;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        System.out.println(Arrays.toString(digits));
        return digits;

    }
}


