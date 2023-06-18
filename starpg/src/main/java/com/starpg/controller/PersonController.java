package com.starpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starpg.model.Person;
import com.starpg.service.PersonService;


@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value="/persons" )
	public ResponseEntity<List<Person>> findAllPersons() {

		List<Person> modelList = personService.findAllPersons();
		return new ResponseEntity<List<Person>>(modelList, HttpStatus.OK);
	}
	
	@GetMapping("/persons/{Id}")
	public ResponseEntity<Person> findPersonById(@PathVariable("Id") Long id) {
		Person dto = personService.findPersonById(id);
		return new ResponseEntity<Person>(dto, HttpStatus.OK);
		
	}
	
	@PostMapping("/addPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person personDto) throws Exception {		
		Person person = personService.savePerson(personDto);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}