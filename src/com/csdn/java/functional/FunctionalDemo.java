package com.csdn.java.functional;

import java.util.function.Function;

public class FunctionalDemo {

  public static void main(String[] args) {
    displayCompose();
  }

  /**
   * String -> Integer
   */
  public static void level1() {
    Function<String, Integer> function = Integer::valueOf;
    Integer res = function.apply("1");
    System.out.println(res);
  }

  /**
   * Long -> String
   */
  public static void level2() {
    Function<Long, String> function = String::valueOf;
    String res = function.apply(13L);
    System.out.println(res);
  }

  /**
   * compose
   */
  public static void displayCompose() {
    Function<String, Integer> function = Integer::valueOf;

    // 1 -> "1" -> 1
    Integer value = function.compose(String::valueOf).apply(1);
    System.out.println(value);
  }

}
