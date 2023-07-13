package com.staybook.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staybook.model.Person;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
	


}
