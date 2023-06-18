package com.starpg.service;

import java.util.List;

import com.starpg.model.Person;


public interface PersonService {
	
	public List<Person> findAllPersons();
	
	public Person findPersonById(Long personid);
	
	public Person savePerson(Person person);
	

}
