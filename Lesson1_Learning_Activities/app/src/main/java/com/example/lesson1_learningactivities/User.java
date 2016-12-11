package com.example.lesson1_learningactivities;

import java.io.Serializable;

/**
 * Created by eladlavi on 11/12/2016.
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName, lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
