package com.csdn.java.method;

import java.util.*;

public class MethodReturnTypeDemo {

    // 面向对象-> 封装，继承，多态
    // 方法返回值（多态，封装）
    // 原则一：返回类型需要抽象，除 Object
    // 抽象返回类型的意义，调用方法（接收方）容易处理
    // 越具体，越难通用

    //返回一个去重有序集合
    private TreeSet<String> getValues() {//错误写法
        return new TreeSet<>();
    }

    // 动词 + 形容词 + 名词
    private SortedSet<String> getSortedValues() {//正确写法
        return new TreeSet<>();
    }

    // 如果返回类型是集合的话，Collection 优于 List 或者 Set
    // 如果不考虑写操作，Iterable 优于 Collection

    // 原则二：尽可能的返回 Java 集合框架内的接口，尽量避免数组
    // 1. Collection 比较 [] 而言，拥有更多的操作方法，比如 add
    // 2. Collection 返回的时候可以限制只读，而 [] 不行
    public static List<Integer> getErrorNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    // 原则三：确保集合返回接口只读
    public static List<Integer> getNumbers() {
        return Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5));
    }

    // 数组可以保证长度不变，但是无法保证只读
    private static Integer[] getNumbersArray() {
        return new Integer[]{1, 2, 3, 4, 5};
    }

    // 原则四：确保返回快照
    public static List<Integer> getNumbersSnaphot() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    // 技巧：如果需要返回快照集合，尽量使用 ArrayList

    private static void pritnArray(Integer[] numbers) {
        for (Integer number : numbers) {
            System.out.print(number + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> numbers = getErrorNumbers();
        // numbers.add(6); //java.lang.UnsupportedOperationException
        System.out.println(numbers);
        // 尽管在 add 方法操作时，抛出异常吗，但是 Arrays#asList 并非只读
        numbers.set(3, 10);
        System.out.println(numbers);

        List<Integer> numbers2 = getNumbers();
//        numbers2.set(3, 10);//java.lang.UnsupportedOperationException
        System.out.println(numbers2);

        Integer[] numbers3 = getNumbersArray();
        pritnArray(numbers3);
        numbers3[3] = 10;
        pritnArray(numbers3);

    }

}
