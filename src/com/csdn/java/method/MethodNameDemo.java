package com.csdn.java.method;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MethodNameDemo {
    public static void main(String[] args) throws InterruptedException {
        // 动词 + 形容词
        // 副词形容词
        Stream.of(1,2,3).forEachOrdered(System.out::println);

        Lock lock = new ReentrantLock();
        // 动词 + 副词
        lock.lockInterruptibly();

    }

    // 动词 + 名词
    private List<String> getValues(){
        return Collections.emptyList();
    }

    // 动词 + 名词 + 副词
    private List<String> getValuesSynchronously(){
        return Collections.emptyList();
    }

    public class ViewRender {//名称 视图渲染

        public void render() {//动词

        }

        // 并发渲染
        public void renderConcurrently() {//动词+副词

        }

        // 同步渲染
        public void renderSynchronously() {//动词+副词

        }

    }
}
