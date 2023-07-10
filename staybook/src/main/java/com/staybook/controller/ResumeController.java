package com.staybook.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.staybook.model.Resume;
import com.staybook.utill.PDFGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path = "/api")
public class ResumeController {
	
	private PDFGenerator pDFGenerator;

	@PostMapping(path = "/resume")
	public ResponseEntity<String> postResume(@Valid @RequestBody Resume resume) throws IOException {

		log.info("<==============> Headers <=================>"+resume.getHeader());
		log.info("<==============> Experience <==============>"+resume.getExperience());
		log.info("<==============> Education <===============>"+resume.getEducation());
		log.info("<==============> Projects <================>"+resume.getProjects());
		log.info("<==============> Skills <==================>"+resume.getSkills());
		return new ResponseEntity<String>(pDFGenerator.createDocument(resume), HttpStatus.OK);
	}

	@GetMapping(path = "/resumefile")
	public ResponseEntity<byte[]> getResume(@RequestParam("filename") String filename) throws IOException {

		return new ResponseEntity<byte[]>(pDFGenerator.getDocument(filename), HttpStatus.OK);
	}
}
