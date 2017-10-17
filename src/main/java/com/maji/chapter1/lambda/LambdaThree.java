package com.maji.chapter1.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 方法引用（操作符）
 */
public class LambdaThree {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cccc");
        list.add("b");
        list.add("eeeee");

        /**
         * :: 操作符格式 => 三种情况
         *    类::静态方法
         *    类::实例方法
         *    对象::实例方法
         *    由于使用第三种需要提供对象，一般使用不多
         */
        // 按字符串大小排序忽略大小写
        System.out.println("======字符串大小排序忽略大小写======");
        list.sort(String::compareToIgnoreCase);
        // 遍历打印 list 元素，forEach 是jdk8新增的default方法
        list.forEach(System.out::println);

        System.out.println("======按字符长度排序======");
        list.sort(Comparator.comparing(String::length));
        list.forEach(System.out::println);
    }

}
