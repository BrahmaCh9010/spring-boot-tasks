package com.starpg.service;

import java.util.List;
import java.util.Optional;

import com.starpg.model.Person;


public interface PersonService {
	
	public List<Person> findAllPersons();
	
	public Optional<Person> findPersonById(Long personid);
	
	public Person savePerson(Person person);
	

}
