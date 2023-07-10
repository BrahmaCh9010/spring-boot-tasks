package com.staybook.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staybook.model.Person;
import com.staybook.service.PersonService;
import com.staybook.utill.PDFGenerator;


@RestController
@RequestMapping("/v1/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
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

		/*
		 * @GetMapping(value = "/persons/pdfGenerate", produces =
		 * MediaType.APPLICATION_PDF_VALUE) public ResponseEntity<InputStreamResource>
		 * personPDFGenerate() throws IOException { List<Person> persons =
		 * (List<Person>) personService.findAllPersons();
		 * 
		 * //ByteArrayInputStream bis = PDFGenerator.customerPDFReport(persons);
		 * 
		 * HttpHeaders headers = new HttpHeaders(); headers.add("Content-Disposition",
		 * "inline; filename=persons.pdf");
		 * 
		 * // return
		 * ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).
		 * body(new InputStreamResource(bis)); }
		 */
}
