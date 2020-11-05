package com.csdn.java.lesson1;

import java.util.List;

public class GenericTypeDemo {

    /**
     * @param <S> 来源类型
     * @param <T> 目标类型
     */
    public static interface Converter<S, T> {
        T convert(S source);
    }

    public static void main(String[] args) {

    }

    /**
     * 方法签名 #doConvert(List)
     * @param values
     */
    public static void doConvert(List<String> values){

    }

//    /**
//     * 方法签名 #doConvert(List)
//     * 签名冲突
//     * @param values
//     */
//    public static void doConvert(List values){
//
//    }
}
