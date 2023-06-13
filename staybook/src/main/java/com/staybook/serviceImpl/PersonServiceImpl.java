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
		
		return personDao.findAll();
	}

	@Override
	public Person findPersonById(Long personid) {
		Optional<Person> entity = personDao.findById(personid);
		if (entity.isPresent())
			return entity.get();
		return null;
	}

}
