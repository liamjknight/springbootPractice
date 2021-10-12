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
        List<Person> result = new ArrayList<>();
        String sql = "SELECT * FROM Person";

        SqlRowSet response = jdbcTemplate.queryForRowSet(sql);

        while (response.next()) {
            Person person = mapToPerson(response);
            result.add(person);
        }

        return result;
    }

    @Override
    public List<Person> getPersonById(int id) {
        List<Person> result = new ArrayList<>();
        String sql = "SELECT * FROM Person WHERE id = ?";

        SqlRowSet response = jdbcTemplate.queryForRowSet(sql, id);

        while (response.next()) {
            Person person = mapToPerson(response);
            result.add(person);
        }

        return result;
    }

    @Override
    public List<Person> getPersonByName(String name) {
        List<Person> result = new ArrayList<>();
        String sql = "SELECT * FROM Person WHERE name = ?";

        SqlRowSet response = jdbcTemplate.queryForRowSet(sql, name);

        while (response.next()) {
            Person person = mapToPerson(response);
            result.add(person);
        }

        return result;
    }

    @Override
    public void postPerson(Person person) {
        String sql = "INSERT INTO Person (name, age, address, ssn)" +
                     "Values (?, ?, ?, ?)";

        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getAddress(), person.getId());
    }

    @Override
    public void putPerson(int id, Person person) {
        String sql = "UPDATE Person SET" +
                     "name = ?," +
                     "age = ?," +
                     "address = ?," +
                     "ssn = ?" +
                     "WHERE id == ?";

        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getAddress(), person.getId(), id);
    }

    @Override
    public void deletePerson(int id) {
        String sql = "DELETE FROM Person WHERE id = ?";

        jdbcTemplate.update(sql, id);
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
