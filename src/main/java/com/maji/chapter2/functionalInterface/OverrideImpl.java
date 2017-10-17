package com.maji.chapter2.functionalInterface;

/**
 * 覆盖defaultMethod
 */
public class OverrideImpl implements FunctionInterface{

    @Override
    public void abstractMethod() {

    }

    @Override
    public void defaultMethod() {
        System.out.println("impl default");
    }
}
