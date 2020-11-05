package com.csdn.java.generic;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class GenericParameterTypeDemo {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container("xwf");
        // Integer 不是 CharSequence 的子类
        // Container<Integer> container = new Container("xwf");
        Container<StringBuffer> sb = new Container("xwf");
        System.out.println(sb.element);

        // 编译时：不报错 String 并不是 StringBuffer
        // 运行时：Object
        Container<StringBuffer> b = new Container("hello");
        // 通过构造器传递参数是 String 类型，运行时都是 Object ，没有问题
        System.out.println(b.element);
        // 不过当 b 对象声明的类型为 Container<StringBuffer>
        // E 的类型为 StringBuffer，因此 set(E) E 类型必须为 StringBuffer
        b.set(new StringBuffer("world"));
        System.out.println(b.element);

        List list = new ArrayList<>();
        add(list,"xwf");
//        add(list,1);

        forEach(Arrays.asList("1","2","3"),System.out::println);
    }

    // extends 声明上限， E 的上限类型为 CharSequence
    public static class Container<E extends CharSequence> {
        private E element;

        public Container(E element) {
            this.element = element;
        }

        // operations

        public boolean set(E element) {
            this.element = element;
            return true;
        }

        public E get() {
            return element;
        }
    }

    //多界限泛型参数类型
    public static class C {

    }

    public interface I {

    }

    public interface I2 {

    }


    // 多界限泛型参数类型 extends 的第一个参数类型可以是具体类（也可以是接口）
    // 第二个或者更多参数必须是接口
    public static class Template<T extends C & I & I2> {

    }

    public static class TClass extends C implements Serializable, I, I2 {

    }

    //把一个类型的元素，添加到集合中
    public static <C extends Collection<E>, E extends CharSequence> void add(C target, E elment) {
        target.add(elment);
    }

    public static <C extends Iterable<E>, E extends CharSequence> void forEach(C source, Consumer<E> consumer) {
        for (E e:source) {
            consumer.accept(e);
        }
    }
}
