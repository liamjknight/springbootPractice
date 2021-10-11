package com.knightly.practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final int id;
    private final String name;
    private final int age;
    private final String address;
    private final long SSN;

    public Person(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("age") int age,
                  @JsonProperty("address") String address,
                  @JsonProperty("ssn") long SSN) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
