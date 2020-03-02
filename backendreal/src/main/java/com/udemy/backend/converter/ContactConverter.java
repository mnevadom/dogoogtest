package com.udemy.backend.converter;

import org.springframework.stereotype.Component;

import com.udemy.backend.entity.Contact;
import com.udemy.backend.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public Contact model2entity(ContactModel model) {
		Contact entity =  new Contact();
		entity.setCity(model.getCity());
		entity.setTelephone(model.getTelephone());
		entity.setFirstname(model.getFirstname());
		entity.setLastname(model.getLastname());
		entity.setId(model.getId());
		
		return entity;
	}

	public ContactModel entity2model(Contact entity) {
		ContactModel model = new ContactModel();
		
		model.setCity(entity.getCity());
		model.setTelephone(entity.getTelephone());
		model.setFirstname(entity.getFirstname());
		model.setLastname(entity.getLastname());
		model.setId(entity.getId());
		
		return model;
	}
}
