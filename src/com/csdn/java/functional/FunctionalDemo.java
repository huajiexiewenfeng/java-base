package com.csdn.java.functional;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalDemo {
    public static void main(String[] args) {

        Function<String,Long> function1 = Long::valueOf;
        Long res1 = function1.apply("1");
        System.out.println(res1);

        Function<Long,String> function2 = String::valueOf;
        String res2 = function2.apply(13L);
        System.out.println(res2);

        // "1" -> 1L -> "1"
        Long value =  function1.compose(String::valueOf).apply(1L);
    }

    public static void echo(String str) {
        System.out.println(str);
    }
}
