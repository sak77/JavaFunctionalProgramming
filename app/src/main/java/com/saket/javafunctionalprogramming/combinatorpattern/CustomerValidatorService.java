package com.saket.javafunctionalprogramming.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    //Dummy method to validate email address
    private boolean isEmailValid(String emailId) {
        return emailId.contains("@");
    }

    //Dummy method to validate phone number
    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }

    //Dummy method to validate dob
    private boolean isAdultCustomer(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    //Combine 3 validations above into a single public method
    public boolean isCustomerValid(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhoneNumber())
                && isAdultCustomer(customer.getDob());
    }

}
