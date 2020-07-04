package com.saket.javafunctionalprogramming.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {


    //Imperative approach to greet customer
    public static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    //Imperative approach to greet customer and select if we need to show number
    public static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "******"));
    }

    //Using Consumers - consumers take only one param and do not return any output
    public static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number "
            + customer.customerPhoneNumber);


    //Bi Consumers - are consumers that take 2 arguments but return void
    public static BiConsumer<Customer, Boolean> greetCustomerConditonallyBiFunction = ((customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number "
            + (showPhoneNumber ? customer.customerPhoneNumber : "******")));

    public static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
