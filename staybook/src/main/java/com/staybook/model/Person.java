package com.staybook.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "person", schema = "public")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	
	private String personName;
	
	private String personFatherName;
	
	private Long phoneNumber;
	
	private String panNumber;
	
	private Long aadhaarNumber;
	
	private Long voterId;
	
	 // Mapping to the other table
    @OneToMany(cascade = CascadeType.ALL)
	private Set<Address> personAddress;
	
}
