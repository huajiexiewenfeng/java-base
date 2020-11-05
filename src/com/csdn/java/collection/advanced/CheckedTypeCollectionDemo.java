package com.csdn.java.collection.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedTypeCollectionDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        // 可以骗过编译器 插入非 Integer 类型的元素
        List referencedValues = numbers;
        referencedValues.add("A");

        for (Object value : referencedValues) {
            System.out.println(value);
        }

        List<Integer> checkedTypeValues = Collections.checkedList(numbers, Integer.class);

        referencedValues = checkedTypeValues;

        System.out.println(referencedValues == numbers);

        System.out.println(referencedValues == checkedTypeValues);

        referencedValues.add("B");//ClassCastException

    }
}
