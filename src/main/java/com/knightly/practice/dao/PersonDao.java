package com.knightly.practice.dao;

import com.knightly.practice.model.Person;

public interface PersonDao {

    Person getPerson(int id);

    Person getPerson(String name);

    int postPerson(Person person);

    int putPerson(int id, Person person);

    int deletePerson(int id);

}
