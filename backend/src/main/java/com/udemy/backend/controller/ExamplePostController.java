package com.udemy.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("person", new Person());
		return SHOW_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(
			// el nombre que tenga en el html que nos llama
			@ModelAttribute("person") Person person
			) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("personresult", person);
		
		
		return mav;
	}
}
