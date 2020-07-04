package com.saket.javafunctionalprogramming.functionalinterface;

import java.util.function.Supplier;

public class _Supplier {


    //Simple function that returns some url
    public static String gettutorialUrl() {
        return "https://www.youtube.com/watch?v=VRpHdSFWGPs&t=4850s";
    }

    //Using Supplier - it takes no arguments but returns a value
    public static Supplier<String> getTutorialUrlSupplier = () -> "https://www.youtube.com/watch?v=VRpHdSFWGPs&t=4850s";
}
