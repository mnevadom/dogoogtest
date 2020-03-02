package com.udemy.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backend.converter.ContactConverter;
import com.udemy.backend.model.ContactModel;
import com.udemy.backend.respositories.ContactRepository;

@Service("contactService")
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepos;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter converter;

	@Override
	public ContactModel addContact(ContactModel contactM) {
		return converter.entity2model(contactRepos.save(converter.model2entity(contactM)));
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<ContactModel> models = new ArrayList<ContactModel>();
		contactRepos.findAll().stream().forEach(c-> models.add(converter.entity2model(c)));
		
		return models;
	}

	@Override
	public ContactModel findContactById(int id) {
		return converter.entity2model(contactRepos.findById(id));
	}

	@Override
	public void removeContact(int id) {
		ContactModel contact = findContactById(id);
		if (contact != null)
			contactRepos.delete(converter.model2entity(contact));
	}

}
