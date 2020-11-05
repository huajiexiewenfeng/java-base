package com.csdn.java.collection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeepCloneDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> values = new ArrayList<>();
        values.add("1");
        values.add("2");
        values.add("3");

        List<String> shallowclone = (ArrayList<String>) values.clone();
        displayDiff(values, shallowclone);

        System.out.println("===============");

        List<String> deepclone = deepClone(values);
        displayDiff(values, deepclone);

        System.out.println("===============");

        List<String> deepclone2 = deepCloneInJavaSerizlization(values);
        displayDiff(values, deepclone2);
    }

    private static void displayDiff(List<String> values, List<String> clone) {
        for (int i = 0; i < values.size(); i++) {
            System.out.printf("Objects equals: %s\n", Objects.equals(values.get(i), clone.get(i)));
            System.out.printf("Object ==: %s\n", values.get(i) == clone.get(i));
        }
    }

    private static List<String> deepClone(List<String> source) {
        List<String> clone = new ArrayList<>(source.size());
        for (String value : source) {
            clone.add(new String(value));
        }
        return clone;
    }

    private static List<String> deepCloneInJavaSerizlization(List<String> source) throws IOException, ClassNotFoundException {
        List<String> copy = new ArrayList<>(source);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        // 序列化字节
        objectOutputStream.writeObject(copy);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        List<String> clone = (List<String>) objectInputStream.readObject();

        return clone;
    }
}
