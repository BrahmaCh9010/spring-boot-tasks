package com.staybook.service;

import java.util.List;
import java.util.Optional;

import com.staybook.model.Person;

public interface PersonService {
	
	public List<Person> findAllPersons();
	
	public Optional<Person> findPersonById(Long personid);
	
	public Person savePerson(Person person);

	public void deleteById(Long personid);
	

}
