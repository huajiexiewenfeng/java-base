package com.csdn.java.functional;

import java.util.function.Function;

public class FunctionalDesginDemo {
    public static void main(String[] args) {
        Function function = a -> a;

        Function<Integer,Integer> function2 = a -> a / 2;
        Integer apply = function2.apply(4);
        System.out.println(apply);
    }

}
