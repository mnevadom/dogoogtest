package com.ejercicio.udemy.ejercicio.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService{
	
	private static final Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);

	@Override
	public String showLog() {
		LOG.info("Im inside the service");
		
		return "Mostrado Log";
	}
	
}
