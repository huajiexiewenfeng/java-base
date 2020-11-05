package com.csdn.java.thread;

public class HowToStopThreadDemo {
    public static void main(String[] args) {
        StoppableAction action = new StoppableAction();
        Thread thread = new Thread(action);

        thread.start();

        action.stop();
    }

    private static class StoppableAction implements Runnable {
        @Override
        public void run() {
            for (;;){
                System.out.println("执行任务...");
                if (stopped) {
                    System.out.println("终止任务...");
                    return;
                }

            }
        }

        /**
         * 确保变量的可见性
         */
        private volatile boolean stopped;

        public void stop() {
            this.stopped = true;
        }
    }
}
