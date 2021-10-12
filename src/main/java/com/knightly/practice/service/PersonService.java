package com.knightly.practice.service;

import com.knightly.practice.dao.PersonDao;
import com.knightly.practice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("sqlServer") PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAll() { return personDao.getAll(); }

    public List<Person> getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    public List<Person> getPersonByName(String name) {
        return personDao.getPersonByName(name);
    }

    public void postPerson(Person person) {
        personDao.postPerson(person);
    }

    public void putPerson(int id, Person person) {
        personDao.putPerson(id, person);
    }

    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }
}
