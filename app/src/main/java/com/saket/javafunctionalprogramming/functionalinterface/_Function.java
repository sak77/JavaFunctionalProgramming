package com.saket.javafunctionalprogramming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public _Function() {

    }

    //Function takes 1 input and returns 1 output <T, R>
    public static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    //Function takes one number and returns number * 10
    public static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    //Bi Function is a function that takes 2 arguments <T, V> and returns an output R.
    public static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (num1, num2) -> (num1 + 1) * num2;

    //Function to increment number by 1 - imperative way
    public int incrementByOne(int number) {
        return number + 1;
    }

    //Function to increment number and multiply by second number - imperative way
    public int incrementByOneAndMultiply(int number, int numberToMultiply) {
        return (number + 1) * numberToMultiply;
    }



}
