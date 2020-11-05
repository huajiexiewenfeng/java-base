package com.csdn.java.functional;


public class ActionDemo {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello,World");
            }
        };

        // invokedynamic 指令 @since jdk 1.7
        // java.lang.invoke.MethodHandle
        // java.lang.invoke.InvokeDynamic
        Runnable runnable2 = ()->{
            System.out.println("Hello,World");
        };
        runnable.run();
    }

}
