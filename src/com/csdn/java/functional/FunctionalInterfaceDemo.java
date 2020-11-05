package com.csdn.java.functional;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Function1 function1 = ()->{

        };

        FunctionalInterfaceWithoutAnnotation function2 = ()->{

        };

    }

    @FunctionalInterface
    public interface Function1 {

        void execute();

        default String getDescription(){
            return String.valueOf(this);
        }

    }

    // @FunctionalInterface 并非必选
    public interface FunctionalInterfaceWithoutAnnotation{
        void execute();
    }
}
