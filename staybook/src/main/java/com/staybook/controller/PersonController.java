package com.staybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staybook.model.Person;
import com.staybook.service.PersonService;

@Controller
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> findAllPersons() {

		List<Person> modelList = personService.findAllPersons();
		return new ResponseEntity<List<Person>>(modelList, HttpStatus.OK);
	}
	 @GetMapping("/persons/{Id}")
	public ResponseEntity<Person> findPersonById(@PathVariable("Id") Long id) {
		Person dto = personService.findPersonById(id);
		return new ResponseEntity<Person>(dto, HttpStatus.OK);
		
	}
	
}
