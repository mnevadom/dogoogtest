package com.udemy.backend.service;

import java.util.List;

import com.udemy.backend.model.ContactModel;

public interface ContactService {

	public ContactModel addContact(ContactModel contactM);
	
	public List<ContactModel> listAllContacts();
	
	public ContactModel findContactById(int id);
	
	public void removeContact(int id);
}
