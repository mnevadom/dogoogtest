package com.udemy.backend.services;

import java.util.List;

import com.udemy.backend.model.Person;

public interface ExampleService {
	
	public abstract List<Person> getListPeople();
	
}
