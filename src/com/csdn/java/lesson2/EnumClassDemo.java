package com.csdn.java.lesson2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class EnumClassDemo {
    public static void main(String[] args) {
        // Q1: THREE 到底是第几个定义的
        // Q2: 能否输出所有的成员
        println(Counting.ONE);

        // Q3: 为什么枚举会输出成员名称
        println(CountingEnum.ONE);

        printEachMembers(CountingEnum.ONE);

        printEnumMeta(CountingEnum.THREE);

//        Counting.values(Counting.ONE);

        printEachMembers(Counting.ONE);
    }

    public static void println(Counting counting) {
        System.out.println(counting);
    }


    public static void println(CountingEnum counting) {
        System.out.println(counting);
    }

    public static void printEachMembers(CountingEnum enumeration) {
//        CountingEnum[] values = enumeration.values();
//        for (CountingEnum e : values) {
//            System.out.println(e);
//        }

        Stream.of(enumeration.values()).forEach(System.out::println);
    }

    public static void printEachMembers(Counting counting) {
//        CountingEnum[] values = enumeration.values();
//        for (CountingEnum e : values) {
//            System.out.println(e);
//        }

        Stream.of(counting.values()).forEach(System.out::println);
    }

    public static void printEnumMeta(Enum enumeration) {
        // 说明任何枚举都是扩展了 java.lang.Enum
        System.out.println("Enumeration type:" + enumeration.getClass());
        // Enum#name() = 成员名称
        // Enum#ordinal() = 成员定义位置
        System.out.println("member:" + enumeration.name());
        System.out.println("ordinal:" + enumeration.ordinal());
        // values() 方法是 Java 编译器给枚举提升的方式
    }

}


enum CountingEnum {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
    private int value;

    /*private*/ CountingEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CountingEnum{" +
                "value=" + value +
                "} " + super.toString();
    }
}


/**
 * 枚举类：计数
 * 强类型约束（相对于常量）
 */
final class Counting {

    public static final Counting ONE = new Counting(1);

    public static final Counting TWO = new Counting(2);

    public static final Counting THREE = new Counting(3);

    public static final Counting FOUR = new Counting(4);

    public static final Counting FIVE = new Counting(5);

    private int value;

    public Counting(int value) {
        this.value = value;
    }

    private Counting() {

    }

    @Override
    public String toString() {
        return "Counting{" +
                "value=" + value +
                '}';
    }

    /**
     * 实现类似 Enum 中 values() 方法
     */
    public static Counting[] values() {
        Field[] declaredFields = Counting.class.getDeclaredFields();

        return Stream.of(declaredFields).filter(field -> {
            int modifiers = field.getModifiers();
//            return (modifiers & Modifier.PUBLIC) != 0 && (modifiers & Modifier.STATIC) != 0;
            return Modifier.isPublic(modifiers)
                    && Modifier.isStatic(modifiers)
                    && Modifier.isFinal(modifiers);
        }).map(field -> {
            try {
                return (Counting) field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }).collect(toList()).toArray(new Counting[0]);
    }
}