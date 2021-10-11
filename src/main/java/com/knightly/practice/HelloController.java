package com.knightly.practice;

import com.knightly.practice.model.Person;
import com.knightly.practice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	private final PersonService personService;

	@Autowired
	public HelloController(@Qualifier("personService") PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id){
		return personService.getPerson(id);
	}

	@GetMapping("/person/{name}")
	public Person getPerson(@PathVariable String name){
		return personService.getPerson(name);
	}

	@PostMapping("/person")
	public int postPerson(@RequestBody Person person){
		return personService.postPerson(person);
	}

	@PutMapping("/person/{id}")
	public int putPerson(@PathVariable int id, @RequestBody Person person){
		return personService.putPerson(id, person);
	}

	@DeleteMapping("/person/{id}")
	public int putPerson(@PathVariable int id){
		return personService.deletePerson(id);
	}
}
