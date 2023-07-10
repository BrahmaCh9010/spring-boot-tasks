package com.staybook.model;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Header header;
	private ArrayList<Education> education;
	private ArrayList<Experience> experience;
	private Map<String, String> skills;
	private ArrayList<Project> projects;

}
