package com.saket.javafunctionalprogramming.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.saket.javafunctionalprogramming.combinatorpattern.CustomerRegistrationValidator.*;

/**
 * Combinator design pattern is a pattern that links functions to create a new function.
 * This function can take a function parameter and also can return a function.
 * Here we use combinator pattern
 */
public interface CustomerRegistrationValidator extends Function<Customer, ValidatorResponse> {

    enum ValidatorResponse {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

    //So here we define different instances of CustomerRegistrationValidator interface
    CustomerRegistrationValidator isEmailValid =
            customer -> customer.getEmail().contains("@") ? ValidatorResponse.SUCCESS : ValidatorResponse.EMAIL_NOT_VALID;

    CustomerRegistrationValidator isPhoneNumberValid =
            customer -> customer.getPhoneNumber().startsWith("+0") ? ValidatorResponse.SUCCESS : ValidatorResponse.PHONE_NUMBER_NOT_VALID;

    CustomerRegistrationValidator isAdult =
            customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
                    ValidatorResponse.SUCCESS : ValidatorResponse.IS_NOT_AN_ADULT;

    //Interface can have default methods
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        //return instance of CustomerRegistrationValidator with input of type Customer and return ValidatorResponse.
        return customer -> {
            ValidatorResponse response = this.apply(customer);
            return response.equals(ValidatorResponse.SUCCESS) ? other.apply(customer) : response;
        };
    }

}
