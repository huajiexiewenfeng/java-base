package com.csdn.java.thread;

public class DumpThreadDemo {
    public static void main(String[] args) {

        // Throwable API
        new Throwable().printStackTrace(System.out);

        // Thread API
        Thread.dumpStack();
    }
}
