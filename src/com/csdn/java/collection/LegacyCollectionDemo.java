package com.csdn.java.collection;

import java.util.*;

public class LegacyCollectionDemo {
    public static void main(String[] args) {
        // 1.几乎所有的实现都是线程安全
        vectorVsList();
        vectorVsStack();
        hashtableVsHashMap();
        EnumerationVsEnum();
        bitSet();
    }

    private static void bitSet() {
        // BitSet 用于位运算集合操作，可以搭配 NIO ByteBuffer
    }

    private static void EnumerationVsEnum() {
        // Enumeration 主要是用于迭代
        String value = "1,2,3";
        StringTokenizer tokenizer = new StringTokenizer(value,",");

        Enumeration enumeration = tokenizer;

        while(enumeration.hasMoreElements()){
            String element = String.valueOf(enumeration.nextElement());
            System.out.println(element);
        }

    }

    private static void hashtableVsHashMap() {
        // Hashtable
        // 1.实现 Dictionary 和 Map 接口
        // 2.线程安全
        // 3.不允许 null 的 value 和 Key 会抛出 NullPointerException
        // ConcurrentHashMap 也不允许value 和 Key 为nul
        // 如果 ConcurrentHashMap 的 value 为空，在查询数据的时候，无法判断是是线程不可见还是本身数据为 null
        // HashMap 实现 Map 接口
        // 1.线程非安全（写操作）
        // 2.value 和 Key 都可以为 null

        Hashtable hashtable = new Hashtable();
//        hashtable.put(null,1); key 不能为空
//        hashtable.put(1,null);
//        hashtable.put(null,null);

        HashMap hashMap = new HashMap();
        hashMap.put(null,1);
        hashMap.put(1,null);
        hashMap.put(null,null);

    }

    private static void vectorVsStack() {
        // Vector 是 FIFO
        // Stack 是 LIFO , Stack 继承了 Vector

    }

    private static void vectorVsList() {
        // Vector 数组实现，对比 ArrayList 也实现了 List
        // Vector 所有操作线程安全，使用关键字 synchronized 修饰
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();
        // 如果 Vector 在方法内部使用的话，synchronized 修饰后的方法基本上没有线程切换的消耗
    }
}
