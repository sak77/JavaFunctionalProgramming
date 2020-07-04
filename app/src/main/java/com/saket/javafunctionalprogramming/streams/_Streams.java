package com.saket.javafunctionalprogramming.streams;

import com.saket.javafunctionalprogramming.MainActivity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.saket.javafunctionalprogramming.streams._Streams.GENDER.MALE;
import static com.saket.javafunctionalprogramming.streams._Streams.GENDER.FEMALE;
import static com.saket.javafunctionalprogramming.streams._Streams.GENDER.PREFER_NOT_TO_SAY;

public class _Streams {

    List<Person> people;
    public _Streams () {
        //List of Persons
        people = Arrays.asList(
                new Person("Tom", MALE),
                new Person("Nina", FEMALE),
                new Person("Philson", MALE),
                new Person("Jessica", FEMALE),
                new Person("Ashok", MALE),
                new Person("Saket", MALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );
    }


    public void printGenders() {
        //Stream takes us to an abstraction mode. Learn more about Java Streams API.
        people.stream()
                .map(person -> person.gender)  //map function simply transforms the data being streamed..
                .collect(Collectors.toSet())    //toSet() Removes duplicates
                .forEach(gender -> System.out.println("Gender - " + gender));
    }

    public void printNames() {
        //Stream takes us to an abstraction mode. Learn more about Java Streams API.
        people.stream()
                .map(person -> person.name)  //map function simply transforms the data being streamed..
                .mapToInt(name -> name.length())    //you can use another map to get length of the name
                .forEach(length -> System.out.println("Name length - " + length));
    }

    //using allMatch to return if list has only females
    public boolean hasOnlyFemales() {
        return people.stream().allMatch(person -> FEMALE.equals(person.gender));
    }

    //using anyMatch to return if list has any females
    public boolean hasAnyFemales() {
        return people.stream().anyMatch(person -> FEMALE.equals(person.gender));
    }

    //using noneMatch to return if list has no members with gender Prefer Not Say.
    //It seems like a negative of allMatch().
    public boolean hasNoPreferNotSay() {
        return people.stream().noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));
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
        MALE("male"), FEMALE("female"), PREFER_NOT_TO_SAY("na");
        GENDER(String male) {
        }
    }

}
