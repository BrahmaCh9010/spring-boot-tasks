package com.staybook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	private String degree;
	private String majors;
	private String period;
	private String location;
	private String gpa;
}
