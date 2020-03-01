package com.udemy.backend.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backend.model.UserCredential;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	
	@GetMapping("/login")
	// tiene que obtener un modelandview. porque desde la vista login, reenvio a login
	// y no se le está pasando el objeto de tipo userCredential que en teoría está gestionando la vista
	public String showLoginForm(
			Model mav,
			@RequestParam(name="error", required = false) String error
			) {
		
		LOG.info("ERROR is  " + error);
		
		mav.addAttribute("error", error);
		mav.addAttribute("userCredential", new UserCredential());
		
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(
			@ModelAttribute("userCredential") UserCredential userCredential
			) {
		
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("password")){
			return "contacts";
		}
		
		return "redirect:/login?error";
	}
}
