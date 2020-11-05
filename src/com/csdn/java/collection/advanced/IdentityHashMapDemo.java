package com.csdn.java.collection.advanced;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        // 如果类覆盖了 Object 的 equals(Object) 方法，那么 hashCode() 方法需不需要覆盖？
        // 答案：不强制覆盖，建议实现,注意不要将 hashCode() 作为 equals 方法的实现，可参考
        // Objects.hash(Object...) 以及 Arrays.hashCode(Object[])，hashCode 是一个计算较重的方法, equals 尽量不要依赖于它。
        // equals 方法通常是做对象属性的比较


        // 如果类覆盖了 Object 的 hashCode() 方法，那么 equals(Object) 方法需不需要覆盖？
        // hashCode() 是用于 Hash 计算，比如普通的 HashMap，由于 hashCode() 可能返回相同的数据
        // 原因一：int 数据范围 2^31-1 原因而：hashCode() 方法计算问题，可能会产生冲突
        // 当不同对象 hashCode() 相同时，再做对象的 equals(Object) 方法比较,所以必须覆盖实现

        hashMapDemo();

        identityHashMapDemo();

        String a = "A";
        String b = new String("A");
        demoIdentityHashCodeAndHashCode(a, b);
    }

    private static void demoIdentityHashCodeAndHashCode(Object a, Object b) {
        System.out.printf("System identityHashCode(%s) == %d\n", a, System.identityHashCode(a));
        System.out.printf("Object.hashCode() == %d\n", a.hashCode());

        System.out.printf("System identityHashCode(%s) == System identityHashCode(%s)：%s\n", a, b, System.identityHashCode(a) == System.identityHashCode(b));
        System.out.printf("a.hashCode() == b.hashCode()：%s\n", a.hashCode() == b.hashCode());
    }

    private static void identityHashMapDemo() {
        Map<String, Integer> identityMap = new IdentityHashMap<>();
        identityMap.put("A", 1);
        identityMap.put(new String("A"), 2);
        System.out.println(identityMap.size());
    }

    private static void hashMapDemo() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put(new String("A"), 2);
        System.out.println(map.size());
    }

    private String name;

    private String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityHashMapDemo that = (IdentityHashMapDemo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
