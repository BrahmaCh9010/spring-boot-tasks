package com.staybook.service;

import java.util.List;

import com.staybook.model.Person;

public interface PersonService {
	
	public List<Person> findAllPersons();
	
	public Person findPersonById(Long personid);
	

}
