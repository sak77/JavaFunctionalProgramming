package com.saket.javafunctionalprogramming.finalsection;

import java.util.function.Consumer;

public class HigherOrderFunctions {



    //Higher order functions are methods that take a function as a parameter and/or return a function as a parameter.

    //Higher order functions can be used to pass callback functions to the function
    public void hello(String firstName, String lastName, Consumer<String> callback) {
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    //You can also use a functional interface that does not accept any values
    public void hello2(String firstName, String lastName, Runnable runnable) {
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            runnable.run();
        }
    }

}
