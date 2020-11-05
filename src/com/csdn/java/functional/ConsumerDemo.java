package com.csdn.java.functional;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("xwf");
        Consumer<String> consumer2 = ConsumerDemo::echo;
        // Fluent API
        consumer2.andThen(consumer).andThen(consumer).accept("222");
    }

    public static void echo(String str) {
        System.out.println("echo:"+str);
    }
}
