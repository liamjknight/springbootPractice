package com.knightly.practice.service;

import com.knightly.practice.dao.PersonDao;
import com.knightly.practice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("sqlServer") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPerson(int id) {
        return personDao.getPerson(id);
    }

    public Person getPerson(String name) {
        return personDao.getPerson(name);
    }

    public int postPerson(Person person) {
        return personDao.postPerson(person);
    }

    public int putPerson(int id, Person person) {
        return personDao.putPerson(id, person);
    }

    public int deletePerson(int id) {
        return personDao.deletePerson(id);
    }
}
