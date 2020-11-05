package com.csdn.java.lesson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {

    public static void main(String[] args) {
        Test test = () -> {
            System.out.println("111");
        };

        test.run();

    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    private static void stream() {

    }

    // SCFP = Supplier + Consumer + Function + Predicate
    // 四种模式（缺少 Action 模式）
    // Action 模式 有输出 没有输入
    private static void showAction() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Runnable runnable1 = () ->{

        };

        Runnable runnable2 = LambdaDemo::showConsumer;
    }


    // Supplier 模式 有输出 没有输入
    private static void showSupplier() {
        String str1 = "Hello,World";

        Supplier<String> str2 = () -> {
            return "Hello,World";
        };

        Supplier<String> str3 = () -> Integer.valueOf(2).toString();
    }

    // Consumer 模式 有输入 没有输出
    private static void showConsumer() {
        //传统写法
        PropertyChangeListener listener_v1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };

        //lambda 基本写法
        //PropertyChangeListener#propertyChange
        //有入参，没有返回值
        PropertyChangeListener listener_v2 = (evt) -> {
            println(evt);
        };

        //lambda 简略写法
        PropertyChangeListener listener_v3 = LambdaDemo::println;
    }

    // Function 模式 有输出 有输入
    private static void showFunction() {
        Function<String, Integer> f = LambdaDemo::compareTo;
    }

    private static Integer compareTo(String value) {
        return Integer.valueOf(value);
    }

}
