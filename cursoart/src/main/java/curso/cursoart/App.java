package curso.cursoart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import curso.cursoart.beans.CursoConfig;
import curso.cursoart.beans.HolaConfig;
import curso.cursoart.beans.Mundo;
import curso.cursoart.beans.Persona;

public class App 
{
    public static void main( String[] args ) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(HolaConfig.class, CursoConfig.class);
    	
    	Mundo m1 = (Mundo)context.getBean("mundo1");
    	
    	Persona p1 = (Persona) context.getBean("pers1");
    	
    	System.out.println(m1.getSaludo());
    	System.out.println(p1.toString());
    }
}
