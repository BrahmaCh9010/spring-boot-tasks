package com.starpg.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starpg.dao.PersonDAO;
import com.starpg.model.Person;
import com.starpg.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonDAO personDao;
	
	@Override
	public List<Person> findAllPersons() {
		
		return personDao.findAll();
	}

	@Override
	public Optional<Person> findPersonById(Long personid) {
		Optional<Person> entity = personDao.findById(personid);
		if (entity.isPresent())
			return entity;
		return Optional.empty();
	}

	@Override
	public Person savePerson(Person person) {
		return personDao.save(person);
	}

}
