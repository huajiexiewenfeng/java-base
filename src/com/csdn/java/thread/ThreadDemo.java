package com.csdn.java.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        // Thread 实现 Runnable
        // 如果没有传递 Runnable 对象实现，空执行
        Thread thread =new Thread(ThreadDemo::sayHello);
        thread.start();
    }

    private static void sayHello(){
        System.out.printf("线程 [Id:%s] : Hello,World\n", Thread.currentThread().getId());
    }
}
