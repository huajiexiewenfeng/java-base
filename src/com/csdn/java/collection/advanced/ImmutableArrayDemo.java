package com.csdn.java.collection.advanced;

import java.util.Arrays;

public class ImmutableArrayDemo {

    public static void main(String[] args) {
        User[] values = of(new User(1L), new User(2L), new User(3L));

        // 数组的 Copy 与集合对象的 Clone 是类似，浅克隆
        // 如果需要只读数组的话，需要深度 clone
        User[] valuesCopy = Arrays.copyOf(values, values.length);

        for (int i = 0; i < valuesCopy.length; i++) {
            System.out.println(values[i] == valuesCopy[i]);
        }

        valuesCopy[0].setId(99L);

        //输出原数组
        System.out.println(Arrays.toString(values));
    }

    private static User[] of(User... values) {
        return values;
    }

    private static class User {
        private Long id;

        public User(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }

}
