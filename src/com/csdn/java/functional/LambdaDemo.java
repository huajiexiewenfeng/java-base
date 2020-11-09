package com.csdn.java.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: xiewenfeng
 * @Date: 2020/11/9 19:46
 */
public class LambdaDemo {

  public static void main(String[] args) {
    // 只出不进
    Supplier<String> supplier = LambdaDemo::getMessage;
    // 只进不出
    Consumer<String> consumer = LambdaDemo::printlnMessage;
    // 有进有出
    Function<Integer,String> function = LambdaDemo::integerToString;
    // 判断
    Predicate<Integer> predicate = LambdaDemo::existNumber;
    // Action 隐藏类型 不进不出
    Runnable runnable = ()->{

    };
  }

  public static String getMessage() {
    return "xwf";
  }

  public static void printlnMessage(String msg) {
    System.out.println(msg);
  }

  public static String integerToString(Integer number) {
    return String.valueOf(number);
  }

  public static Boolean existNumber(Integer number) {
    return true;
  }

}
