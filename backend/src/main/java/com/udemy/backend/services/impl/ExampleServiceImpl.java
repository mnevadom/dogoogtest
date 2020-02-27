package com.udemy.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backend.model.Person;
import com.udemy.backend.services.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Mario", 36));
		people.add(new Person("Maria", 31));
		
		LOG.info("Hello from service");

		return people;
	}

}
