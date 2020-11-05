package com.csdn.java.collection;

import java.util.*;

public class MapAndSetDemo {
    public static void main(String[] args) {
        //通常 Set 是 Map Key 的实现，Set 底层运用 Map 实现
        // 比如 HashSet 底层运用了 HashMap
        Map<String,Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        //TreeSet 底层运用了 TreeMap
        map = new TreeMap<>();
        set = new TreeSet<>();

    }
}
