package com.knightly.practice;

import com.knightly.practice.model.Person;
import com.knightly.practice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
	private final PersonService personService;

	@Autowired
	public HelloController(@Qualifier("personService") PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/")
	public List<Person> index() { return personService.getAll(); }

	@GetMapping("/person/id/{id}")
	public List<Person> getPersonById(@PathVariable int id){
		return personService.getPersonById(id);
	}

	@GetMapping("/person/name/{name}")
	public List<Person> getPersonByName(@PathVariable String name){
		return personService.getPersonByName(name);
	}
//TODO: Fix issue where posting throws 415 wrong media format
	@PostMapping("/person")
	public void postPerson(@RequestBody Person person){
		personService.postPerson(person);
	}
//TODO: Fix issue where putting throws 415 wrong media format
	@PutMapping("/person/{id}")
	public void putPerson(@PathVariable int id, @RequestBody Person person){
		personService.putPerson(id, person);
	}

	@DeleteMapping("/person/{id}")
	public void putPerson(@PathVariable int id){
		personService.deletePerson(id);
	}
}
