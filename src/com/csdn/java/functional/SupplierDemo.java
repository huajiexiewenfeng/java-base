package com.csdn.java.functional;

import java.util.function.Supplier;

/**
 * @author xiewenfeng
 */
public class SupplierDemo {

  public static void main(String[] args) {
    Supplier<Long> supplier = getLong();
    System.out.println(supplier.get());
  }

  /**
   * 第一种写法
   *
   * @return
   */
  public static Supplier<Long> getLong() {
    return () -> {
      return System.currentTimeMillis();
    };
  }

  /**
   * 第二种写法
   *
   * @return
   */
  public static Supplier<Long> getLongOther() {
    return System::currentTimeMillis;
  }
}
