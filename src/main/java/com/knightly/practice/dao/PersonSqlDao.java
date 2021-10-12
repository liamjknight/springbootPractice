package com.knightly.practice.dao;

import com.knightly.practice.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository("sqlServer")
public class PersonSqlDao implements PersonDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

    private DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/practice");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        return dataSource;
    }

    @Override
    public List<Person> getAll() {
        List<Person> results = new ArrayList<>();
        String sql = "SELECT * FROM Person";

        SqlRowSet response = jdbcTemplate.queryForRowSet(sql);

        while (response.next()){
            Person person = mapToPerson(response);
            results.add(person);
        }

        return results;
    }

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

    private Person mapToPerson(SqlRowSet response) {
        Person result = new Person();

        result.setId(response.getInt("id"));
        result.setName(response.getString("name"));
        result.setAge(response.getInt("age"));
        result.setAddress(response.getString("address"));
        result.setSSN(response.getInt("ssn"));

        return result;
    }
}
