package com.maji.chapter3.optional;

import java.util.ArrayList;
import java.util.Optional;

/**
 * 主要是用来防止空指针异常
 * 参考了Guava项目
 */
public class OptionalTest {
    public static void main(String[] args) {

        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);
        System.out.println("========");
        System.out.println(getLength(strA));
        System.out.println(getLength(""));
        System.out.println(getLength(strB));

        System.out.println("========");
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(1);
        /**
         * ofNullable，生成一个Optional对象
         * ifPresent，如果存在，则执行代码
         */
        Optional.ofNullable(list).ifPresent(value ->value.forEach(System.out::println));

    }

    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        //if (text != null) {
        //    System.out.println("old:"+text);
        //}
    }
    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    };

}
