package com.csdn.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericWildcardsTypeDemo {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        upperBoundedWildcards(numbers);
        unBoundedWildcards(numbers);
//        lowerBoundedWildcards(numbers);
    }

    // PECS
    // producer(生产者) 用 extends
    // consumer(消费者) 用 super
    private static void lowerBoundedWildcards(List<? extends Number> producer,List<? super Number> consumer){
        for (Number e : producer) {
            System.out.println(e);
        }

        consumer.add(1);
        consumer.add(Short.valueOf((short) 2));
        consumer.add(Integer.valueOf(3));
        consumer.add(Long.valueOf(4L));

    }

    private static void unBoundedWildcards(List<Number> numbers){
        // 完全通配类型
        // 在运行时与非通配泛型会出现方法签名冲突，因为两者都是相同声明类型
        // 完全通配类型，可以适配任意类型，比如集合
        // 反而具体类型泛型会限制类型范围
        unBoundedWildcardsDemo(numbers);
    }

    private static void upperBoundedWildcards(List<Number> numbers){
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 1, (byte) 2);
        List<Short> shorts = Arrays.asList((short) 2, (short) 3);
        List<Integer> integers = Arrays.asList(3, 4, 5);

        numbers.addAll(bytes);// ? extends Number
        numbers.addAll(shorts);// ? extends Number
        numbers.addAll(integers);// ? extends Number

        // 被操作（处理）的对象，需要更为抽象的类型，Number
        // 待整合（输入）的对象，可以是具体的类型
        upperBoundedWildcardsDemo(numbers, System.out::println);
    }

    // 完全通配类型
    public static void unBoundedWildcardsDemo(Iterable<?> iterable){//泛型擦写，导致和下面方法冲突
        for (Object e : iterable) {
            System.out.println(e);
        }
    }

//    public static void println(Iterable<Object> iterable){//泛型擦写，导致和下面方法冲突
//        for (Object e : iterable) {
//            System.out.println(e);
//        }
//    }

    public static void upperBoundedWildcardsDemo(Iterable<? extends Number> list, Consumer<Object> consumer) {
        for (Object e : list) {
            consumer.accept(e);
        }
    }
}
