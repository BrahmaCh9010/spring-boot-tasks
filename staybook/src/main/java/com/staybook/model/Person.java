package com.staybook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "person", schema = "staybook")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="person_id")
	private Long personId;
	
	//@Column(name="person_name")
	private String personName;
	
	//@Column(name="person_father_name")
	private String personFatherName;
	
	//@Column(name="phone_number")
	private Long phoneNumber;
	
	//@Column(name="pan_number")
	private String panNumber;
	
	//@Column(name="aadhaar_number")
	private Long aadhaarNumber;
	
	//@Column(name="voter_id")
	private String voterId;
}
