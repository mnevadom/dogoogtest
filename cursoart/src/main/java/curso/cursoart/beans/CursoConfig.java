package curso.cursoart.beans;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoConfig {

	@Bean
	public Persona pers1() {
		Persona mario = new Persona("1", "Mario", "Nevado");
		mario.setOrigen(españa());
		return mario;
	}
	
	@Bean
	public Pais españa() {
		Pais españa = new Pais("España");
		españa.setCiudades(ciudadesEspaña());
		return españa;
	}
	
	@Bean
	public List<Ciudad> ciudadesEspaña(){
		return Arrays.asList(madrid(), sevilla());
	}
	
	@Bean
	public Ciudad madrid() {
		return new Ciudad("Madrid");
	}
	
	@Bean
	public Ciudad sevilla() {
		return new Ciudad("Sevilla");
	}
}
