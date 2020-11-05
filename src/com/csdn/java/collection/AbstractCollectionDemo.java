package com.csdn.java.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class AbstractCollectionDemo {
    public static void main(String[] args) {
        abstractList();
    }

    private static void abstractList() {
        // 返回了 Arrays.ArrayList 不允许写操作，但是允许下标数据交换
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        assert numbers instanceof AbstractList;
        numbers.add(0);//UnsupportedOperationException
        numbers.set(0,8);
        numbers.forEach(System.out::println);
    }
}
