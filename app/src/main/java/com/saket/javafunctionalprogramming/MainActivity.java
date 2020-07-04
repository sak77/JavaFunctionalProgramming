package com.saket.javafunctionalprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.saket.javafunctionalprogramming.combinatorpattern.Customer;
import com.saket.javafunctionalprogramming.combinatorpattern.CustomerRegistrationValidator;
import com.saket.javafunctionalprogramming.combinatorpattern.CustomerValidatorService;
import com.saket.javafunctionalprogramming.finalsection.HigherOrderFunctions;
import com.saket.javafunctionalprogramming.functionalinterface._Consumer;
import com.saket.javafunctionalprogramming.functionalinterface._Function;
import com.saket.javafunctionalprogramming.functionalinterface._Predicate;
import com.saket.javafunctionalprogramming.functionalinterface._Supplier;
import com.saket.javafunctionalprogramming.optionals._Optional;
import com.saket.javafunctionalprogramming.streams._Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.saket.javafunctionalprogramming.MainActivity.GENDER.*;
import static com.saket.javafunctionalprogramming.combinatorpattern.CustomerRegistrationValidator.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List of Persons
        List<Person> people = Arrays.asList(
                new Person("Tom", MALE),
                new Person("Nina", FEMALE),
                new Person("Philson", MALE),
                new Person("Jessica", FEMALE),
                new Person("Ashok", MALE),
                new Person("Saket", MALE)
        );

        //Now find all the females in this list

        //1. Imperative approach is where the developer has to specify every step in detail
        System.out.println("Imperative approach");
        //Create new list for females
        List<Person> females = new ArrayList<>();
        //Loop through the list
        for (Person person : people) {
            //if gender is female then add it to list of females
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        //Display females in the list
        for (Person currentPerson : females) {
            System.out.println("Name is : " + currentPerson.name);
        }

        System.out.println("Declarative approach");
        //2. Declarative approach .i.e. functional style programming

        people.stream()         //Stream allows us to go into an abstract mode, where we simply tell it what we want
                .filter(person -> FEMALE.equals(person.gender)) //filter takes a predicate as an argument. Predicate is a functional interface with one abstract method that takes a boolean input and returns a value.
                .collect(Collectors.toList())   //add results to a list
                .forEach(person -> System.out.println("Name is " + person.name));  //print output

        //Functions in FI
        System.out.println("FUNCTIONS");
        _Function function = new _Function();
        System.out.println("FUNCTIONS increment imperative - " + function.incrementByOne(0));

        int increment = _Function.incrementByOneFunction.apply(0);
        System.out.println("FUNCTIONS increment declarative - " + increment);
        int multiply = _Function.multiplyBy10Function.apply(increment);  //Multiply output of increment by 10
        System.out.println("FUNCTIONS multiply declarative - " + multiply);
        //Instead of calling the functions sequentially, we can combine them using andThen()
        Function<Integer, Integer> addBy1AndMultiplyBy10Function = _Function.incrementByOneFunction.andThen(_Function.multiplyBy10Function);

        int number = addBy1AndMultiplyBy10Function.apply(0); //This should give same output as above
        System.out.println("FUNCTIONS addThen - " + number);

        //Bi functions
        System.out.println("FUNCTIONS increment and then multiply imperative way - "  +function.incrementByOneAndMultiply(1, 4));

        //Using Bi-Functions
        int biresult = _Function.incrementByOneAndMultiplyBiFunction.apply(1, 4);
        System.out.println("FUNCTIONS bifunctions - " + biresult);


        //Consumers
        //Imperative
        _Consumer.greetCustomer(new _Consumer.Customer("Saket", "99999"));

        //Using consumers
        _Consumer.greetCustomerConsumer.accept(new _Consumer.Customer("Philson", "888785"));

        //Bi Consumers
        //First imperatively greet customer
        _Consumer.greetCustomer(new _Consumer.Customer("Tom", "6767676"), false);
        //Using Bi Consumer
        _Consumer.greetCustomerConditonallyBiFunction.accept(new _Consumer.Customer("Jessica","4525852"), false);

        //Predicates
        System.out.println("Imperative approach to isPhoneNumber valid " + _Predicate.isPhoneNumberValid("07000000000"));
        System.out.println("Imperative approach to isPhoneNumber valid " + _Predicate.isPhoneNumberValid("0900987730"));

        //Using predicates
        System.out.println("Using Predicates to check isPhoneNumber is valid - " + _Predicate.isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println("Using Predicates to check isPhoneNumber is valid - " + _Predicate.isPhoneNumberValidPredicate.test("0900987730"));

        //Chaining predicates using and() and or()
        boolean result1 = _Predicate.isPhoneNumberValidPredicate.and(_Predicate.contains3Predicate).test("07000000003");
        System.out.println("Chaining predicates response  - " + result1);
        boolean result2 = _Predicate.isPhoneNumberValidPredicate.or(_Predicate.contains3Predicate).test("07000000000");
        System.out.println("Chaining predicates response  - " + result2);
        boolean result3 = _Predicate.isPhoneNumberValidPredicate.and(_Predicate.contains3Predicate).test("070000000");
        System.out.println("Chaining predicates response  - " + result3);

        //Supplier
        System.out.println("Get Connection url from supplier - " + _Supplier.getTutorialUrlSupplier.get());


        //Streams allow you to work with sequence of elements.
        //They work with Functional Interface
        _Streams streams = new _Streams();
        streams.printGenders();
        streams.printNames();
        System.out.println("List has Only females- " + streams.hasOnlyFemales());
        System.out.println("List has Any females- " + streams.hasAnyFemales());
        System.out.println("List has no prefer not say gender - " + streams.hasNoPreferNotSay());

        //Optionals work with individual objects and also help to determine if they are null or not..
        _Optional _optional = new _Optional();
        System.out.println("Testing Optional");
        _optional.testOptional();
        _optional.checkIfPresent();

        //Combinator Pattern

        //First we validate customer using imperative way
        Customer customer1 = new Customer("Bharat", "bharat.k@gmail.com",
                "+019723124", LocalDate.of(2000, 1, 1));
        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println("Customer Validator imperative - " + customerValidatorService.isCustomerValid(customer1));

        //Now doing same using combinator pattern
        ValidatorResponse response = isEmailValid
                .and(isPhoneNumberValid)
                .and(isAdult)
                .apply(customer1);

        System.out.println("Customer Validator combinator - " + response);

        //Higher order functions..
        HigherOrderFunctions higherOrderFunctions = new HigherOrderFunctions();
        higherOrderFunctions.hello("Harold", null, value -> {
            System.out.println("No last name defined for " + value);
        });

        higherOrderFunctions.hello2("Harold",
                null,
                () -> System.out.println("No last name defined"));
    }


    static class Person {
        private final String name;
        
        private final GENDER gender;

        Person(String name, GENDER gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum GENDER {
        MALE("male"), FEMALE("female");
        GENDER(String male) {
        }
    }
}