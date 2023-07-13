package com.staybook.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staybook.dao.PersonDAO;
import com.staybook.model.Person;
import com.staybook.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonDAO personDao;
	
	@Override
	public List<Person> findAllPersons() {
		log.info("Person details getting successful");
		return personDao.findAll();
	}

	@Override
	public Optional<Person> findPersonById(Long personid) {
		Optional<Person> entity = personDao.findById(personid);
		if (entity.isPresent()) {
			log.info("Person details getting by id successful");
			return entity;
		}
		else {
			log.info("Person details are empty");
		return Optional.empty();
		}
	}

	@Override
	public Person savePerson(Person person) {
		return personDao.save(person);
	}

	@Override
	public void deleteById(Long personid) {
		Optional<Person> person = personDao.findById(personid);
		if(person.isPresent()) {
			personDao.deleteById(personid);
		}
		else {
			log.debug(" person not find to delete");
		}
	}

}
