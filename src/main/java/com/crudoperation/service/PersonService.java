package com.crudoperation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.dto.Person;
import com.crudoperation.exception.PersonNotFoundException;
import com.crudoperation.repo.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceInterf {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		logger.info("Fetching all persons");
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		logger.info("Retrieving person with ID: {}", id);
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Person with ID " + id + " not found"));
	}

	@Override
	public Person createPerson(Person person) {
		logger.info("Creating a new person: {}", person);
		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(Long id, Person updatedPerson) {
		logger.info("Updating person with ID: {}", id);
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			Person existingPerson = optionalPerson.get();
			existingPerson.setFirstName(updatedPerson.getFirstName());
			existingPerson.setLastName(updatedPerson.getLastName());
			existingPerson.setEmail(updatedPerson.getEmail());
			existingPerson.setAge(updatedPerson.getAge());
			return personRepository.save(existingPerson);
		} else {
			throw new PersonNotFoundException("Person with ID " + id + " not found");
		}
	}

	@Override
	public void deletePerson(Long id) {
		logger.info("Deleting person with ID: {}", id);
		personRepository.deleteById(id);
	}
}
