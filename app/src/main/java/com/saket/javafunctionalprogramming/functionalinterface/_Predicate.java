package com.saket.javafunctionalprogramming.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {


    //Simple phone validation imperative function
    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //Predicate is a function that takes one argument and returns a boolean
    public static Predicate<String> isPhoneNumberValidPredicate = number -> number.startsWith("07") && number.length() == 11;

    //Just like functions, you can also chain predicates using and() and or()
    public static Predicate<String> contains3Predicate = number -> number.contains("3");


    //Bi-predicates are predicates which take 2 arguments instead of one and return a boolean response.
}
