package com.starpg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starpg.dao.PersonDAO;
import com.starpg.model.Person;
import com.starpg.service.PersonService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/v1/person")
@SecurityRequirement(name = "bearerAuth")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonDAO personDao;
	
	@GetMapping(value="/persons" )
	public ResponseEntity<List<Person>> findAllPersons() {

		List<Person> modelList = personService.findAllPersons();
		return new ResponseEntity<List<Person>>(modelList, HttpStatus.OK);
	}
	
	@GetMapping("/persons/{Id}")
	public ResponseEntity<Optional<Person>> findPersonById(@PathVariable("Id") Long personid) {


			return new ResponseEntity<>(personService.findPersonById(personid),HttpStatus.OK);
	}
	@PostMapping("/addPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person personDto) {		
		return new ResponseEntity<>(personService.savePerson(personDto), HttpStatus.OK);
	}
	
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable(value = "id") Long personid) {

		Optional<Person> personOptional = personService.findPersonById(personid);

		if (personOptional.isPresent()) {
			Person _person = personOptional.get();
			_person.setAadhaarNumber(person.getAadhaarNumber());
			_person.setPanNumber(person.getPanNumber());
			_person.setPersonFatherName(person.getPersonFatherName());
			_person.setPersonName(person.getPersonName());
			_person.setPhoneNumber(person.getPhoneNumber());
			_person.setVoterId(person.getVoterId());
			return new ResponseEntity<>(personService.savePerson(_person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Long personid) {
	    try {
	    	personService.deleteById(personid);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}