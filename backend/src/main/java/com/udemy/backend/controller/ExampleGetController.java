package com.udemy.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exampleGet")
public class ExampleGetController {
	
	private static final String EX_GET = "exampleget";

	//localhost:8080/exampleget/request1?nm=JON
	@GetMapping("/request1")
	// por defecto el required lo lleva a true
	// se le puede añadir por defecto
	public ModelAndView request1(
			@RequestParam(name="nm", required = false, defaultValue = "sin nombre") String name
			) {
		ModelAndView mav = new ModelAndView(EX_GET);
		mav.addObject("nm_model", name);
		
		
		return mav;
	}
	
	
	// otra forma de hacerlo: 
	
	// localhost:8080/exampleget/request2/JON
	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(
			@PathVariable("nm") String name
			) {
		ModelAndView mav = new ModelAndView(EX_GET);
		mav.addObject("nm_model", name);
		
		
		return mav;
	}
}
