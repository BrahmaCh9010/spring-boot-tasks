package com.starpg.model;

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
	private Long personId;
	
	private String personName;
	
	private String personFatherName;
	
	private Long phoneNumber;
	
	private String panNumber;
	
	private Long aadhaarNumber;
	
	private Integer voterId;
}
