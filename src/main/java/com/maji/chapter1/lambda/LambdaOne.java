package com.maji.chapter1.lambda;

/**
 * Lambda 表达式
 */
public class LambdaOne {
    public static void main(String[] args) {
        // 原方法创建线程
        Thread oldThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("旧线程启动");
            }
        });
        oldThread.start();

        // Lambda - 创建线程
        Thread lambdaThread = new Thread(() -> {
            System.out.println("Lambda线程启动");
        });
        lambdaThread.start();

        System.out.println("主线程结束");
    }

    /**
     * Lambda 是为了消除单方法接口实现的匿名内部类；
     * Lambda 要求实现的接口中只有一个抽象方法，像上面的Runnable接口就只有一个run方法，如果一个接口中有多于一个抽象方法，则不能写成Lambda的形式；
     * 这是jdk8新引入的函数式接口的概念，函数式接口就是 有且仅有一个抽象方法的接口；
     * 更多函数式接口概念参考chapter2.functionalInterface；
     */

    /**
     * Lambda 表达式：
     *  (T args) -> {
     *        代码块
     *   }
     *
     *  参数args可以是零个或多个
     *  参数类型可指定，可省略（根据表达式上下文推断）
     *  参数包含在圆括号中，多个时用逗号分隔
     *  代码块可以是零条或多条语句,包含在花括号中
     *  代码块只有一条语句时,花括号可省略
     */

}
