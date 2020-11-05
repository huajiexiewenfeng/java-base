package com.csdn.java.lesson2;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String value1 = "Hello";
        String value2 = new String("Hello");
        System.out.println(value1 + "===" + value2);

        //从 Java 1.5 开始可以通过反射修改对象的属性
        //修改 String
        char[] chars = "World".toCharArray();
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(value2, chars);
        System.out.println(value1 + "===" + value2);
    }

    /**
     * 原生 String 是 final 修饰
     * - 为了保护 String 的不变性
     * - 在 API 发生变化的时候，不用每个新的方法都标识 final 防止有子类继承修改
     */
    public static class ExtendableString{
        /** The value is used for character storage. */
        private final char value[];

        /** Cache the hash code for the string */
        private int hash; // Default to 0

        public ExtendableString(char[] value) {
            this.value = value;
        }

        public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }
    }
}
