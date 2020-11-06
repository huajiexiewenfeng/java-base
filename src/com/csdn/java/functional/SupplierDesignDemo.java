package com.csdn.java.functional;

import java.util.function.Supplier;

public class SupplierDesignDemo {

  public static void main(String[] args) {
    level1();
    level2();
    level3();
    level4();
  }

  /**
   * 一般写法
   */
  private static void level1() {
    ehco("Hello,World");
  }

  /**
   * Supplier + lambda
   */
  private static void level2() {
    Supplier<String> supplyMessage = () -> {
      return "lambda-Hello,World";
    };
    ehco(supplyMessage.get());
  }

  /**
   * Supplier 作为 ehco 方法参数
   */
  private static void level3() {
    ehco(SupplierDesignDemo::getMessage);
  }

  /**
   * 执行关系
   */
  private static void level4() {
    getMessage();//及时执行
    Supplier<String> message = supplyMessage();//待执行状态
    message.get();//实际执行
  }

  public static void ehco(String message) {
    System.out.println(message);
  }


  public static String getMessage() {
    return "lazy-Hello,World";
  }

  public static Supplier<String> supplyMessage() {
    return SupplierDesignDemo::getMessage;
  }

  public static void ehco(Supplier<String> message) {
    System.out.println(message.get());
  }

}
