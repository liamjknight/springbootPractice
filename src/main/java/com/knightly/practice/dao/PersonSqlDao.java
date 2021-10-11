package com.knightly.practice.dao;

import com.knightly.practice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sqlServer")
public class PersonSqlDao implements PersonDao{
    private List<Person> peopleList;

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public Person getPerson(String name) {
        return null;
    }

    @Override
    public int postPerson(Person person) {
        return 0;
    }

    @Override
    public int putPerson(int id, Person person) {
        return 0;
    }

    @Override
    public int deletePerson(int id) {
        return 0;
    }
}
