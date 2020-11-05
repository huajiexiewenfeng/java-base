package com.csdn.java.functional;

import java.util.function.Supplier;

public class SupplierDesignDemo {
    public static void main(String[] args) {
        ehco("Hello,World");

        ehco(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "lazy-Hello,World";
        });

        ehco(SupplierDesignDemo::getMessage);

        getMessage();//及时执行

        Supplier<String> message = supplyMessage();//待执行状态

        message.get();//实际执行
    }

    public static String getMessage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "lazy-Hello,World";
    }

    public static Supplier<String> supplyMessage() {
        return SupplierDesignDemo::getMessage;
    }

    public static void ehco(String message) {
        System.out.println(message);
    }

    public static void ehco(Supplier<String> message) {
        System.out.println(message.get());
    }
}
