package com.udemy.backend.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backend.model.Person;

@Controller
@RequestMapping("/examplepost")
public class ExamplePostController {
	
	private static final Log LOGGER = LogFactory.getLog(ExamplePostController.class);
	
	private static final String SHOW_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	// redirigir
	//#1
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/examplepost/showform";
//	}
	
	//#2
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/examplepost/showform");
	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		
		
		model.addAttribute("person", new Person());
		return SHOW_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(
			// el nombre que tenga en el html que nos llama
			@Valid
			@ModelAttribute("person") Person person, BindingResult bindingResult
			) {
		
		ModelAndView mav = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			mav.setViewName(SHOW_VIEW);
		}else {
			LOGGER.info("METHOD : 'addPerson' -- PARAMS: '" + person.toString() + "'");
			
			mav.setViewName(RESULT_VIEW);
			mav.addObject("personresult", person);
			
			LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
		}
		
		return mav;
	}
}
