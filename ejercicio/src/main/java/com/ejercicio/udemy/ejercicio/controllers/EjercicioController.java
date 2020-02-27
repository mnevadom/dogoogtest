package com.ejercicio.udemy.ejercicio.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ejercicio.udemy.ejercicio.services.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	private static final Log LOG = LogFactory.getLog(EjercicioController.class);
	
	private static final String SHOW_VIEW = "showlog";
	private static final String RELLENA_VIEW = "rellenalog";

	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejService;
	
	@GetMapping("/rellenalog")
	public ModelAndView rellenaLog() {
		
		ModelAndView view = new ModelAndView(RELLENA_VIEW);
		
		return view;
	}
	
	@PostMapping("/showlog")
	public ModelAndView showLog(
			@ModelAttribute("msg") String msg
			) {
		ModelAndView view = new ModelAndView(SHOW_VIEW);
		
		LOG.info("msg is " +  msg);
		
		String log = ejService.showLog();
		
		view.addObject("log", log);
		view.addObject("msg", msg);
		
		return view;
	}
	
}
