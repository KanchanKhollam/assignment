package com.crudoperation.service;

import java.util.List;

import com.crudoperation.dto.Person;

public interface PersonServiceInterf {

	public void deletePerson(Long id);

	public Person updatePerson(Long id, Person updatedPerson);

	public Person createPerson(Person person);

	public Person getPersonById(Long id);

	public List<Person> getAllPersons();

}
