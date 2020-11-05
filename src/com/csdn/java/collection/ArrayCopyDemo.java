package com.csdn.java.collection;

import java.util.Set;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        String[] strings1 = new String[]{"Hello", "World"};
        String[] strings2 = new String[]{};
        arraycopy(strings1,strings2);
        System.out.println(strings2.toString());

    }

    public static void arraycopy(Object[] src, Object destination) {

    }
}
