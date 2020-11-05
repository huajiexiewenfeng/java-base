package com.csdn.java.method;

import java.util.Collection;

public class MethodArgumentsDemo {
    public static void main(String[] args) {
        // arguments 通常形容方法参数
        // parameters 通常指的是外部媒介传递过来，请求参数

    }

    private int value;
    // 方法参数名称设计
//    public boolean equals(Object that){
//        return this.value == ((MethodArgumentsDemo)that).value;
//    }

    public boolean equals(Object another) {
        return this.value == ((MethodArgumentsDemo) another).value;
    }

    // 对等方式 - 单项传输
    public void copy(Object source, Object target) {

    }

    // 非对等方式(参数类型) - 单项传输
    public void add(Collection<Object> collection, Object element) {

    }

    // 非对等方式(参数类型) - 多项传输

    /**
     * @param collection collection
     * @param elements   zero or more elements(0..n)
     */
    public void add(Collection<Object> collection, Object... elements) {

    }

    /**
     * @param collection collection
     * @param one        one elements
     * @param elements   zero or more elements(0..n)
     */
    public void add(Collection<Object> collection, Object one, Object... elements) {

    }

    public void addAll(Collection<Object> destination, Collection<Object> source) {
        destination.addAll(source);
    }

    // Effective Java 建议不要超过 4 个参数

}
