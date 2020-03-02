package com.udemy.backend.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backend.constant.ViewConstant;
import com.udemy.backend.model.ContactModel;
import com.udemy.backend.service.ContactService;

@Controller
@RequestMapping("/contacts")
//@PreAuthorize("permitAll()")
public class ContactController {
	
	private static final Log log = LogFactory.getLog(ContactController.class);
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	
//	@PreAuthorize("permitAll()")
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole...")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/contactform")
	public String redirectContactForm(Model model,
			@RequestParam(name="id", required = false) int id
			) {
		
		ContactModel contact = new ContactModel();
		if (id != 0)
			contact = contactService.findContactById(id);
		
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
	
		return ViewConstant.CONTACTS;
	}
	
	@PostMapping("/addcontact")
	public String addContact(
			@ModelAttribute(name= "contactModel") ContactModel contactModel, 
			Model model
			) {
		
		log.info("-- PARAMS: " + contactModel.toString());
		
		if (null != contactService.addContact(contactModel))
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		
		return mav;
	}
	
	@GetMapping("/remove")
	public ModelAndView removeContact(
			@RequestParam(name="id", required = true) int id,
			Model model
			) {
		
		contactService.removeContact(id);
		
		model.addAttribute("delRes", 1);
		
		return showContacts();
	}
	
}
