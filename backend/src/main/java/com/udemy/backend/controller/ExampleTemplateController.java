package com.udemy.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backend.components.ExampleComponent;
import com.udemy.backend.model.Person;
import com.udemy.backend.services.ExampleService;

@Controller
@RequestMapping("/exampletemplate")
public class ExampleTemplateController {
	
	public static final String EXAMPLE_TEMPLATE_VIEW = "exampletemplate";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exComponent;
	

	// primera forma de retornar plantilla
	@GetMapping(value="/exampleString")
	public String exampleString(Model model) {
		// el string es la vista a retornar
		// no es necesario añadir el .html
		model.addAttribute("name", "Jon");
		model.addAttribute("person", new Person("Jon", 23));
		
		
		exComponent.sayHello();
		
		model.addAttribute("people", exampleService.getListPeople());
		
		return EXAMPLE_TEMPLATE_VIEW;
	}
	
	// otra forma es devolver el model and view
	// esto del get es lo mismo que de arriba
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_TEMPLATE_VIEW);
		mav.addObject("name", "Mike");
		mav.addObject("person", new Person("Mike", 30));
		mav.addObject("people", exampleService.getListPeople());
		
		return mav;
	}
	
}
