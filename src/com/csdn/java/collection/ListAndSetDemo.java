package com.csdn.java.collection;

import java.util.HashSet;
import java.util.Set;

public class ListAndSetDemo {
    public static void main(String[] args) {
        // HashSet 并不能保存顺序
        Set<String> values = new HashSet<>();
        // 字母场景
        values.add("a");
        values.add("b");
        values.add("c");
        values.forEach(System.out::println);
        values.clear();
        // 数字场景
        values.add("3");
        values.add("2");
        values.add("1");
        values.forEach(System.out::println);
        // 数字场景
        Set<Integer> ints = new HashSet<>();
        ints.add(3);
        ints.add(2);
        ints.add(1);
        ints.forEach(System.out::println);
        // 以上例子都是 ASCII 码
        // HashSet 或者 HashMap 采用对象 HashCode
        // String hashCode 由 char[] 数组构建
        /**
         *     public int hashCode() {
         *         int h = hash;
         *         if (h == 0 && value.length > 0) {
         *             char val[] = value;
         *
         *             for (int i = 0; i < value.length; i++) {
         *                 h = 31 * h + val[i];
         *             }
         *             hash = h;
         *         }
         *         return h;
         *     }
         */
        // 在 Java 中 char(2字节) 相对应 int(4字节)
        //汉字通过 2个 char（4字节），用一个int（4字节）

    }
}
