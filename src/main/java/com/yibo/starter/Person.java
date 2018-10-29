package com.yibo.starter;

import java.util.StringJoiner;

public class Person {
    private PersonProperties properties;

    public Person(PersonProperties properties) {
        this.properties = properties;
    }

    public Person() {

    }

    public String getPersonName() {
        return properties.getName();
    }

    public int getPersonAge() {
        return properties.getAge();
    }

    public String getPersonSex() {
        return properties.getSex();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name=" + getPersonName())
                .add("age=" + getPersonAge())
                .add("sex=" + getPersonSex())
                .toString();
    }
}