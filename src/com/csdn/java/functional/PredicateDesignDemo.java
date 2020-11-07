package com.csdn.java.functional;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateDesignDemo {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Collection<Integer> even = filter(numbers, PredicateDesignDemo::condition);
    even.forEach(System.out::println);

    List<Integer> collect = Stream.of(1, 2, 3, 4, 5).filter(num -> {
      return num % 2 == 0;
    }).collect(Collectors.toList());

    System.out.println(collect);
  }

  private static boolean condition(Integer number) {
    if (number % 2 == 0) {
      return false;
    } else {
      return true;
    }
  }

  private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {
    // 集合类操作，请不要直接利用参数
    List<E> copy = new ArrayList<>(source);
    Iterator<E> iterator = copy.iterator();
    while ((iterator).hasNext()) {
      E element = iterator.next();
      if (predicate.test(element)) {
        iterator.remove();
      }
    }
    return Collections.unmodifiableList(copy);
  }
}
