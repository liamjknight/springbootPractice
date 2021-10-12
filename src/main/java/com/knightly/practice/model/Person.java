package com.knightly.practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int id;
    private String name;
    private int age;
    private String address;
    private long SSN;

    public Person(){}

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

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public long getSSN() { return SSN; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }
}
