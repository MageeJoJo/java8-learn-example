package com.maji.chapter2.functionalInterface;


public class ImplTest {
    public static void main(String[] args) {
        DefaultImpl defaultImpl = new DefaultImpl();
        OverrideImpl overrideImpl = new OverrideImpl();
        defaultImpl.defaultMethod();
        overrideImpl.defaultMethod();
    }
}
