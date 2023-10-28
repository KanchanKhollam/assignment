package com.crudoperation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudoperation.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
