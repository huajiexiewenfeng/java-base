package com.csdn.java.collection.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafeDemo {

    public static void main(String[] args) {
        failFastDemo();
        failSafeDemo();
    }

    private static void failSafeDemo() {
        removeForEach(new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3)));
    }

    private static void failFastDemo() {
        removeForEach(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    private static void removeForEach(Collection<?> values) {
        try {
            // 如果是 Fail-Fast 设计的话，会抛出 ConcurrentModificationException 异常，比如 ArrayList
            // 如果是 Fail-Safe 设计的话，没有关系
            for (Object value : values) {
                values.remove(value);
            }
            System.out.printf("[%s]集合删除成功，目前大小为[%d]\n", values.getClass().getName(), values.size());
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast 异常:" + values.getClass().getName());
        }
    }

}
