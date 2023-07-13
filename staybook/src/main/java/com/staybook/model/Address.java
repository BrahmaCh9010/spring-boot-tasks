package com.staybook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;

@Entity
@Setter
@Data
@Table(name = "address", schema = "public")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;	
	private String houseNo;
	private String state;	
	private String city;	
	private String landmark;	
	private String street;	
	private Integer pincode; 
}
