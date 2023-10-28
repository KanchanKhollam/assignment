package com.crudoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crudoperation.dto.Person;
import com.crudoperation.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@GetMapping("{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personService.getPersonById(id);
		return ResponseEntity.ok(person);
	}

	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person createdPerson = personService.createPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
	}

	@PutMapping("{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
		Person person = personService.updatePerson(id, updatedPerson);
		return ResponseEntity.ok(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return ResponseEntity.noContent().build();
	}
}
