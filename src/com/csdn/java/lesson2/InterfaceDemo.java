package com.csdn.java.lesson2;

import java.io.Serializable;
import java.util.stream.Stream;

public class InterfaceDemo {

    public static void main(String[] args) {
       //强类型约束
    }

    private static void println(Serializable cs) {
        System.out.println(cs.toString());
    }

    private static void println(CharSequence cs) {
        System.out.println(cs.toString());
    }
}
