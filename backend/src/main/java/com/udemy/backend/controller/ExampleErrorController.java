package com.udemy.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exampleerror")
public class ExampleErrorController {

	@GetMapping("/err404")
	public ModelAndView getError404() {
		return new ModelAndView("404");
	}
	
	@GetMapping("/err500")
	public ModelAndView getError500() {
		int i = 6/0;
		
		// da igual lo que retorna porque no va a llegar
		return new ModelAndView("500");
	}
}
