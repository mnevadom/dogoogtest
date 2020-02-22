package curso.cursoart.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolaConfig {
	
	@Bean
	public Mundo mundo1() {
		return new Mundo();
	}

}
