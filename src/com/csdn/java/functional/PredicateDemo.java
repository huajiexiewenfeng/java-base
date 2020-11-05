package com.csdn.java.functional;


import java.io.File;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        Predicate<File> predicate = FileFilter::accpet;
        System.out.println(predicate.test(new File("/aaa")));

    }

    static class FileFilter {
        static boolean accpet(File path) {
            return true;
        }
    }

}

