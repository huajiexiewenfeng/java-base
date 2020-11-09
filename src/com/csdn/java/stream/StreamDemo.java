package com.csdn.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        count(1, 2, 3, 4, 5, 6);
//        parallelSort(1, 2, 3, 4, 5, 6);
        map();
    }

    private static void map() {
        List<String> userNames = User.getUsers().stream().map(User::getName)
            .collect(Collectors.toList());
        System.out.println(userNames);
    }



    private static void parallelSort(Integer... numbers) {
        Stream.of(numbers).sorted().parallel().forEach(StreamDemo::println);
    }

    private static void println(Object obj) {
        System.out.printf("[%s] : %s\n", Thread.currentThread().getName(), obj);
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers).reduce(Integer::sum).ifPresent(System.out::println);
    }
}
