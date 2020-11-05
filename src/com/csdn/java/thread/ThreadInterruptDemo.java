package com.csdn.java.thread;

public class ThreadInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        // Thread 实现 Runnable
        // 如果没有传递 Runnable 线程空执行
        Thread thread = new Thread(ThreadInterruptDemo::sayHelloWorld);
        thread.start();
        thread.interrupt();
        thread.join();

        Thread threadLock = new Thread(ThreadInterruptDemo::sayHelloWorldLock);
        threadLock.start();
        threadLock.interrupt();
        threadLock.join();
    }

    public static void sayHelloWorld() {
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("线程中断");
            return;
        }
        System.out.printf("线程 [id : %s] : Hello World\n", Thread.currentThread().getId());
    }

    public static void sayHelloWorldLock() {
        Object monitor = ThreadInterruptDemo.class;
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("线程 [id : %s] : Hello World\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
