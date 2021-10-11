package com.knightly.practice.dao;

import com.knightly.practice.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAll();

    Person getPerson(int id);

    Person getPerson(String name);

    int postPerson(Person person);

    int putPerson(int id, Person person);

    int deletePerson(int id);

}
