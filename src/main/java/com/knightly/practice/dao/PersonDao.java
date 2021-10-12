package com.knightly.practice.dao;

import com.knightly.practice.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAll();

    List<Person> getPersonById(int id);

    List<Person> getPersonByName(String name);

    void postPerson(Person person);

    void putPerson(int id, Person person);

    void deletePerson(int id);

}
