package com.maji.chapter1.lambda;

import java.util.ArrayList;

/**
 * 使用Lambda 进行比较
 */
public class LambdaTwo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        System.out.println(list.toString());

        // 原来写法
        //list.sort(new Comparator<Integer>() {
        //    @Override
        //    public int compare(Integer o1, Integer o2) {
        //        return o1.compareTo(o2);
        //    }
        //});

        //Lambda 表达式
        //list.sort(((o1, o2) -> {
        //    o1.compareTo(o2);
        //}));

        // 简写Lambda
        list.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println(list.toString());
    }

}
