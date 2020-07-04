package com.saket.javafunctionalprogramming.optionals;

import java.util.Optional;

public class _Optional {

    public void testOptional() {
        Object value = Optional.ofNullable("Hello there")
                .orElseGet(() -> "Optional Default Value");
        System.out.println(value.toString());
    }

    public void checkIfPresent() {
        Optional.ofNullable("Hello")
                .ifPresent(value -> System.out.println("Optional check if present -" + value));
    }
}
