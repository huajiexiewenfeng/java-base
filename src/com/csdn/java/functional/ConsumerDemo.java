package com.csdn.java.functional;

import java.util.function.Consumer;

public class ConsumerDemo {

  public static void main(String[] args) {
    displayAndThen();
  }

  /**
   * 一般写法
   */
  public static void level1() {
    System.out.println("xwf");
  }

  /**
   * Consumer
   */
  public static void level2() {
    Consumer<String> consumer = System.out::println;
    consumer.accept("xwf");
  }

  /**
   * 自定义方法
   */
  public static void level3() {
    Consumer<String> consumer = ConsumerDemo::echo;
    consumer.accept("xwf");
  }

  /**
   * Consumer#andThen
   */
  public static void displayAndThen() {
    Consumer<String> consumer2 = ConsumerDemo::echo2;

    Consumer<String> consumer3 = ConsumerDemo::echo3;

    Consumer<String> consumer1 = ConsumerDemo::echo;
    // Fluent API
    consumer1.andThen(consumer2).andThen(consumer3).accept("xwf");
  }

  public static void echo(String str) {
    System.out.println("echo1:" + str);
  }

  public static void echo2(String str) {
    System.out.println("echo2:" + str);
  }

  public static void echo3(String str) {
    System.out.println("echo3:" + str);
  }

}
